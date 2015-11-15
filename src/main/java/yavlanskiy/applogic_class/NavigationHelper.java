package yavlanskiy.applogic_class;

import yavlanskiy.applogic_interface.NavigationHelper1;

public class NavigationHelper extends DriverBasedHelper implements NavigationHelper1 {

    private String baseUrl;

    public NavigationHelper(ApplicationManager manager) {
        super(manager.getWebDriver());
        this.baseUrl = manager.getBaseUrl();
    }

    @Override
    public void openMainPage() {
        driver.get(baseUrl);
    }

    @Override
    public void gotoUserProfilePage(){
        pages.homePage.ensurePageLoaded()
                .userSelectButtonClick()
                .userProfileLinkClick();
    }

    @Override
    public void gotoUserPage(){
        pages.homePage.ensurePageLoaded()
                .userSelectButtonClick()
                .myPageLinkClick();
    }
}