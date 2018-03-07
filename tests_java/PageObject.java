import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    AppiumDriver driver;

    public PageObject(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}