package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomeAccessoiresPage extends BasePage{

    public HomeAccessoiresPage(WebDriver driver) {
       super(driver);
    }
    @FindBy(partialLinkText = "Home Accessories")
    WebElement linkToHomeAccess;

    public WebElement getLinkToHomeAccess() {
        return linkToHomeAccess;

    }
    public boolean isLoaded (){
        return driver.getTitle().equals("Home accessories") && driver.getCurrentUrl().equals
                ("http://test-automation-shop1.greenfox.academy/6-accessories?q=Categories-Home+Accessories" );
    }
    public int homeAccessNumber (){
        int productnumber = 0;
        List<WebElement> listed = driver.findElements(By.id ("products"));
        productnumber = listed.size();
        return productnumber;
    }
}
