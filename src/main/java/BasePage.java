import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class BasePage {

    WebDriver driver = null;
    WebDriver wait = null;

    BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = (WebDriver) new WebDriverWait ( driver, 15 );
        PageFactory.initElements ( driver, this );
    }
}

