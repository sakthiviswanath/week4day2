package week4.day2;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ServiceNow {



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
		driver.findElementById("user_password").sendKeys(" India@123");
		
		String title = driver.getTitle();
		System.out.println(title);

		driver.close();

	}

}
