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

    @AfterEach
    public static void cleanup() {
        driver.quit();
    }

    @Attachment("screenshot")
    public byte[] makeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}