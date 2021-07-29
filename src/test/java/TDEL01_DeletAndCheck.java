import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


class TDEL01_DeleteAndCheck extends BaseTest {


    @Test
    public void changeAddressAndAddNew() {

        login();

        driver.findElement(By.xpath("//*[@id=\"address-link\"]/span")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//*[@id=\"content\"]/div/div/form/section/div[7]/div[1]/input"))).click();
        driver.findElement ( By.xpath ("//*[@id=\"content\"]/div/div/form/section/div[7]/div[1]/input"))
                .sendKeys ( "Budapest" );
        driver.findElement ( By.xpath
                ( "//*[@id=\"content\"]/div/div/form/section/div[9]/div[1]/input" ) ).click ();
        driver.findElement ( By.xpath
                ( "//*[@id=\"content\"]/div/div/form/section/div[9]/div[1]/input" ) )
                .sendKeys ( "1027" );

        driver.findElement(By.xpath("//input[@name='customer_privacy']")).click();
        driver.findElement(By.xpath("//input[@name='psgdpr']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
        wait.until( ExpectedConditions.presenceOfElementLocated( By.xpath
                        ("//a[@title='View my customer account']")));

    }
}