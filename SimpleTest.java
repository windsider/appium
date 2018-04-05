import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import static org.testng.Assert.assertEquals;


public class SimpleTest {
    private WebDriver driver;

    @BeforeSuite
    protected WebDriver getDriver() {
        System.setProperty("webdriver.gecko.driver", "C:\\bin\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeMethod
    protected void baseUrl(){
        String baseUrl = "http://www.marksandspencer.com/s/wine-shop/find-your-perfect-wine";
        driver.get(baseUrl + "/");
    }

    @AfterSuite
    protected void tearDown() {
        if (driver != null)
            driver.quit();
    }


    @Test(priority = 0, description = "asserts Title")
    public void assertTitle() {
        assertEquals(driver.getTitle(), "wine pairing and recommendations tool | M&S");
    }

    @Test(priority = 0, description = "asserts logoLink")
    public void assertLogoLink() {
        String logoLink = driver.findElement(By.partialLinkText("Marks")).getAttribute("href");
        assertEquals(logoLink, "http://www.marksandspencer.com/");
    }

    @Test(priority = 0, description = "verifies search feature")
    public void verifySearch() throws InterruptedException {

        WebElement searchInput = driver.findElement(By.cssSelector("input[class = 'search-bar--search-lg ng-pristine ng-untouched ng-valid ng-empty']"));
        searchInput.sendKeys("hello");
        searchInput.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id ("product-listing-page")));

        String searchRes = driver.findElement(By.xpath ("//*[@id='product-listing-page']/div/div[1]/p[1]/strong")).getText();
        Assert.assertEquals(searchRes, "hello");
    }


    @Test(priority = 1, description = "asserts NavHeaderMenuList")
    public void assertNavList() {
        List < WebElement > linkList = driver.findElements(By.cssSelector("#global-header > nav > ul > li > a"));
        List controlHeaderItemList = Arrays.asList("FIND A STORE", "HELP", "SIGN IN", "REGISTER", "SPARKS", "YOUR BAG 0");

        for (int i = 0; i < linkList.size() - 9; i++) {
            Assert.assertEquals(linkList.get(9 + i).getText(), controlHeaderItemList.get(i));
        }
    }


    @Test(priority = 1, description = "asserts ShopCategoryList")
    public void assertCategory() {
        WebElement navPrimList = driver.findElement(By.className("nav-primary__list"));
        List < WebElement > categoryItemList = navPrimList.findElements(By.cssSelector("li > a"));
        List controlCategoryItemList = Arrays.asList("Inspire Me", "Women", "Lingerie", "Beauty", "Men", "Kids", "Home", "Furniture", "Food", "Wine", "Flowers", "Hampers & Gifts", "Offers", "M&S Bank");

        for (int i = 0; i < categoryItemList.size(); i++) {
            Assert.assertEquals(categoryItemList.get(i).getText(), controlCategoryItemList.get(i));
        }
    }

    @Test(priority = 2, description = "asserts transition to Register page")
    public void transitionToRegisterPage() {
        try {
            driver.findElement (By.linkText ("Register")).click ();
            Assert.assertEquals (driver.getTitle (), "Register");
        }catch(Exception e) {
            throw new NoSuchElementException("the element not found");
        }
    }

    @Test(priority = 2, description = "asserts transition to Sale page")
    public void transitionToSalePage() {
        try {
            driver.findElement (By.linkText ("Women")).click ();
            Assert.assertEquals (driver.getTitle (), "Womenswear | Clothing, Shoes & Accessories For Women | M&S");
        } catch(Exception e) {
            throw new NoSuchElementException("the element not found");
        }

    }

    @Test(enabled = false, priority = 3, description = "verifies all links; should run separately since it takes long time")
    public void verifyLinks() {
        List < WebElement > links = driver.findElements(By.tagName("a"));
        System.out.println("Total links are " + links.size());

        for (int i = 0; i < links.size(); i++) {
            WebElement elem = links.get(i);
            String elemUrl = elem.getAttribute("href");
            try {
                URL url = new URL(elemUrl);
                HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
                httpURLConnect.setConnectTimeout(3000);
                httpURLConnect.connect();

                if (httpURLConnect.getResponseCode() == 200) {
                    System.out.println(elemUrl + " - " + httpURLConnect.getResponseMessage());
                }
                if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
                    System.out.println(elemUrl + " - " + httpURLConnect.getResponseMessage() + " - " + HttpURLConnection.HTTP_NOT_FOUND);
                }
            } catch (Exception e) {

            }

        }

    }

}
