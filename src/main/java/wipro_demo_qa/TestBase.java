package wipro_demo_qa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public void TestBasefile() throws Exception{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".//ConfigureFiles//config.file");
		prop.load(fis);
	}

	public static WebDriver  driverIntialization(String browserName2){
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")){
				System.getProperty("webdriver.chrome.driver",".//Drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}else if(browserName.equalsIgnoreCase("firefox")){
				System.getProperty("webdriver.firefox.driver", ".//Drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}else{
				System.getProperty("webdriver.ie.driver",".//Drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(1000,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		return driver;
	}


}
