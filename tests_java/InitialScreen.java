import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.ElementNotInteractableException;

public class InitialScreen extends PageObject {

    @AndroidFindBy(accessibility = "App")
    private AndroidElement appItem;


    public InitialScreen(AppiumDriver driver) {
        super(driver);

    }

    public boolean isInitialized() {
        return appItem.isDisplayed();
    }

    public SecondScreen submit() throws ElementNotInteractableException {
        appItem.click();
        return new SecondScreen(driver);
    }

}