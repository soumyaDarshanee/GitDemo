import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PDFFileUploadWindows {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\soumy\\Downloads\\Soumya docs\\Selenuim Training\\Apps\\chromedriver_win32\\chromedriver.exe");

		String downloadedPath = System.getProperty("user.dir");
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadedPath);
		options.setExperimentalOption("prefs", chromePrefs);

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// driver.get("https://www.ilovepdf.com/pdf_to_jpg");
		driver.get("https://www.ilovepdf.com/pdf_to_jpg");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[id='pickfiles']")));
		driver.findElement(By.cssSelector("a[id='pickfiles']")).click();
		Thread.sleep(3000);
		// call .exe file
		Runtime.getRuntime().exec("C:\\Users\\soumy\\Downloads\\Soumya docs\\TestAutoIt\\script.exe");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("button[class*='btn btn--process btn--red pdfjpg']")));
		driver.findElement(By.cssSelector("button[class*='btn btn--process btn--red pdfjpg']")).click();
		Thread.sleep(7000);

		// verify if file is present
		File f = new File(downloadedPath + "/Soumya-Resume_page-0001.jpg");//
		if (f.exists()) {
			// System.out.println("Filefound");
			Assert.assertTrue(f.exists());
			if (f.delete()) {
				System.out.println("File deleted");
			}
		}
		driver.close();
	}

}
