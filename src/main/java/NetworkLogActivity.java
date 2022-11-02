import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;

import org.openqa.selenium.devtools.v102.network.Network;

import org.openqa.selenium.devtools.v102.network.model.Request;
import org.openqa.selenium.devtools.v102.network.model.Response;
import org.openqa.selenium.devtools.v104.emulation.Emulation;





public class NetworkLogActivity {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\soumy\\Downloads\\Soumya docs\\Selenuim Training\\Apps\\chromedriver_win32\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		//40 3
		DevTools devTools=driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
	    devTools.addListener(Network.requestWillBeSent(), request ->
	    {
	    	Request req = request.getRequest();
	    	System.out.println(req.getUrl());
	    	
	    });
	    
	    
	    devTools.addListener(Network.responseReceived(), response ->
	    {
	    	Response res = response.getResponse();
	    	System.out.println("URL:"+res.getUrl()+" Status:"+res.getStatus()+" StatusText:"+res.getStatusText());
	    	
	    	
	    });
	    
	    driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	    driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		
		
	}

}
