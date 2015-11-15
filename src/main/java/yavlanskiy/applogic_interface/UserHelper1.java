package yavlanskiy.applogic_interface;


import yavlanskiy.model.User;

public interface UserHelper1 {

	void loginAs(User user);
	void logout();
	boolean isLoggedIn();
	boolean isNotLoggedIn();

}
