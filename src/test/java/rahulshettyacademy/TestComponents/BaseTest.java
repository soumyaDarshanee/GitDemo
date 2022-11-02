package rahulshettyacademy.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LandingPage;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPage;

	public WebDriver intialiseBrowser() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\rahulshettyacademy\\resources\\GlobalData.properties");
		prop.load(fis);
		// C:\\Users\\soumy\\Downloads\\Soumya
		// docs\\Java\\Eclipse_Workspace\\Mavenjava\\
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser"):
				prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			//options.setHeadless(true);//browser window opening will not show while running
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless")) {
				options.addArguments("--headless");	
				//options.setHeadless(true);
			}
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));//makes browser run in fullscreen irrespective of headless mode

		} else if (browserName.equalsIgnoreCase("edge")) {
			// edgeLogic
		} else if (browserName.equalsIgnoreCase("firefox")) {
			// firefoxLogic
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\soumy\\Downloads\\Soumya docs\\Selenuim Training\\Apps\\geckodriver-v0.31.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		// store json to string
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

		// string to HashMap json databind

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public String getScreenshot(String testcaseName, WebDriver driver2) throws IOException{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir") + "\\reports\\" + testcaseName + ".png");
		FileUtils.copyFile(Source, destFile);
		return System.getProperty("user.dir") + "\\reports\\" + testcaseName + ".png";

	}

	@BeforeMethod(alwaysRun = true)

	public LandingPage LaunchApplication() throws IOException {
		driver = intialiseBrowser();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}

	@AfterMethod(alwaysRun = true)

	public void CloseBrowser() {
		driver.close();
	}

}
