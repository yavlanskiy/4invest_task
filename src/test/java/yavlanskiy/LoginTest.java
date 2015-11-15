package yavlanskiy;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import yavlanskiy.model.User;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class LoginTest extends TestBase {

  @BeforeMethod
  public void mayBeLogout() {
    if (app.getUserHelper().isNotLoggedIn()) {
      return;
    }
    app.getUserHelper().logout();
  }
  
  @Test
  public void testLoginOK() throws Exception {
    User user = new User().setLogin("yavlanskiy").setPassword("maxim198993");
    app.getUserHelper().loginAs(user);

    assertEquals(app.getWebDriver().findElement(By.id("button-1013-btnInnerEl")).getText(), "Максим Являнский");
  }

  @Test
  public void testLoginFailed() throws Exception {
    User user = new User().setLogin("yavlanskiy").setPassword("wrong");
    app.getUserHelper().loginAs(user);

    assertEquals(app.getWebDriver().findElement(By.cssSelector(".x-list-plain>li")).getText(),
            "Неверный логин или пароль.");
  }

  @Test
  public void testEmptyField() throws Exception {
    User user = new User().setLogin("").setPassword("");
    app.getUserHelper().loginAs(user);

    assertTrue(app.getWebDriver().findElement(By.cssSelector("#textfield-1782-errorEl .x-list-plain>li")).isDisplayed());
    assertTrue(app.getWebDriver().findElement(By.cssSelector("#textfield-1783-errorEl .x-list-plain>li")).isDisplayed());
  }

}
