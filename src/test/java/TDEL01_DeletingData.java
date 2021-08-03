import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class TDEL01_DeletingData extends BaseTest{

    @Test
    @DisplayName ("Deleting address data, TDEL01 OK")
    @Description ("Deleting address data and check")

    public void deleteData(){

        HomePage home = PageFactory.initElements (driver, HomePage.class);
        AddressPage address = PageFactory.initElements (driver, AddressPage.class);
        home.navigatToAddress ();
        address.deleteFirstAddress ();
        Assertions.assertThat ( address.addressDeleteMessage ())
                .isEqualTo ("Address successfully deleted");
    }
}
