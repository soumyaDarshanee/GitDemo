import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v102.fetch.Fetch;
import org.openqa.selenium.devtools.v102.network.Network;

import org.openqa.selenium.devtools.v102.network.model.Request;
import org.openqa.selenium.devtools.v102.network.model.Response;
import org.openqa.selenium.devtools.v104.emulation.Emulation;

public class NetworkMocking {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\soumy\\Downloads\\Soumya docs\\Selenuim Training\\Apps\\chromedriver_win32\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		//40 3
		DevTools devTools=driver.getDevTools();
		devTools.createSession();
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		
	    devTools.addListener(Fetch.requestPaused(), request ->
	    {
	    	if(request.getRequest().getUrl().contains("shetty"))
	    	{
	
	    		String mockURL=request.getRequest().getUrl().replace("=shetty", "=Badguy");
	    		devTools.send(Fetch.continueRequest(request.getRequestId(), 
	    				Optional.of(mockURL), Optional.of(request.getRequest().
	    				getMethod()), Optional.empty(),Optional.empty(),Optional.empty()));
	    
	    }
	    else {
	    	devTools.send(Fetch.continueRequest(request.getRequestId(), 
    				Optional.of(request.getRequest().getUrl()), Optional.of(request.getRequest().
    				getMethod()), Optional.empty(),Optional.empty(),Optional.empty()));
	    }
	    
	    });
	   
	    
	    driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	    driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
	    Thread.sleep(3000);
	  System.out.println(driver.findElement(By.cssSelector("p")).getText()); 
		
		
	}

}
