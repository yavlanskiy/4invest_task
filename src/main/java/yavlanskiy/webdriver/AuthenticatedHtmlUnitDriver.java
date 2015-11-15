package yavlanskiy.webdriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.WebClient;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/*
 * Class extending HtmlUnitDriver to support BASIC authentication
 * 
 * @author Sebastiano Armeli-Battana
 */
public class AuthenticatedHtmlUnitDriver extends HtmlUnitDriver {
	private static String USERNAME;
	private static String PASSWORD;

	public AuthenticatedHtmlUnitDriver() {
	}

	public static WebDriver create(String username, String password) {
		USERNAME = username;
		PASSWORD = password;
		return new AuthenticatedHtmlUnitDriver();
	}

	@Override
	protected WebClient newWebClient(BrowserVersion browserVersion) {
		WebClient client = super.newWebClient(browserVersion);
		DefaultCredentialsProvider provider = new DefaultCredentialsProvider();
		provider.addCredentials(USERNAME, PASSWORD);
		client.setCredentialsProvider(provider);
		return client;
	}
}
