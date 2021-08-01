import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TLIST01_Listing extends BaseTest {

    @Test
    @DisplayName ( "Listing home accessoires TLIST01 OK" )
    public void listingHomeAccessoires (){
        HomePage home = PageFactory.initElements ( driver, HomePage.class );
        HomeAcceessoiresPage homeacces = PageFactory.initElements ( driver, HomeAcceessoiresPage.class );
        home.navigateToHomeAccess ();
        Assertions.assertThat (homeacces.isLoaded ()).isTrue ();
        homeacces.linkToHomeAccess.click ();
        wait.until ( ExpectedConditions.urlContains
                ( "http://test-automation-shop1.greenfox.academy/8-home-accessories" ) );
        Assertions.assertThat (homeacces.homeAccessNumber ()).isEqualTo ( 8 );
    }
}