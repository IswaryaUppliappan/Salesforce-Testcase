package testleafinternship.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class AccSort {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("//p[text()='Sales']")).click();
        WebElement opp=driver.findElement(By.xpath("(//span[text()='Accounts'])[1]"));
        driver.executeScript("arguments[0].click();", opp);
        WebElement s = driver.findElement(By.xpath("(//a[@class='toggle slds-th__action slds-text-link--reset '])[1]"));
        s.click();
        String actual_Result=driver.findElement(By.xpath("//span[@class='countSortedByFilteredBy']")).getText();
		String expected_Result="6 items • Sorted by Account Name •";
		Assert.assertEquals(actual_Result,expected_Result);
	
	}

}
