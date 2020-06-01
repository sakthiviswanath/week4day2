package week4.day2;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SnowChangeOrder {
	
	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome Beta\\Application\\chrome.exe");

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\deepak\\Downloads\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver(options);


		driver.get("https://dev60453.service-now.com/");

		driver.switchTo().frame("gsft_main");


		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait (driver,30);

		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementById("user_password").sendKeys("India@123");
		driver.findElementById("sysverb_login").click();
		Thread.sleep(2000);

		
		//Enter Change in filter navigator
		driver.findElementByXPath("//input[@id='filter']").sendKeys("Change");
        //Click Create New and click Normal change under What type of change is required?
		Thread.sleep(4000);
		driver.findElementByXPath("(//div[text()='Open'])[3]").click();
		Thread.sleep(2000);
		
		driver.switchTo().frame("gsft_main");

		driver.findElementById("sysverb_new").click();
		
		Thread.sleep(2000);

		driver.findElementByXPath("//div[@class='container-fluid wizard-container']/a").click();
		
		String changeOrder = driver.findElementById("change_request.number").getAttribute("value");
		System.out.println(changeOrder);
		
		driver.findElementById("change_request.short_description").sendKeys("Testnew");
		
		driver.findElementById("sysverb_insert_bottom").click();
		Thread.sleep(2000);
		
		//driver.switchTo().frame("gsft_main");

		driver.findElementByXPath("(//input[@class='form-control'])[1]").sendKeys(changeOrder,Keys.ENTER);
		
		String changeOrdernew = driver.findElementByXPath("(//td[@class='vt']//a)[1]").getText();
		
		System.out.println(changeOrdernew);
		
		if(changeOrder.contentEquals(changeOrdernew))
		{
			
			System.out.println("Verified the successful creation of change");
		}
		else
		{
			System.out.println("Mis-match in change order");

		}
	}

}
