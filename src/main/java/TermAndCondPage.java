import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TermAndCondPage extends BasePage{

    public TermAndCondPage(WebDriver driver) {
        super(driver);
    }
    public void loadTermPage () {
        driver.get ("https://test-automation-shop1.greenfox.academy/content/3-terms-and-contidion-of-use");
    }
    public void closeTermPage(){
        driver.close ();
    }
    public boolean isLoaded(){
        return driver.getTitle ().equals ( "Terms and conditions of use" ) && driver.getCurrentUrl ().equals
                ("http://test-automation-shop1.greenfox.academy/content/3-terms-and-conditions-of use"  );
    }
}