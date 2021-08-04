package Pages;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TLIST01_Listing extends Pages.BaseTest {

    @Feature ("Listing products")

    @Test
    @DisplayName ("Listing home accessoires TLIST01 OK")
    @Description ("Listig home accessoires and check the number of the products")
    public void listingHomeAccessoires(){

        HomePage home = PageFactory.initElements (driver, HomePage.class);
        HomeAccessoiresPage homeacces = PageFactory.initElements
                (driver, HomeAccessoiresPage.class);
        home.navigateToHomeAccess();
        Assertions.assertThat (homeacces.isLoaded ()).isTrue ();
        homeacces.linkToHomeAccess.click ();
        wait.until( ExpectedConditions.urlContains
                ( "http://test-automation-shop1.greenfox.academy/8-home-accessories" ) );
        Assertions.assertThat (homeacces.homeAccessNumber ()).isEqualTo ( 8 );
    }
}