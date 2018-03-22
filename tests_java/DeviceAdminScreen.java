import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class DeviceAdminScreen extends PageObject {

 @AndroidFindBy(className = "android.widget.TextView")
 private List < WebElement > classElems;

 public DeviceAdminScreen(AppiumDriver driver) {
  super(driver);
 }

 public String confirmationEncryption() {
  String encrp = null;
  WebDriverWait wait = new WebDriverWait(driver, 10);
  wait.until(ExpectedConditions.visibilityOfAllElements(classElems));
  for (WebElement classElem : classElems)
   if (classElem.getText().equals("Encryption")) {
    encrp = classElem.getText();
   }

  return encrp;
 }
}