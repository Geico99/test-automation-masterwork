package Pages;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;


public class TINP01_InputNewData extends Pages.BaseTest {

    @Feature ("Data hangling test")

    @Test
    @DisplayName ( "Input new data tested, TINP01 OK" )
    @Description ("Entered the keyword 'shirt' to search and checked one item with shirt keyword")
    public void inputNewData () {
        String keyword = "shirt";
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.getInputToSearch().sendKeys(keyword);
        home.getInputToSearch().sendKeys(Keys.ENTER);
        Assertions.assertThat ( driver.findElement(By.xpath
                ("//*[@id=\"js-product-list-top\"]/div[1]/p")).getText())
                .isEqualTo ("There is 1 product.");
    }
}
