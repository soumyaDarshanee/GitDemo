import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabsTest {

	public static void main(String[] args) throws MalformedURLException {
	
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 11");
		browserOptions.setBrowserVersion("107");
		
		
		Map<String, Object> sauceOptions = new HashMap<>();
		sauceOptions.put("build", "1");
		sauceOptions.put("name", "<Google Test>");

		sauceOptions.put("username", System.getenv("oauth-soumyadarshanee-d684c"));
	    sauceOptions.put("accessKey", System.getenv("26ee1a53-fa56-4085-8a98-e9e9af5e3cdd"));
		 browserOptions.setCapability("sauce:options", sauceOptions);
		URL url = new URL("https://oauth-soumyadarshanee-d684c:26ee1a53-fa56-4085-8a98-e9e9af5e3cdd@ondemand.us-west-1.saucelabs.com:443/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);

		
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
	}

}
