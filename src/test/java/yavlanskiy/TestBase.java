package yavlanskiy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import ru.stqa.selenium.factory.WebDriverFactory;

import yavlanskiy.applogic_class.ApplicationManager;
import yavlanskiy.util.PropertyLoader;

/**
 * Base class for all the TestNG-based test classes
 */
public class TestBase {
	protected ApplicationManager app;

	@BeforeClass
	public void init() {
		app = new ApplicationManager();
	}

	@AfterSuite
	public void stop() {
		app.stop();
	}

}
