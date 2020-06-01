package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {


		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome Beta\\Application\\chrome.exe");

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\deepak\\Downloads\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://www.nykaa.com/");

		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait (driver,30);

		WebElement brand = driver.findElementByXPath("//a[text()='brands']");

		Actions builder= new Actions(driver);
		builder.moveToElement(brand).perform();
		
		Thread.sleep(2000);

		driver.findElementByXPath("//a[text()='Popular']").click();
		
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[@id='brandCont_Popular']//a)[5]").click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(list.get(1));
		
		String title = driver.getTitle();
		
		boolean contains = title.contains("L'Oreal Paris");
		System.out.println(title);
		System.out.println(contains);		
		driver.switchTo().window(list.get(0));
		driver.close();
		
		driver.switchTo().window(list.get(1));

		
		driver.findElementByXPath("//span[text()='popularity']").click();
		//driver.findElementByXPath("//span[text()='Sort By : ']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("(//span[text()='customer top rated']/following::div)[1]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[text()='Category']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//span[contains(text(),'Shampoo')]/following::div").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class = 'm-content__product-list__title'] ").click();
		Thread.sleep(2000);
		
		
		Set<String> bag = driver.getWindowHandles();
		List<String> newbag = new ArrayList<String>(bag);
		driver.switchTo().window(newbag.get(1));
		
		driver.findElementByXPath("//div[@class='pull-left']//button").click();
		Thread.sleep(1000);
	    driver.findElementByXPath("//div[@class='AddBagIcon']").click();
	    Thread.sleep(2000);
	    driver.findElementByXPath("//span[text()='Proceed']").click();
	    Thread.sleep(2000);
	    String msg = driver.findElementByXPath("//div[text()='Error']/following::div").getText();
	    System.out.println(msg);
	    driver.quit();
	    
	}

}
