import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressPage extends BasePage{

    public AddressPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(partialLinkText = "Create new address")
    WebElement linkToCreateNewAddress;

    public void toNewAddressPage (){
        linkToCreateNewAddress.click ();
    }
}
