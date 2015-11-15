package yavlanskiy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class UserSettingsPage extends AnyPage {

    public UserSettingsPage(PageManager manager) {
        super(manager);
    }

    @FindBy(id = "fileuploadfield-2282-button-fileInputEl")
    private WebElement selectFotoLink;

    @FindBy(id = "button-2285-btnInnerEl")
    private WebElement downloadButton;

    @FindBy(id = "button-2272-btnInnerEl")
    private WebElement editStatusLink;

    @FindBy(id = "textfield-2271-inputEl")
    private WebElement editStatusField;

    public UserSettingsPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.id("fileuploadfield-2282-button")));
        return this;
    }

    public void selectFotoLinkClick(){
        selectFotoLink.click();
    }

    public void downloadButtonClick(){
        downloadButton.click();
    }

    public boolean isDownloadButton(){
        if (downloadButton.isDisplayed()){
            return true;
        }else {
            return false;
        }
    }

    public void selectFoto(String path){
        selectFotoLink.sendKeys(path);
    }

    public UserSettingsPage editStatusLinkClick(){
        editStatusLink.click();
        return this;
    }

    public void editStatusField(String s){
        editStatusField.clear();
        editStatusField.sendKeys(s);
        editStatusField.sendKeys(Keys.ENTER);
    }

}
