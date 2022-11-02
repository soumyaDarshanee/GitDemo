import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v104.emulation.Emulation;

public class MobileEmulator {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\soumy\\Downloads\\Soumya docs\\Selenuim Training\\Apps\\chromedriver_win32\\chromedriver.exe");
		
		//1.Initiate chrome driver
		ChromeDriver driver = new ChromeDriver();//chrome river is used to access the devtools
		//2.create object for chrome dev tools with getDevTools() Method
		DevTools devTools=driver.getDevTools();
		//3.create session
		devTools.createSession();
		//4.Send commands to CDP Methods->CDP Methods will invoke And get access to chrome dev tools 
		// setDeviceMetricsOverride(java.lang.Integer width, java.lang.Integer height, java.lang.Number deviceScaleFactor, java.lang.Boolean mobile, java.util.Optional<java.lang.Number> scale, java.util.Optional<java.lang.Integer> screenWidth, java.util.Optional<java.lang.Integer> screenHeight, java.util.Optional<java.lang.Integer> positionX, java.util.Optional<java.lang.Integer> positionY, java.util.Optional<java.lang.Boolean> dontSetVisibleSize, java.util.Optional<org.openqa.selenium.devtools.v104.emulation.model.ScreenOrientation> screenOrientation, java.util.Optional<org.openqa.selenium.devtools.v104.page.model.Viewport> viewport, java.util.Optional<org.openqa.selenium.devtools.v104.emulation.model.DisplayFeature> displayFeature) {
		devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Library")).click();
		
		
		
		

	}

}
