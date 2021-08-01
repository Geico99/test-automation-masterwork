import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeAcceessoiresPage extends BasePage{

    public HomeAcceessoiresPage(WebDriver driver) {
       super(driver);
    }
    @FindBy(partialLinkText = "Home Accessories")
    WebElement linkToHomeAccess;

    public WebElement getHomeAccess(){
        return linkToHomeAccess;
    }
    public boolean isLoaded (){
        return driver.getTitle ().equals ( "Accessoires" ) && driver.getCurrentUrl ().equals
                ( "http://test-automation-shop1.greenfox.academy/6-accessories?q=Categories-Home+Accessories" );
    }
}
