
import Pages.AddressPage;
import Pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class TDEL01_DeletingData extends BaseTest {

    @Feature("Data handling test")

    @Test
    @DisplayName("Deleting address data, TDEL01 OK")
    @Description("Deleting address data and check if it was successful")

    public void deleteData(){

        HomePage home = PageFactory.initElements(driver, HomePage.class);
        AddressPage address = PageFactory.initElements(driver, AddressPage.class);
        home.statusControl();
        home.navigatToAddress();
        address.deleteFirstAddress();
        Assertions.assertThat ( address.addressDeleteMessage())
                .isEqualTo("Address successfully deleted");
    }
}
