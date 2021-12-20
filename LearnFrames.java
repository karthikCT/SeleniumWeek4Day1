package week4.day1;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class LearnFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");

driver.switchTo().frame("iframeResult");
driver.findElement(By.xpath("//button[text()='Try it']")).click();

Alert alert = driver.switchTo().alert();
alert.sendKeys("Karthik");
alert.accept();
String text = driver.findElement(By.id("demo")).getText();
if (text.contains("Karthik"))
{
	System.out.println("Test Passed");
	}
else
{
	System.out.println("TestFailed");
	
}
	}

}
