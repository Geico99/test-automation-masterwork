
import Pages.AddressPage;
import Pages.HomePage;
import Pages.NewAddressPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TNEW_DataSavingCsv extends BaseTest {

    WebDriver driver;
    WebDriverWait wait;

    @ParameterizedTest
    @Feature("Testing data import")
    @DisplayName ("New addresses from a Csv")
    @CsvFileSource(resources = "/addresses01.csv", numLinesToSkip = 1)
    @Description ("Parameterized test from a txt file and fill addresses")
    public void saveAddressFromCsv
            (String address, String city, String state, String postalCode, String country) {
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        AddressPage addrs = PageFactory.initElements(driver, AddressPage.class);
        NewAddressPage newaddrs = PageFactory.initElements(driver, NewAddressPage.class);
        home.statusControl();
        home.navigatToAddress();
        addrs.toNewAddressPage();
        newaddrs.createNewAddress(address, city, state, postalCode, country);
        Assertions.assertThat(addrs.addNewAddressMessage()).isTrue();
    }
}