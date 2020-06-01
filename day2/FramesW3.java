package week4.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FramesW3 {
	
	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome Beta\\Application\\chrome.exe");

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\deepak\\Downloads\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver(options);


		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");

		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait (driver,30);

		
		driver.switchTo().frame("iframeResult");
		
		driver.findElementByXPath("//button[text()='Try it']").click();
		
	 TargetLocator switchTo = driver.switchTo();
	 
	 Alert alert = switchTo.alert();
	 alert.sendKeys("Hari");
	 driver.switchTo().f
	 
	 Thread.sleep(2000);
	 alert.accept();
	 
	 String text = driver.findElementByXPath("//p[@id='demo']").getText();
	 
	 System.out.println(text);
	 
	 
	 if (text.contains( "Hari"))
	 {
		 System.out.println("contains Hari");
		 
	 }
	 else
	 {
		 System.out.println("contains no Hari");

	 }
	 
	 

	}
}
