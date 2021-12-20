package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {

	public static void main(String[] args) throws InterruptedException {
	
		//Setup
		WebDriverManager.chromedriver().setup();
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--disable-notifications");
				ChromeDriver driver = new ChromeDriver(Options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		//Get URL
		driver.get("http://www.leafground.com/pages/Alert.html");
		
		//Alert Box
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
	org.openqa.selenium.Alert alert = driver.switchTo().alert();
	System.out.println(alert.getText());
	alert.accept();
	
	//Confirm Box
	driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
	org.openqa.selenium.Alert alert1 = driver.switchTo().alert();
	alert1.accept();
	
	//Prompt Box
	String result = driver.findElement(By.id("result")).getText();
	System.out.println(result);
	
	//Link Break
	driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
	org.openqa.selenium.Alert alert2 = driver.switchTo().alert();
	String result1 = alert2.getText();
	System.out.println(result1);
	alert2.accept();
	
	driver.findElement(By.id("btn")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//button[text()='OK']")).click();
	
	driver.quit();
	
	}

}
