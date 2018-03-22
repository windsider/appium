import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class BaseSet {
    protected static AppiumDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        // set up appium
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel XL API 27");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:/Users/ruvzherdev/Desktop/Appium/ApiDemos-debug.apk");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver (url, desiredCapabilities);
        String sessionId = driver.getSessionId().toString();

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}