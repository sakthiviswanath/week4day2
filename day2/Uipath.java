package week4.day2;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Uipath {
	
	
	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome Beta\\Application\\chrome.exe");

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\deepak\\Downloads\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver(options);


		driver.get("https://acme-test.uipath.com/account/login");

		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait (driver,30);
   
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com", Keys.TAB);
		driver.findElementById("password").sendKeys("leaf@12");
        driver.findElementById("buttonLogin").click();
        
        Thread.sleep(1000);
                	
        
        WebElement vendor = driver.findElementByXPath("(//div[@class='dropdown']/button)[4]");

        Actions builder =  new Actions(driver);
        
        builder.moveToElement(vendor).perform();
        
        driver.findElementByLinkText("Search for Vendor").click();
        
        driver.findElementById("vendorName").sendKeys("Blue Lagoon");
        driver.findElementById("buttonSearch").click();
        
        Thread.sleep(1000);
        
        driver.findElementByLinkText("Log Out").click();
        
        Thread.sleep(1000);
        driver.close();
        
	}
}
