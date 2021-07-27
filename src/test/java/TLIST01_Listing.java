import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TLIST01_Listing extends BaseTest {

    @Test
    public void listingAccessoriesFromLowToHighPrice() {

        driver.findElement(
                        By.xpath("//*[@id=\"category-6\"]/a")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//*[@id=\"facet_96018\"]/li[1]/label/span/span"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//*[@id=\"js-product-list-top\"]/div[2]/div/div[1]/button")));

        //ellenőrizni a megjelent termékeket

    }
}