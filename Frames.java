package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {
//Setup
WebDriverManager.chromedriver().setup();
ChromeOptions options = new ChromeOptions();
options.addArguments("--disable-notifications");
ChromeDriver driver = new ChromeDriver(options);
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//Get URL
driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");

//Switch To Frame1
driver.switchTo().frame("frame1");
driver.findElement(By.xpath("//input")).sendKeys("Testing");

//Switch to Frame3
driver.switchTo().frame("frame3");
driver.findElement(By.id("a")).click();

//Come Out Of Frames
driver.switchTo().defaultContent();
//driver.switchTo().frame("frame1");

//Switch To Frame2
driver.switchTo().frame("frame2");
WebElement animals = driver.findElement(By.id("animals"));
Select drop = new Select(animals);
drop.selectByIndex(2);

//Close all open tabs
driver.quit();

	}

}