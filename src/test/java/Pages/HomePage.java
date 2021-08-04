package Pages;

import org.jsoup.Connection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Locale;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super ( driver );
        this.action = new Actions ( driver );
    }

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a")
    WebElement linkToSignIn;

    @FindBy(xpath = "//*[@id=\"search_widget\"]/form/input[2]")
    WebElement inputToSearch;

    @FindBy(xpath = "//*[@id=\"footer_account_list\"]/li[4]/a")
    WebElement linkToAddress;

    @FindBy(xpath = "//*[@id=\"category-8\"]")
    WebElement linkToHomeAccess;

    @FindBy(xpath = "//*[id=\"content\"]/selection/a")
    WebElement linkAllProducts;

    public WebElement getSignInLink() {
        return linkToSignIn;
    }

    public WebElement getInputToSearch() {
        return inputToSearch;
    }

    public WebElement getLinkAllProducts() {
        return linkAllProducts;
    }

    public WebElement getLinkToAddress() {
        return linkToAddress;
    }

    public void navigateToHomeAccess() {
        driver.get ( "http://test-automation-shop1.greenfox.academy/" );
        linkToHomeAccess.click ();
    }

    public void navigatToAddress() {
        driver.get ( "http://test-automation-shop1.greenfox.academy/" );
        linkToAddress.click ();
    }

    public void navigatToSignIn() {
        driver.get ( "http://test-automation-shop1.greenfox.academy" );
        linkToSignIn.click ();
    }

    public boolean isLoaded() {
        return driver.getTitle ().equals ( "PrestaShop" ) && driver.getCurrentUrl ()
                .equals ( "http://test-automation-shop1.greenfox.academy/" );
    }

    public boolean isNotSignedIn() {
        String activeSignStatus = linkToSignIn.getText ();
        if (activeSignStatus.toLowerCase ( Locale.ROOT ).equals ( "sign in" )) {
            return true;
        }
        return false;
    }

    public void statusControl() {
        HomePage home = PageFactory.initElements ( driver, HomePage.class );
        LoginPage login = PageFactory.initElements ( driver, LoginPage.class );
        if (home.isNotSignedIn ()) {
            login.login ( "kissbelaa@gmail.com", "kissbelaalegjobb" );
        }
    }
}