import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowPopUp2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\soumy\\Downloads\\Soumya docs\\Selenuim Training\\Apps\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		//driver.get("https://the-internet.herokuapp.com/");
		//use the pattern http://Username:Password@SiteURL
		driver.get("http://admin:admin@the-internet.herokuapp.com/");
		//where tag is a linktext can be used
		driver.findElement(By.linkText("Basic Auth")).click();

	}
//https://www.ilovepdf.com/pdf_to_jpg
}
