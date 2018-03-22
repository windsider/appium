import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SwitchScreensTests extends BaseSet {

    @Test
    public void switchScreens() throws Exception {
        
        InitialScreen initialScreen = new InitialScreen(driver);
        assertTrue(initialScreen.isInitialized());
        
        SecondScreen secondScreen = initialScreen.submit();
        assertTrue(secondScreen.isInitialized());

        DeviceAdminScreen adminScreen = secondScreen.submit();
        assertEquals("No 'Encryption' item found", "Encryption", adminScreen.confirmationEncryption());

    }
}