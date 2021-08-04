package Pages;

import java.io.File;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TermAndCondPage extends BasePage {

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
    public void copyToFile () {
        Path targeted = Paths.get ( "src" + File.separator + "Terms_and_conditons_of_use.txt" );
        List<String> copiedText = new ArrayList<> ();
        WebElement titleOfRules = driver.findElement ( By.id ( "content" ) );
        copiedText.add ( titleOfRules.getText () );
        try {
            Files.write ( targeted, copiedText );
        } catch (IOException e) {
            System.err.println ("Error: Terms and condition is not possible to write a file");
        }
    }
}