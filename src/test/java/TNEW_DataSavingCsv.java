import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TNEW_DataSavingCsv {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver ().setup();
        driver = new ChromeDriver ();
        driver.get("http://test-automation-shop1.greenfox.academy/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 15);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/addresses01.csv", numLinesToSkip = 1)
    public void saveAddress(String address, String city, String postalCode) {

        String email = "kissbelaa@gmail.com";
        String password = "kissbelaalegjobb";

        driver.findElement(By.xpath("//span[contains(text(),'Sign in')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                        ("//input[@name='email' and @class='form-control']"))).sendKeys(email);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
        driver.findElement(By.id("submit-login")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated( By.xpath
                ("//a[@title='View my customer account']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("address-link"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Ecommerce")));
        driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(address);
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
        driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys(postalCode);

        Select state = new Select(driver.findElement(By.name("id_state")));
        state.selectByVisibleText("Alaska");

        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//article[@data-alert='success']/ul/li[contains(text(),'Address successfully added!')]")));
    }

    @AfterEach
    public void cleanup() {
        driver.quit();
    }
}