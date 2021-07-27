import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TLOG02_LoginFailed extends BaseTest{

    @Test
    public void loginFailed(){
        String email = "kissbelaa@gmail.com";
        String password = "kisgezaalegjobb";

        driver.findElement ( By.xpath ( "//*[@id=\"_desktop_user_info\"]/div/a/span" ) ).click ();
        wait.until ( ExpectedConditions.elementToBeClickable
                ( By.xpath ( "//*[@id=\"login-form\"]/section/div[1]/div[1]/input" ) ) ).sendKeys ( email );
        driver.findElement ( By.xpath
                ( "//*[@id=\"login-form\"]/section/div[2]/div[1]/div/input" ) ).sendKeys ( password );
        driver.findElement ( By.id ( "submit-login" ) ).click ();
        wait.until ( ExpectedConditions.visibilityOfElementLocated
                ( By.xpath ( "//*[@id=\"content\"]/section/div/ul/li" ) ) );

    }
}
