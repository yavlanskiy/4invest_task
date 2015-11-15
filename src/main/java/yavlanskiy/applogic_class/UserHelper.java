package yavlanskiy.applogic_class;

import yavlanskiy.applogic_interface.UserHelper1;
import yavlanskiy.model.User;

public class UserHelper extends DriverBasedHelper implements UserHelper1 {

    public UserHelper(ApplicationManager manager) {
        super(manager.getWebDriver());
    }

    @Override
    public void loginAs(User user) {
        pages.loginPage.ensurePageLoaded()
                .setUsernameField(user.getLogin())
                .setPasswordField(user.getPassword())
                .clickSubmitButton();
    }

    @Override
    public void logout() {
        pages.homePage.ensurePageLoaded()
                .userSelectButtonClick();
        pages.homePage.exitLinkClick();
    }

    @Override
    public boolean isLoggedIn() {
        return true;
    }

    @Override
    public boolean isNotLoggedIn() {
        return pages.loginPage.waitPageLoaded();
    }


    public void selectFoto(String path) {
        pages.userSettingsPage.ensurePageLoaded()
                .selectFoto(path);
    }

    public void editStatus(String status){
        pages.userSettingsPage.ensurePageLoaded()
                .editStatusLinkClick()
                .editStatusField(status);
    }
}
