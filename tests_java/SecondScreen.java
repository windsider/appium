import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecondScreen extends PageObject {

 @AndroidFindBy(accessibility = "Device Admin")
 private AndroidElement devAdmItem;

 public boolean isInitialized() {
  WebDriverWait wait = new WebDriverWait(driver, 10);
  wait.until(ExpectedConditions.elementToBeClickable(devAdmItem));
  return true;
 }

 public SecondScreen(AppiumDriver driver) {
  super(driver);
 }

 public DeviceAdminScreen submit() throws ElementNotInteractableException {
  devAdmItem.click();
  return new DeviceAdminScreen(driver);
 }

}