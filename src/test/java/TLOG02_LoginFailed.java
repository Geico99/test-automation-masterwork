import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TLOG02_LoginFailed extends BaseTest{

    @Test
    @DisplayName ( "Login unsuccessful, not registred data found (TLOG02" )
    public void loginFailed(){
        HomePage home = PageFactory.initElements ( driver, HomePage.class );
        LoginPage login = PageFactory.initElements ( driver, LoginPage.class );
        home.navigatToSignIn ();
        login.login ( "kissbelaa@gmai.com", "kissgezaalegjobb" );
        wait.until ( ExpectedConditions.visibilityOfElementLocated
                ( By.xpath ( "//*[@id=\"content\"]/section/div/ul/li" ) ) );
        Assertions.assertThat ();

    }
}
