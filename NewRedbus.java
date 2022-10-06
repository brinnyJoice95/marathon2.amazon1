package Marathan;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewRedbus {
	private static final String Duration = null;

	public static void main(String[] args) throws InterruptedException, IOException {
		
	
	WebDriverManager.chromedriver().setup();
    ChromeDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.redbus.in");
    driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));
    driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Chennai");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Bangalore");
    Thread.sleep(2000);
    
    driver.findElement(By.id("onward_cal")).click();
    
    driver.findElement(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr[4]/td[5]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[@id='search_btn']")).click();
  	//07) Print the number of buses shown as results (104 Buses found)
    Thread.sleep(5000);
   driver.findElement(By.xpath("//i[@class='icon icon-close']")).click();
   Thread.sleep(3000);
	String numberOfBus = driver.findElement(By.xpath("//span[text()='92']")).getText();
	System.out.println(numberOfBus);
	//08) Choose SLEEPER in the left menu 
	WebElement signup  = driver.findElement(By.xpath("//div[text()='SEAT AVAILABILITY']"));
    Actions builder=new Actions(driver);
    builder.scrollToElement(signup).perform();
  
	Thread.sleep(3000);
	driver.findElement(By.xpath("//label[@for='bt_SLEEPER']")).click();
	//8)Count of sleeper bus
	
	Thread.sleep(2000);
	String sleeperbuses = driver.findElement(By.xpath("//span[text()='70']")).getText();
	System.out.println("Sleeper count:" +sleeperbuses);Thread.sleep(3000);
	//09) Print the name of the second resulting bus 
	String secondBusName = driver.findElement(By.xpath("(//div[contains(@class,'travels lh-24')])[2]")).getText();
	System.out.println("SeconBus Name:"+secondBusName);
	
	//10) Click the VIEW SEATS of that bus
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//div[text()='View Seats'])[2]")).click();
	//11) Take screenshot and close browser
	File source2 = driver.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
	File dest2=new File("./redbus/screenshort2.png");
	FileUtils.copyFile(source2, dest2);
	driver.close();
    
    
	}
}
