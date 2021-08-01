import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class TSAVE01_SavingData extends BaseTest{

    @Test
    @DisplayName ( "Saving data from the app, TSAVE01 OK" )
    public void savingDataFromTheApp(){
        RegPage reg = PageFactory.initElements ( driver, RegPage.class );
        TermAndCondPage term = new TermAndCondPage ( driver );
        reg.navigateToReg ();
        reg.termAndConditionLink.click ();
        Assertions.assertThat ( term.isLoaded() ).isTrue ();
        term.textCopyToFile

    }
}
