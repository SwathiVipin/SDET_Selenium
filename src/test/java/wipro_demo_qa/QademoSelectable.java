package wipro_demo_qa;

import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

//Assignment 1 questions 1 :- using testNg-
public class QademoSelectable  {

	public static WebDriver driver;
	// passing the browser
	String browserName = "chrome"; // Firefox
	//passing the url
	String url = "https://demoqa.com/selectable/";
	
	// variable declarations
	String expectedTitle ="Selectable – ToolsQA – Demo Website to Practice Automation";
	WebElement selectedElement;
	String elementName;
	int totalItemCount = 7;
	
	
	@BeforeTest
	public void initializeSetup() throws InterruptedException{
		
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",".//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.firefox.driver", "./Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}else{
			System.setProperty("webdriver.ie.driver",".//Drivers//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(1000,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		driver.get(url);
		}
	// verifying the pagetitle
	@Test
	public void verifyPageTitle(){
		String title = driver.getTitle();
		assertEquals(title, expectedTitle);

	}
	// finding the elements and item list
	@Test
	public void getAllElementsAndNames() {
		for (int counter = 1; counter <= totalItemCount; counter++) {
			selectedElement = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li["+counter+"]"));
			selectedElement.click();
			elementName = selectedElement.getText();
			System.out.println("Selected Element Name for itemlist "+ counter+"  is  :- "+ elementName);
		}
	}
	
	// closing the browser
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(500);
		driver.quit();
	}

	

}
