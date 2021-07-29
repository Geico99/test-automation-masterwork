import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TOUT01_LogOut extends BaseTest {

        @Test
        public void logOut() {
            login();
            driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[1]")).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath
                    ("//*[@id=\"main\"]/header/h1")));

        }
}