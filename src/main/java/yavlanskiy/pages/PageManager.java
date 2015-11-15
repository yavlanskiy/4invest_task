package yavlanskiy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PageManager {

  private WebDriver driver;

  public LoginPage loginPage;
  public HomePage homePage;
  public UserSettingsPage userSettingsPage;

  public PageManager(WebDriver driver) {
    this.driver = driver;
    loginPage = initElements(new LoginPage(this));
    homePage = initElements(new HomePage(this));
    userSettingsPage = initElements(new UserSettingsPage(this));
  }

  private <T extends Page> T initElements(T page) {
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), page);
    return page;
  }
  
  public WebDriver getWebDriver() {
    return driver;
  }

}
