
import Pages.AddressPage;
import Pages.HomePage;
import Pages.NewAddressPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class TMOD01_DataModification extends BaseTest {

    @Feature ("Data hangling test")

    @Test
    @DisplayName("Modify data, TMOD01 OK")
    @Description("Modification state data in address")
    public void modifyAddressData(){
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        AddressPage address = PageFactory.initElements(driver , AddressPage.class);
        NewAddressPage newAddress = PageFactory.initElements(driver, NewAddressPage.class);
        home.navigatToAddress();
        address.getUpdateFirstAddressButton().click();
        address.getCityInput().clear ();
        newAddress.modifyAddress ( "New Yersey" );
        Assertions.assertThat( address.addressUpdatedMessage())
                .isEqualTo("Address successfully updated!");
    }
}
