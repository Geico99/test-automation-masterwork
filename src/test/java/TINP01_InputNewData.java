import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import sun.jvm.hotspot.debugger.Page;

public class TINP01_InputNewData extends BaseTest{

    @Test
    @DisplayName ( "Input new data tested, TINP01 OK" )
    public void inputNewData (){
        String keyword = "shirt";
        HomePage home = PageFactory.initElements ( driver, HomePage.class );
        home.getInputToSearch ().sendKeys ( keyword );
        home.getInputToSearch ().sendKeys ( Keys.ENTER );
        //vizsgálni
    }
}
