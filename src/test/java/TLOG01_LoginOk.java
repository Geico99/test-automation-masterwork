package Pages;

import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class TLOG01_LoginOk extends Pages.BaseTest {

    @Test
    @DisplayName ("Login successful, (TLOG01 OK)")
    @Description ("Login successful with valid data")

    public void successfullyLogin(){
    HomePage home = PageFactory.initElements(driver, HomePage.class);
    LoginPage login = PageFactory.initElements(driver, LoginPage.class);
    home.navigatToSignIn();
    login.login ("kissbelaa@gmail.com", "kissbelaalegjobb");
        Assertions.assertThat(login.afterLogin()).isTrue();
    }
}

