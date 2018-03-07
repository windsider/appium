import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecondScreen extends PageObject {


    @FindBy(xpath = "//android.widget.TextView[@content-desc='Device Admin']")
    private WebElement devAdmItem;

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