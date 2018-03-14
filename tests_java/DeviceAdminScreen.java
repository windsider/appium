import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.List;

public class DeviceAdminScreen extends PageObject {

    @AndroidFindBy(className = "android.widget.TextView")
    private List<AndroidElement> encrptItem;

    public DeviceAdminScreen( AppiumDriver driver) {
        super(driver);
    }

    public String confirmationEncryption() {
        return encrptItem.get(5).getText();
    }
}