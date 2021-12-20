package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesLeafGround {

	public static void main(String[] args) throws IOException {
// Setup
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Get URL
		driver.get("http://leafground.com/pages/frame.html");
		
		//Switch to Frame
		driver.switchTo().frame(0);
		WebElement click = driver.findElement(By.id("Click"));
		
		//Snapshoot
		File source = click.getScreenshotAs(OutputType.FILE);
		File destination = new File("./click.png");
		FileUtils.copyFile(source, destination);
		
		driver.switchTo().defaultContent();
		
		//Frame Counts 
		List<WebElement> frame = driver.findElements(By.xpath("//iframe"));
		int size = frame.size();
		int count = size;
		
		for (int i = 0; i < size; i++) {
			driver.switchTo().frame(i);
			count = count + driver.findElements(By.tagName("iframe")).size();
			driver.switchTo().defaultContent();
		}
		System.out.println(count);
		driver.close();


	}

}
