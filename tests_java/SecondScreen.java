import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.ElementNotInteractableException;

public class SecondScreen extends PageObject {

    @AndroidFindBy(accessibility = "Device Admin")
    private AndroidElement devAdmItem;

    public boolean isInitialized() {
        return devAdmItem.isDisplayed();
    }

    public SecondScreen(AppiumDriver driver) {
        super(driver);
    }

    public DeviceAdminScreen submit() throws ElementNotInteractableException {
        devAdmItem.click();
        return new DeviceAdminScreen(driver);
    }

}