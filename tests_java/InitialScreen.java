import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InitialScreen extends PageObject {

    @FindBy(xpath = "//android.widget.TextView[@content-desc='App']")
    private WebElement appItem;


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