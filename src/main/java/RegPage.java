import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegPage extends BasePage {

    public RegPage(WebDriver driver) {
        super(driver);

    }
    @FindBy(xpath = "//*[@id=\"content\"]/div/a")
    WebElement createNewAccount;

    @FindBy(xpath = "//*[@id=\"customer-form\"]/section/div[1]/div[1]/label[1]/span/input")
    WebElement radioMale;

    @FindBy(xpath = "//*[@id=\"customer-form\"]/section/div[1]/div[1]/label[2]/span/input")
    WebElement radioFemale;

    @FindBy(xpath = "//*[@id=\"customer-form\"]/section/div[2]/div[1]/input")
    WebElement firstNameInput;

    @FindBy(xpath = "//*[@id=\"customer-form\"]/section/div[3]/div[1]/input")
    WebElement lastNameInput;

    @FindBy(xpath = "//*[@id=\"customer-form\"]/section/div[4]/div[1]/input")
    WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"customer-form\"]/section/div[5]/div[1]/div/input")
    WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"customer-form\"]/section/div[8]/div[1]/span/label/input")
    WebElement privacyCheck;

    @FindBy(xpath = "//*[@id=\"customer-form\"]/section/div[10]/div[1]/span/label/input")
    WebElement termAndConditionCheck;

    @FindBy(xpath = "//*[@id=\"customer-form\"]/section/div[10]/div[1]/span/label/a")
    WebElement termAndConditionLink;

    @FindBy(xpath = "//*[@id=\"customer-form\"]/footer/button")
    WebElement saveButton;

    public WebElement getPrivacyCheck() {
        return privacyCheck;
    }

    public WebElement getTermAndConditionCheck() {
        return termAndConditionCheck;
    }

    public WebElement getTermAndConditionLink() {
        return termAndConditionLink;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }
    public boolean isLoaded () {
        return driver.getTitle ().equals ( "Login" ) && driver.getCurrentUrl ()
                .equals ( "http://test-automation-shop1.greenfox.academy/login?create_account=1" );
    }
    public void navigateToReg(){
        HomePage home = PageFactory.initElements ( driver, HomePage.class );
        LoginPage login = PageFactory.initElements ( driver, LoginPage.class );
        RegPage regpage = PageFactory.initElements ( driver, RegPage.class );
        home.navigatToSignIn ();
        login.navigateToRegPage ();
    }
    public void registrationData (String socialTitle, String firstName, String lastName,
                                     String email, String password) {
        if (socialTitle.equals("Mr.")) {
            radioMale.click();
        } else {
            radioFemale.click();
        }
        firstNameInput.sendKeys ( firstName );
        lastNameInput.sendKeys ( lastName );
        emailInput.sendKeys ( email );
        passwordInput.sendKeys ( password );
    }
    public void openAndClosePrivacy(){
        RegPage regPage = PageFactory.initElements ( driver, RegPage.class );
        TermAndCondPage term = new TermAndCondPage ( driver );
        regPage.termAndConditionLink.click ();
        Set<String> window = driver.getWindowHandles ();
        Iterator<String> iterator = window.iterator ();
        String regWindow = iterator.next ();
        String termWindow = iterator.next ();
        term.closeTermPage ();
        driver.switchTo ().window ( regWindow );
    }
}