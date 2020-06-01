package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Irctc {

	public static void main(String[] args) throws InterruptedException, IOException {

		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome Beta\\Application\\chrome.exe");

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\deepak\\Downloads\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver(options);


		driver.get("https://www.irctc.co.in/nget/train-search");

		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait (driver,30);

		driver.findElementByXPath("//button[text()='Ok']").click();

		String first = driver.getWindowHandle();

		System.out.println(first);
		driver.findElementByLinkText("FLIGHTS").click();

		Set<String> set = driver.getWindowHandles();

		ArrayList<String> list = new ArrayList<String>(set);
		System.out.println(list);

		String win2 = list.get(1);
		String win1 = list.get(0);

		System.out.println(driver.getTitle());

		driver.switchTo().window(win2);

		System.out.println(driver.getTitle());


		Actions builder =new Actions(driver);
		Thread.sleep(2000);

		WebElement agree = driver.findElementByXPath("//label[@for='agree']");

		builder.click(agree).perform();

		WebElement cont = driver.findElementByXPath("//button[text()='Continue ']");

		builder.click(cont).perform();

		Thread.sleep(2000);


		//driver.getScreenshotAs(OutputType<X>.FILE);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./air/ticketing.png");
		FileUtils.copyFile(source, target);

		driver.switchTo().window(win1);

		driver.close();

	}


}
