package yavlanskiy;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import yavlanskiy.model.User;

import static org.testng.Assert.assertEquals;

public class TestEditStatus extends TestBase {

    @Test
    public void testEditStatus(){
        User yavlanskiyMax = new User().setLogin("yavlanskiy").setPassword("maxim198993");
        app.getUserHelper().loginAs(yavlanskiyMax);
        app.getNavigationHelper().gotoUserProfilePage();
        app.getUserHelper().editStatus("my status");
        app.getNavigationHelper().gotoUserPage();

        assertEquals(app.getWebDriver().findElement(By.id("user-page-title-2344-editBtn")).getText()
                , "my status");
    }
}
