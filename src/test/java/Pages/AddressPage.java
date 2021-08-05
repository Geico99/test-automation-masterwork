package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressPage extends BasePage {

    public AddressPage(WebDriver driver) {
        super ( driver );
    }

    @FindBy(partialLinkText = "Create new address")
    WebElement linkToCreateNewAddress;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tbody/tr[1]/td[2]/a[2]")
    WebElement deleteFirstAddressButton;

    @FindBy(xpath = "//*[@id=\"address-463\"]/div[2]/a[1]")
    WebElement updateFirstAddressButton;

    @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li")
    WebElement addressMessage;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div[2]/input")
    WebElement continueButton;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[9]/div[1]/input")
    WebElement cityInput;

    public WebElement getCityInput() {
        return cityInput;
    }

    public void toNewAddressPage() {
        linkToCreateNewAddress.click ();
    }

    public boolean isLoaded() {
        return driver.getTitle().equals("Address") && driver.getCurrentUrl()
                .equals("http://test-automation-shop1.greenfox.academy/addresses");
    }

    public void deleteFirstAddress() {
        deleteFirstAddressButton.click ();
    }

    public WebElement getLinkToCreateNewAddress() {
        return linkToCreateNewAddress;
    }

    public WebElement getUpdateFirstAddressButton() {
        return updateFirstAddressButton;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public WebElement getDeleteFirstAddressButton() {
        return deleteFirstAddressButton;
    }

    public void updateFirstAddress() {
        updateFirstAddressButton.click();
    }

    public boolean addressUpdatedMessage() {
        return addressMessage.isDisplayed() &&
                addressMessage.getText().equals ("Address successfully updated!");
    }

    public boolean addressDeleteMessage() {
        return addressMessage.isDisplayed() &&
                addressMessage.getText().equals("Address Successfully deleted!");
    }

    public boolean addNewAddressMessage() {
        return addressMessage.isDisplayed() &&
                addressMessage.getText().equals("Address successfully added!");
    }
}
