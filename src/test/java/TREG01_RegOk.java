import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TREG01_RegOk extends BaseTest{

    String firstName = "Kiss";
    String lastName = "Bela";
    String email = "kissbelaa@gmail.com";
    String password = "kissbelaalegjobb";

    @Test
    public void registrationOk(){

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
        wait.until(ExpectedConditions.presenceOfElementLocated( By.xpath
                ("//*[@id=\"main\"]/header/h1")));
        driver.findElement ( By.xpath ( "//*[@id=\"_desktop_user_info\"]/div/a[1]" ) ).click ();
        wait.until ( ExpectedConditions.visibilityOfElementLocated
                ( By.xpath ( "//*[@id=\"main\"]/header/h1" ) ) );

    }
}

