package yavlanskiy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class LoginPage extends AnyPage {

    public LoginPage(PageManager manager) {
        super(manager);
    }

    @FindBy (id = "textfield-1782-inputEl")
    private WebElement userNameField;

    @FindBy (id = "textfield-1783-inputEl")
    private WebElement userPassField;

    @FindBy (id = "button-1787-btnEl")
    private WebElement submitButton ;

    public LoginPage setUsernameField(String text) {
        userNameField.clear();
        userNameField.sendKeys(text);
        return this;
    }

    public LoginPage setPasswordField(String text) {
        userPassField.clear();
        userPassField.sendKeys(text);
        return this;
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public LoginPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.id("window-1779_header")));
        return this;
    }


}
