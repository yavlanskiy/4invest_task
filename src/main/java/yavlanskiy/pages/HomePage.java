package yavlanskiy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class HomePage extends AnyPage{

    public HomePage(PageManager manager) {
        super(manager);
    }

    @FindBy(id = "button-1013-btnEl")
    private WebElement userSelectButton;

    @FindBy(id = "menuitem-1015-textEl")
    private WebElement userProfileLink;

    @FindBy(id = "menuitem-1021-textEl")
    private WebElement exitLink;

    @FindBy(id = "menuitem-1016-textEl")
    private WebElement myPageLink;

    public HomePage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.id("button-1013-btnEl")));
        return this;
    }

    public HomePage userSelectButtonClick(){
        userSelectButton.click();
        return this;
    }

    public void userProfileLinkClick(){
        userProfileLink.click();
    }

    public void exitLinkClick(){
        exitLink.click();
    }

    public HomePage myPageLinkClick(){
        myPageLink.click();
        return this;
    }

}
