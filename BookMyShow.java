package Marathon2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookMyShow {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(ch);
	
		driver.get("https://in.bookmyshow.com");
				driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//img[@alt='HYD']")).click();
		String url =driver.getCurrentUrl();
		System.out.println(url);
		driver.findElement(By.xpath("(//div[@id='2']//span)[2]")).click();
		driver.findElement(By.linkText("Ponniyin Selvan - Part 1 (UA)")).click();
		String name = driver.findElement(By.linkText("AMB Cinemas: Gachibowli")).getText();
		System.out.println(name);
		
		driver.findElement(By.xpath("//div[@class='venue-info-text']")).click();
		String parking = driver.findElement(By.xpath("//div[text()='            Parking Facility        ']")).getText();
		  if (parking.contains("Parking Facility")) {
			  System.out.println("Parking Facility is available");
		  }
		  else
		  {
			  System.out.println("Parking Facility is not available");
		  }
		
		 
			 driver.findElement(By.xpath("//div[@class='cross-container']")).click();
			  
			  driver.findElement(By.xpath("(//div[@class='__details']//div)[3]")).click();
			 
			  driver.findElement(By.xpath("//div[@id='btnPopupAccept']")).click();
			
			  driver.findElement(By.xpath("//li[@id='pop_1']")).click();
			  driver.findElement(By.xpath("//div[@id='proceed-Qty']")).click();
			  Thread.sleep(3000);
			  
			  //driver.findElement(By.xpath("//div[@id='B_5_0215']/a[1]")).click();
			  WebElement accountClick = driver.findElement(By.xpath("//a[@class='_available _selected']"));
			  				
				 driver.executeScript("arguments[0].click();",accountClick);
				          
			 // driver.findElement(By.xpath("//div[contains(@class,'__seat-action btn-bar')]//a[1]")).click();
			  driver.findElement(By.xpath("//span[text()='Rs.295.00']")).click();
			 String subTotal = driver.findElement(By.xpath("//span[@id='subTT']")).getText();
			 System.out.println(subTotal);
			driver.quit();
	}}


