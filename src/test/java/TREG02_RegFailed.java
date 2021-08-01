import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TREG02_RegFailed extends BaseTest {

        @Test
        @DisplayName ( "Registration unsuccessfully, TREG02 OK" )
        public void regFailed(){
                HomePage home = PageFactory.initElements ( driver, HomePage.class );
                RegPage reg = PageFactory.initElements ( driver, RegPage.class );
                reg.registrationData ( "Mr", "Kiss", "Bela", "kissbelaa@gmail.com", "kissbelaalegjobb" );
                reg.termAndConditionCheck.click ();
                reg.getPrivacyCheck ().click ();
                reg.getSaveButton ().click ();
                Assertions.assertThat ( reg.isLoaded () ).isTrue ();
        }
}
