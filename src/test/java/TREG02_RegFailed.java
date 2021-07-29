import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TREG02_RegFailed extends BaseTest {

        String firstName = "Kiss";
        String lastName = "Bela";
        String email = "kissbelaagmail.com";
        String password = "kissbelaalegjobb";

        @Test
        public void regFailed(){

                driver.findElement ( By.xpath ( "//*[@id=\"_desktop_user_info\"]/div/a" )).click ();
                wait.until ( ExpectedConditions.elementToBeClickable ( By.xpath
                        ( "//*[@id=\"content\"]/div/a" ) ) ).click ();
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                                ("//input[@name='firstname']"))).sendKeys(firstName);
                driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
                driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
                driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
                driver.findElement(By.xpath("//input[@name='customer_privacy']")).click();
                driver.findElement(By.xpath("//input[@name='psgdpr']")).click();
                driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated ( By.xpath
                        ( "//*[@id=\"customer-form\"]/section/div[4]/div[1]/div/ul/li" )) );
        }
}
