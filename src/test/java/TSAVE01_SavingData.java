package Pages;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class TSAVE01_SavingData extends Pages.BaseTest {

    @Feature ("Customer registration")

    @Test
    @DisplayName ("Saving data from the app, TSAVE01 OK")
    @Description ("Saving the terms and conditions of use in a txt file")
    public void savingDataFromTheApp(){
        RegPage reg = PageFactory.initElements(driver, RegPage.class);
        TermAndCondPage term = new TermAndCondPage (driver);
        reg.navigateToReg();
        reg.termAndConditionLink.click();
        reg.switchWindow();
        Assertions.assertThat(term.isLoaded()).isTrue();
        term.copyToFile();
    }
}
