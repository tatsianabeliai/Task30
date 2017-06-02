import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RMSysLoginTest extends TestBase {
    public static final String BASE_URL = "https://192.168.100.26/";
    private String username = "EugenBorisik";
    private String password = "qwerty12345";

    // Create By variables, which cover all possible types of location in Selenium WebDriver.
    private By usernameField = By.id("Username");
    private By passwordField = By.name("Password");
    private By welcomeMessageAtTop = By.cssSelector("div.welcome-message");
    private By loginButton = By.className("submit-button");
    private By homeMenu = By.xpath("//a[@id=\"homeMenu\"]");
    private By companyDocumentsPortalLink = By.partialLinkText("Company Documents");
    private By topRightMenuLinks = By.tagName("ins");
    private By logoutButton = By.linkText("Sign Out");

    public RMSysLoginTest() {
        super(BASE_URL);
    }

    @Description("Go to RMSsys login page, enter credentials and login")
    @Test
    public void login() {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();

        driver.findElement(welcomeMessageAtTop).isDisplayed();
        driver.findElement(homeMenu).isDisplayed();
        driver.findElement(companyDocumentsPortalLink).isDisplayed();
        List<WebElement> topRightPageLinks = driver.findElements(topRightMenuLinks);
        for (int i = 0; i < topRightPageLinks.size(); i++) {
            if (topRightPageLinks.get(i).getText() != "") ;
        }
        Assert.assertEquals(topRightPageLinks.get(0).getText(), "Feedback");
        driver.findElement(logoutButton).isDisplayed();
    }
}

