package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		// To Disable Notification
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		//option.setHeadless(true);
		
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
//Launch URL "http://leaftaps.com/opentaps/control/login"		
driver.get("http://leaftaps.com/opentaps");

//Enter UserName and Password Using Id Locator
driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
driver.findElement(By.id("password")).sendKeys("crmsfa");

//Click on Login Button using Class Locator
driver.findElement(By.className("decorativeSubmit")).click();

//Click on CRM/SFA Link
driver.findElement(By.linkText("CRM/SFA")).click();

//Click on contacts Button
driver.findElement(By.linkText("Contacts")).click();

//Click on Merge Contact
driver.findElement(By.linkText("Merge Contacts")).click();
driver.findElement(By.xpath("(//td/a)[3]")).click();
Set<String> windowHandles = driver.getWindowHandles();
List<String> handles = new ArrayList<String>(windowHandles);

driver.switchTo().window(handles.get(1));
driver.findElement(By.xpath("((//tbody)[3]/tr/td/div/a)[1]")).click();

driver.switchTo().window(handles.get(0));

driver.findElement(By.xpath("(//td/a)[4]")).click();
Set<String> windowHandles1 = driver.getWindowHandles();
List<String> handles1 = new ArrayList<String>(windowHandles1);

driver.switchTo().window(handles1.get(1));
driver.findElement(By.xpath("((//tbody)[4]/tr/td/div/a)[1]")).click();
driver.switchTo().window(handles.get(0));
driver.findElement(By.xpath("//a[text()='Merge']")).click();

Alert alert = driver.switchTo().alert();
alert.accept();

String title = driver.getTitle();

System.out.println(title);

driver.quit();
	}

}
