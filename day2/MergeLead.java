package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MergeLead {
	
	public static void main(String[] args) throws InterruptedException {


		ChromeOptions options = new ChromeOptions();
		
		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome Beta\\Application\\chrome.exe");

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\deepak\\Downloads\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver(options);

		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait (driver,30);
		
		WebElement userName = driver.findElementByXPath("//input[@id='username']");
		userName.sendKeys("demosalesmanager");	
		driver.findElementByXPath("//input[@id='password']").sendKeys("crmsfa");
		driver.findElementByXPath("//input[@class='decorativeSubmit']").click();
		driver.findElementByXPath("//div[@for='crmsfa']/a").click();
		
		driver.findElementByXPath("//a[text()='Contacts']").click();
		driver.findElementByXPath("//a[text()='Merge Contacts']").click();
		driver.findElementByXPath("(//img[@alt='Lookup'])[1]").click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> List = new ArrayList<String>(windowHandles);
		
		System.out.println(List);
		System.out.println(List.get(1));
		driver.switchTo().window(List.get(1));
		Thread.sleep(1000);
		driver.findElementByXPath("(//div[@unselectable='on']/following::a)[22]").click();
		Thread.sleep(1000);
		driver.switchTo().window(List.get(0));
		Thread.sleep(1000);
		driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();
		Thread.sleep(1000);

		
		Set<String> nextwindowHandles = driver.getWindowHandles();
		List<String> newList = new ArrayList<String>(nextwindowHandles);
		System.out.println(newList);
		Thread.sleep(2000);
		System.out.println(newList.get(1));
		driver.switchTo().window(newList.get(1));
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[@unselectable='on']/following::a)[27]").click();
		
		driver.switchTo().window(newList.get(0));

		driver.findElementByXPath("//a[text()='Merge']").click();
		
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		String title = driver.getTitle();
		System.out.println(title);


	}

}
