package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException, IOException {
//Setup
WebDriverManager.chromedriver().setup();
ChromeOptions options = new ChromeOptions();
options.addArguments("--disable-notifications");
ChromeDriver driver = new ChromeDriver(options);
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

//Get URL
driver.get("https://dev93109.service-now.com/");

//Login
driver.switchTo().frame("gsft_main");
driver.findElement(By.id("user_name")).sendKeys("admin");
driver.findElement(By.id("user_password")).sendKeys("RenjiK0^6");
driver.findElement(By.id("sysverb_login")).click();

driver.switchTo().defaultContent();
driver.findElement(By.xpath("//*[@id='filter']")).sendKeys("incident");
driver.findElement(By.xpath("(//*[text()='All'])[2]")).click();
driver.switchTo().frame("gsft_main");
driver.findElement(By.id("sysverb_new")).click();

driver.findElement(By.id("lookup.incident.caller_id")).click();
Set<String> windowHandles = driver.getWindowHandles();
List<String> handles = new ArrayList<String>(windowHandles);

driver.switchTo().window(handles.get(1));
driver.findElement(By.xpath("(//td/a)[2]")).click();
driver.switchTo().window(handles.get(0));
driver.switchTo().frame("gsft_main");
driver.findElement(By.id("incident.short_description")).sendKeys("Kat Testing");
String inum = driver.findElement(By.id("incident.number")).getDomAttribute("value");
System.out.println("Incident Number: " + inum);
driver.findElement(By.xpath("//*[@id='sysverb_insert']")).click();
Thread.sleep(2000);

driver.findElement(By.xpath("//span[text()='Press Enter from within the input to submit the search.']//following-sibling::input")).sendKeys(inum, Keys.ENTER);
driver.findElement(By.linkText(inum)).click();

//Snapshot
File source = driver.getScreenshotAs(OutputType.FILE);
File destination = new File("./firstss.png");
FileUtils.copyFile(source, destination);
	}
	

}
