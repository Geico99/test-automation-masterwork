import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TLOG02_LoginFailed extends BaseTest{

    @Test
    @DisplayName ( "Login unsuccessful, not registred data found (TLOG02" )
    @Description ( "Login unsuccessful, password is not valid")
    public void loginFailed(){
        HomePage home = PageFactory.initElements ( driver, HomePage.class );
        LoginPage login = PageFactory.initElements ( driver, LoginPage.class );
        home.navigatToSignIn ();
        login.login ( "kissbelaa@gmail.com", "kissgezaalegjobb" );
        Assertions.assertThat (login.afterLogin ()).isFalse ();
    }
}
