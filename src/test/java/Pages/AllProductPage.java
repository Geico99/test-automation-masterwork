package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllProductPage extends BasePage {

    public AllProductPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"js-product-list\"]/nav/div[2]/ul/li[3]/a")
    WebElement nextButton;

    public WebElement getNextButton(){
        return nextButton;
    }
    public boolean isLoaded(){
        return driver.getTitle().equals("Home")&& driver.getCurrentUrl().equals
                ("http://test-automation-shop1-greenfox.academny/2-home");
    }
}
