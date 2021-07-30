import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {

    WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {driver.get
            ("http://test-automation-shop1.greenfox.academy/login?create_account=1");
    }

    @FindBy(xpath = "//*[@id='customer-form']/section/div[1]/div[1]/label[1]/span/input")
    private WebElement chooseMale;

    @FindBy(xpath = "//*[@id='customer-form']/section/div[1]/div[1]/label[2]/span/input")
    private WebElement chooseFemale;

    @FindBy(name = "firstname")
    private WebElement firstName;

    @FindBy(name = "lasttname")
    private WebElement lastName;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "birthday")
    private WebElement birthday;

    @FindBy(name = "optin")
    private WebElement offers;

    @FindBy(name = "customer_privacy")
    private WebElement customerPrivacy;

    @FindBy(name = "newsletter")
    private WebElement edm;

    @FindBy(name = "psgdpr")
    private WebElement privacy;

    @FindBy(xpath = "//*[@id=\"customer-form\"]/footer/button")
    private WebElement saveButton;


    public void signIn(String gender, String firstName, String lastName, String email,
                       String password, String birthday, boolean offers, boolean customerPrivacy,
                       boolean edm, boolean privacy) {

        if (gender == "male") {

            this.chooseMale.click();

        } else {

            this.chooseFemale.click();

        }


        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.birthday.sendKeys(birthday);

        if (offers == true) {

            this.offers.click();

        }
        if (customerPrivacy == true) {

            this.customerPrivacy.click();

        }
        if (edm == true) {

            this.edm.click();

        }

        if (privacy == true) {

            this.privacy.click();

        }

        this.saveButton.click();

    }
}
