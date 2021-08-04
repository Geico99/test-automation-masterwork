package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"login-form\"]/section/div[1]/div[1]/input")
    WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"login-form\"]/section/div[2]/div[1]/div/input")
    WebElement passwordInput;

    @FindBy(id = "submit-login")
    WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"content\"]/div/a")
    WebElement createNewAccountLink;

    public void navigateToRegPage(){
        createNewAccountLink.click ();
    }

    public void login(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInButton.click();
    }
    public boolean beforeLogin (){
        return driver.getTitle ().equals ( "Login" ) && driver.getCurrentUrl ()
                .equals ( "http://test-automation-shop1.greenfox.academny/login?back=my-account" );
    }
    public boolean afterLogin () {
        return driver.getTitle ().equals ( "My account" ) && driver.getCurrentUrl ()
                .equals ( "http://test-automation-shop1.greenfox.academy/myaccount" );
    }
}