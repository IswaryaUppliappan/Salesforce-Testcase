package testleafinternship.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class AccCreate {

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
        driver.findElement(By.xpath("//div[@title='New']")).click();
        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Iswarya");
        WebElement drop = driver.findElement(By.xpath("(//div[contains(@class,'slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click')])[4]"));
        driver.executeScript("arguments[0].click();", drop);
        driver.findElement(By.xpath("//span[@title='Public']")).click();
        driver.findElement(By.xpath("//button[text()='Save']")).click();
        String actual_Result=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
        String  expected_Result= "Account \"Iswarya\" was created.";
        Assert.assertEquals(actual_Result,expected_Result);
    
        

	}

}
