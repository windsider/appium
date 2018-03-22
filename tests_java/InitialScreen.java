import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InitialScreen extends PageObject {

 @AndroidFindBy(accessibility = "App")
 private AndroidElement appItem;

 public InitialScreen(AppiumDriver driver) { 
  super(driver);
 }

 public boolean isInitialized() {
  WebDriverWait wait = new WebDriverWait(driver, 10);
  wait.until(ExpectedConditions.elementToBeClickable(appItem));
  return true;
 }

 public SecondScreen submit() throws ElementNotInteractableException {
  appItem.click();
  return new SecondScreen(driver);
 }

}