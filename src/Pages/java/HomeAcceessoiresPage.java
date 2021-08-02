import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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
    public int homeAccessNumber (){
        int productnumber = 0;
        List<WebElement> listed = driver.findElements ( By.xpath ("//*[@id=\"js-product-list\"]"));
        productnumber = listed.size ();
        return productnumber;
    }
}
