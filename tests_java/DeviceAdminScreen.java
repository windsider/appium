import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeviceAdminScreen extends PageObject {

    @FindBy(xpath = "//android.widget.RelativeLayout/android.widget.TextView")
    private WebElement encrpt;

    public DeviceAdminScreen(AppiumDriver driver) {
        super(driver);
    }

    public String confirmationEncryption() {
        return encrpt.getText();
    }
}