package yavlanskiy.applogic_class;

import org.openqa.selenium.WebDriver;
import yavlanskiy.applogic_interface.ApplicationManager1;
import yavlanskiy.applogic_interface.NavigationHelper1;
import yavlanskiy.util.Browser;
import yavlanskiy.util.PropertyLoader;
import yavlanskiy.webdriver.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager implements ApplicationManager1 {

    private UserHelper userHelper;
    private NavigationHelper1 navHelper;

    private WebDriver driver;
    private String baseUrl;

    public ApplicationManager() {
        baseUrl = PropertyLoader.loadProperty("site.url");
        String gridHubUrl = PropertyLoader.loadProperty("grid2.hub");

        Browser browser = new Browser();
        browser.setName(PropertyLoader.loadProperty("browser.name"));
        browser.setVersion(PropertyLoader.loadProperty("browser.version"));
        browser.setPlatform(PropertyLoader.loadProperty("browser.platform"));

        String username = PropertyLoader.loadProperty("user.username");
        String password = PropertyLoader.loadProperty("user.password");

        driver = WebDriverFactory.getInstance(gridHubUrl, browser, username, password);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        userHelper = new UserHelper(this);
        navHelper = new NavigationHelper(this);

        getNavigationHelper().openMainPage();
    }

    @Override
    public UserHelper getUserHelper() {
        return userHelper;
    }

    @Override
    public NavigationHelper1 getNavigationHelper() {
        return navHelper;
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    protected String getBaseUrl() {
        return baseUrl;
    }

    @Override
    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }
}
