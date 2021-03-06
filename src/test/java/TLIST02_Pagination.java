
import Pages.AllProductPage;
import Pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TLIST02_Pagination extends BaseTest {

    @Feature ( "Testing product page features" )

    @Test
    @DisplayName("Pagination test, TLIST02 OK")
    @Description("Listing products and pagination")
    public void pagination(){
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        AllProductPage allProduct = PageFactory.initElements (driver, AllProductPage.class);
        home.getLinkAllProducts().click();
        allProduct.getNextButton().click();
        wait.until (ExpectedConditions.urlToBe
                ("http://test-automation-shop1.greenfox.academny/2-home?page=2"));
        Assertions.assertThat(allProduct.isLoaded()).isFalse();
    }
}
