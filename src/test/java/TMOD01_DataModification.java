import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class TMOD01_DataModification extends BaseTest {

    @Test
    @DisplayName ( "Modify data, TMOD01 OK" )
    public void modifyAddressData(){
        HomePage home = PageFactory.initElements ( driver, HomePage.class );
        AddressPage address = PageFactory.initElements ( driver , AddressPage.class);
        NewAddressPage newAddress = PageFactory.initElements ( driver, NewAddressPage.class );
        home.navigatToAddress ();
        address.updateFirstAddressButton.click ();
        driver.findElement ( By.xpath
                ("//*[@id=\"content\"]/div/div/form/section/div[9]/div[1]/input") ).click ();
        driver.findElement ( By.xpath
                ("//*[@id=\"content\"]/div/div/form/section/div[9]/div[1]/input") ).clear ();
        driver.findElement ( By.xpath
                ("//*[@id=\"content\"]/div/div/form/section/div[9]/div[1]/input") ).sendKeys ("New Jersey");
        address.continueButton.click ();
        Assertions.assertThat ( address.addressUpdatedMessage ()).isEqualTo ( "Address successfully updated!" );
    }
}
