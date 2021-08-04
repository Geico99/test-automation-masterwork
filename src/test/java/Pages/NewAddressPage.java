package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewAddressPage extends BasePage {

    public NewAddressPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[5]/div[1]/input")
    WebElement addressInput;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[7]/div[1]/input")
    WebElement cityInput;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[9]/div[1]/input")
    WebElement postalCodeInput;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/footer/button")
    WebElement saveButton;

    public void navigateToAddress() {
        driver.get("http://test-automation-shop1.greenfox.academy/addresses");
    }

    public void createNewAddress(String address, String city,
                                 String state, String postalcode, String country) {
        addressInput.sendKeys ( address );
        cityInput.sendKeys ( city );
        Select states = new Select(driver.findElement ( By.name ("id_name") ));
        states.selectByVisibleText ( state );
        postalCodeInput.sendKeys ( postalcode );
        Select countries = new Select ( driver.findElement ( By.name ( "id_country" ) ) );
        countries.selectByVisibleText ( country );
        saveButton.click ();
    }
    public void modifyAddress(String adrs){
        addressInput.clear ();
        addressInput.sendKeys ( adrs );
        saveButton.click ();
    }
}

