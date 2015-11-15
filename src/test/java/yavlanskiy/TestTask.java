package yavlanskiy;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import yavlanskiy.model.User;

import static org.testng.Assert.assertTrue;

public class TestTask extends TestBase {

    @Test
    public void testTask(){
        User yavlanskiyMax = new User().setLogin("yavlanskiy").setPassword("maxim198993");
        app.getUserHelper().loginAs(yavlanskiyMax);
        app.getNavigationHelper().gotoUserProfilePage();
        app.getUserHelper().selectFoto("C:\\4invest\\4invest_task\\src\\main\\resources\\res\\ava.jpg");

        assertTrue(app.getWebDriver().findElement(By.id("button-2285-btnInnerEl")).isDisplayed());
    }
}
