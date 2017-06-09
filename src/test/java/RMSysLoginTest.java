import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RMSysLoginTest extends TestBase {
    public static final String BASE_URL = "https://192.168.100.26/";
    // Create By variables, which cover all possible types of location in Selenium WebDriver.
    public static final By USERNAME_FIELD = By.id("Username");
    public static final By PASSWORD_FIELD = By.name("Password");
    public static final By WELCOME_MESSAGE_AT_TOP = By.cssSelector("div.welcome-message");
    public static final By LOGIN_BUTTON = By.className("submit-button");
    public static final By HOME_MENU = By.xpath("//a[@id=\"homeMenu\"]");
    public static final By COMPANY_DOCUMENTS_PORTAL_LINK = By.partialLinkText("Company Documents");
    public static final By TOP_RIGHT_MENU_LINKS = By.tagName("ins");
    public static final By LOGOUT_BUTTON = By.linkText("Sign Out");
    private String username = "EugenBorisik";
    private String password = "qwerty12345";

    public RMSysLoginTest() {
        super(BASE_URL);
    }

    @Description("Go to RMSsys login page, enter credentials and login")
    @Test
    public void login() {
        driver.findElement(USERNAME_FIELD).sendKeys(username);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();

        Assert.assertTrue(driver.findElement(WELCOME_MESSAGE_AT_TOP).isDisplayed(), "No Welcome message at the top of the page");
        Assert.assertTrue(driver.findElement(HOME_MENU).isDisplayed(), "No Home menu");
        Assert.assertTrue(driver.findElement(COMPANY_DOCUMENTS_PORTAL_LINK).isDisplayed(), "No Company documents link on the page");
        List<WebElement> topRightPageLinks = driver.findElements(TOP_RIGHT_MENU_LINKS);
        for (int i = 0; i < topRightPageLinks.size(); i++) {
            if (topRightPageLinks.get(i).getText() != "") ;
        }
        Assert.assertEquals(topRightPageLinks.get(0).getText(), "Feedback");
        Assert.assertTrue(driver.findElement(LOGOUT_BUTTON).isDisplayed(), "No Logout button on the page");
    }
}

