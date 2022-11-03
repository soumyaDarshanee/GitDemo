import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v104.emulation.Emulation;

public class SetGeoLocation {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\soumy\\Downloads\\Soumya docs\\Selenuim Training\\Apps\\chromedriver_win32\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		//40 3
		DevTools devTools=driver.getDevTools();
		devTools.createSession();
		
		Map<String,Object> coordinates = new HashMap<String,Object>();
		coordinates.put("latitude", 40);
		coordinates.put("longitude", 3);
		coordinates.put("accuracy", 1);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		
		
			driver.get("https://my-location.org/");
			System.out.println(driver.findElement(By.id("address")).getText());
			
			System.out.println("gitdemo : its git hub code change testing ");
			
			System.out.println("gitstuff : its git hub code change testing ");
			System.out.println("gitstuff : its git hub code change testing ");
			/*
			 * driver.get("https://google.com/"); Thread.sleep(3000);
			 * driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
			 * Thread.sleep(2000);
			 * driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
			 * 
			 * String title =
			 * driver.findElement(By.cssSelector(".our-story-card-title")).getText();
			 * System.out.println(title);
			 * 
			 * 
			 * 
			 * 
			 */

	}

}
