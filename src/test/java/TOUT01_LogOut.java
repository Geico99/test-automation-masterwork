
import Pages.HomePage;
import Pages.LoginPage;
import io.qameta.allure.Feature;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TOUT01_LogOut extends BaseTest {

    @Feature ("Login/Logout feature" )

    @Test
    @DisplayName("Testing logout, TOUT01 OK")
    public void logOut() {
        HomePage home = PageFactory.initElements (driver, HomePage.class);
        LoginPage login = PageFactory.initElements (driver, LoginPage.class);
        if (home.isNotSignedIn()) {
            home.navigatToSignIn();
            login.login ("kissbelaa@gmail.com", "kissbelaalegjobb");
            Assertions.assertThat(login.afterLogin()).isTrue();
            home.getSignInLink().click();
            Assertions.assertThat(login.beforeLogin()).isTrue();
            }
        home.getSignInLink().click();
        Assertions.assertThat (login.beforeLogin()).isTrue();
    }
}
