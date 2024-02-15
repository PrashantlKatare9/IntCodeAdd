package demoExample;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import dev.failsafe.Timeout;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;
public class Example {

	WebDriver driver;
	@BeforeTest
	public void example() {
	
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver(option);
        
        driver.get("https://www.tendable.com/");
        
        driver.manage().window().maximize();
        
        	}
	
	@Test (priority = 1)
	public void firstTest1() throws InterruptedException {
		
	    Thread.sleep(3000);
		driver.findElement(By.xpath("//li//a[@href=\"https://www.tendable.com/our-story\"]")).click();
		
		String ActualResult=driver.findElement(By.xpath("//h2[normalize-space()='Our Origin Story']")).getText();
		String ExpectedResult="Our Origin Story";
		
		Assert.assertEquals(ActualResult, ExpectedResult);
		
		driver.navigate().back();
	}
	
	@Test (priority = 2)
	public void firstTest2() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Our Solution']")).click();
		String ActualResult=driver.findElement(By.xpath("//a[text()='Request a demo']")).getText();
		String ExpectedResult="Request a demo";
		
		Assert.assertEquals(ActualResult, ExpectedResult);
		driver.navigate().back();
		
	}
	@Test (priority = 3)
	public void firstTest3() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Why Tendable?']")).click();
		String ActualResult=driver.findElement(By.xpath("//h2[text()='Why should you choose Tendable?']")).getText();
		String ExpectedResult="Why should you choose Tendable?";
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(ActualResult, ExpectedResult);
		driver.navigate().back();
		
	}
	@Test  (priority = 4)
	public void SecondTest() throws InterruptedException {
		
		Thread.sleep(3000);
		 boolean isElementVisible = driver.findElement(By.linkText("Request A Demo")).isDisplayed();

		 System.out.println("We found the element – " +isElementVisible );
                  
		driver.findElement(By.xpath("//a[text()='Request A Demo']")).click();
		String ActualResult=driver.findElement(By.xpath("//h1[text()='Request a Demo']")).getText();
		String ExpectedResult="Request a Demo";
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(ActualResult, ExpectedResult);
		driver.navigate().back();
		
	}
	@Test  (priority = 5)
	public void ThirdTest() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Contact Us']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@class='body-button bg-plain-600 toggle-control'][normalize-space()='Contact'])[1]")).click();
		
		driver.findElement(By.xpath("(//input[@id='form-input-fullName'])[1]")).sendKeys("sampleName");
		driver.findElement(By.xpath("(//input[@id='form-input-organisationName'])[1]")).sendKeys("OrgName");
		driver.findElement(By.xpath("(//input[@id='form-input-cellPhone'])[1]")).sendKeys("123456789");
		driver.findElement(By.xpath("(//input[@id='form-input-email'])[1]")).sendKeys("abc@gmail.com");

		Thread.sleep(1000);
		Select objSelect =new Select(driver.findElement(By.xpath("(//select[@id='form-input-jobRole'])[1]")));
		objSelect.selectByIndex(1);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id='form-input-consentAgreed-0'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@data-loading-text='Loading...'][text()='Submit'])[1]")).click();
		

		String ActualResult=driver.findElement(By.xpath("(//button[@data-loading-text='Loading...'][text()='Submit'])[1]")).getText();
		String ExpectedResult="Sorry, there was an error submitting the form. Please try again.";
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(ActualResult, ExpectedResult);
		driver.navigate().back();
		
	}
}
