package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		prop = new Properties();
		try {
		FileInputStream fin = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//config//config.properties");
		
		prop.load(fin);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void initialize() {
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "C:\\webDriver\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver","C:\\ProgramData\\Selenium\\chromedriver_win32\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver","C:\\ProgramData\\Eclipse\\eclipse-workspace\\eclipse-workspace\\CaseStudyHotelBooking\\Drivers\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		// url from config.properties
		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().deleteAllCookies();
		//driver.get(prop.getProperty("url"));
		//driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
	}
	

}

