import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@TestInstance ( TestInstance.Lifecycle.PER_CLASS )
public class BaseTest {
    protected static WebDriver driver = null;
    protected static WebDriverWait wait = null;
    protected static JavascriptExecutor js = null;
    private static Properties props = new Properties();

    @BeforeEach
    public static void setUp() throws IOException {
        InputStream is = BaseTest.class.getResourceAsStream("/browser.properties");
        props.load(is);

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(props.getProperty("chrome.arguments"));

        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize ();
        js = (JavascriptExecutor)driver;

        driver.get ( "http://test-automation-shop1.greefox.academy/" );
        wait.until ( ExpectedConditions.visibilityOfElementLocated
                (By.xpath ( "//*[@id=\"footer\"]/div[2]/div/div[3]/div/p/a" )) );

    }

    public void login() {
        String email = "kissbelaa@gmail.com";
        String password = "kisbelaalegjobb";

        driver.findElement ( By.xpath ( "//*[@id=\"_desktop_user_info\"]/div/a/span" ) ).click ();
        wait.until ( ExpectedConditions.elementToBeClickable
                ( By.xpath ( "//*[@id=\"login-form\"]/section/div[1]/div[1]/input" ) ) ).sendKeys ( email );
        driver.findElement ( By.xpath
                ( "//*[@id=\"login-form\"]/section/div[2]/div[1]/div/input" ) ).sendKeys ( password );
        driver.findElement ( By.id ( "submit-login" ) ).click ();
        wait.until ( ExpectedConditions.visibilityOfElementLocated
                ( By.xpath ( "//*[@id=\"_desktop_user_info\"]/div/a[2]/span" ) ) );
    }

    public WebElement addProduct() {
        driver.findElement ( By.xpath ( "//*[@id=\"category-3\"]/a" ) ).click ();
        wait.until ( ExpectedConditions.elementToBeClickable ( By.xpath
                ( "//*[@id=\"js-product-list\"]/div[1]/div[1]/article/div/a/img" ) ) ).click ();
        wait.until ( ExpectedConditions.elementToBeClickable ( By.xpath
                ( "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button" ) ) ).click ();
        wait.until ( ExpectedConditions.elementToBeClickable ( By.xpath
                ( "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a" ) ) ).click ();
        wait.until ( ExpectedConditions.presenceOfElementLocated ( By.xpath
                ( "//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[1]/span/img" ) ) );

        WebElement productInCart = driver.findElement ( By.xpath
                ( "//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[2]/div[1]/a" ) );

        return productInCart;

    }

    @AfterEach
    public static void cleanup() {
        driver.quit();
    }

    @Attachment("screenshot")
    public byte[] makeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}