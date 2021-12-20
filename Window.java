package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window {

	public static void main(String[] args) throws InterruptedException {

		//Setup
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("----disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://www.leafground.com/pages/Window.html");
		
		//Click button to open home page in New Window
		driver.findElement(By.id("home")).click();
		
		//Find the number of opened windows
				Set<String> windowHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>(windowHandles);
System.out.println(handles.size());
		driver.switchTo().window(handles.get(1));		
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(handles.get(0));
		
		//Open Multiple Window
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> handles1 = new ArrayList<String>(windowHandles1);
System.out.println(handles1.size());
driver.switchTo().window(handles1.get(2));
driver.close();
driver.switchTo().window(handles1.get(1));
driver.close();
driver.switchTo().window(handles1.get(0));


//Do Not Close Me
driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
Set<String> windowHandles2 = driver.getWindowHandles();
List<String> handles2 = new ArrayList<String>(windowHandles2);
driver.switchTo().window(handles2.get(2));
driver.close();
driver.switchTo().window(handles2.get(1));
driver.close();
driver.switchTo().window(handles2.get(0));

////Wait for 2 new Windows to open
driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
Set<String> windowHandles3 = driver.getWindowHandles();
List<String> handles3 = new ArrayList<String>(windowHandles3);
int size3 = handles3.size();
System.out.println(size3);
Thread.sleep(2000);

driver.quit();
	}
}