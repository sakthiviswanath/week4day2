package week4.day2;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Myntra {
	
	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		
		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome Beta\\Application\\chrome.exe");

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\deepak\\Downloads\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver(options);


		driver.get("https://www.myntra.com/");

		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait (driver,30);


		WebElement women = driver.findElementByXPath("//a[text()='Women']");
		Actions builder =new Actions(driver);
		builder.moveToElement(women).perform();
		Thread.sleep(2000);	
		
		driver.findElementByLinkText("Jackets & Coats").click();
		String total = driver.findElementByXPath("//span[@class='title-count']").getText();
		
		//String item = text.replaceAll("//D", "");
		//int no = Integer.parseInt(text);
		System.out.println(total);
		String jacket = driver.findElementByXPath("(//span[@class='categories-num'])[1]").getText();
		String coat = driver.findElementByXPath("(//span[@class='categories-num'])[2]").getText();
		
		String jacketnumber = jacket.replaceAll("\\W", "");
        String coatnumber = coat.replaceAll("\\W", "");
        String totalnumber = total.replaceAll("\\W ", "");
        String newtotalnumber = totalnumber.replaceAll("[a-z ]", "");


		System.out.println(coatnumber);
        System.out.println(jacketnumber);
		System.out.println(newtotalnumber);
		
		
		int parseInt1 = Integer.parseInt(coatnumber);
		int parseInt2 = Integer.parseInt(jacketnumber);
		int parseInt3 = Integer.parseInt(newtotalnumber);
		
		System.out.println(parseInt1);
        System.out.println(parseInt2);
		System.out.println(parseInt3);
		
		if(parseInt3 == parseInt1 + parseInt2 )
		{
			System.out.println("sum of categories count matches");
		}
		else
		{
			System.out.println("sum of categories count not matches");

		}
		
		driver.findElementByXPath("(//span[@class='categories-num']/following::div)[2]").click();
		driver.findElementByXPath("//div[@class='brand-more']").click();
		
		driver.findElementByXPath("//input[@placeholder='Search brand']").sendKeys("Mango");
		Thread.sleep(1000);
		driver.findElementByXPath("(//div[@class='common-checkboxIndicator']/following::div)[16]").click();
		driver.findElementByXPath("(//input[@type='text']/following::span)[10]").click();
		Thread.sleep(500);

		List<WebElement> mango = driver.findElementsByTagName("h3");
		Thread.sleep(500);

	    for (WebElement webElement : mango)
	    {
			Thread.sleep(500);
	    	String brandname = webElement.getText();
			Thread.sleep(500);


		if (brandname.contains("MANGO"))
		{
          System.out.println("mangooo");
			continue;         
          }
		else
		{
			System.out.println("mismatch");
		}
		
	    }
		System.out.println("All are MANGO brand");
		
		WebElement sort = driver.findElementByXPath("//div[@class='sort-sortBy']");
		builder.moveToElement(sort).perform();
		Thread.sleep(2000);	
		driver.findElementByXPath("//label[text()='Better Discount']").click();
		Thread.sleep(3000);
		String firstdress = driver.findElementByXPath("//span[@class='product-discountedPrice']").getText();
		Thread.sleep(3000);
		System.out.println(firstdress);
		
		//WebElement size = driver.findElementByXPath("(//h4[text()='Sizes: ']//span)[1]");
		//WebElement size = driver.findElementByXPath("//div[@class='product-sliderContainer']");
        WebElement size = driver.findElementByXPath("(//div[@class='product-productMetaInfo'])[1]");
		builder.moveToElement(size).perform();
		Thread.sleep(1000);
		driver.findElementByXPath("(//span[text()='wishlist'])[1]").click();
		
		
		
		
	}

}
