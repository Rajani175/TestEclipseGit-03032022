import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnCSSSelectors {
	public WebDriver driver;
	String url = "";
	String verificationError = "";

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		url = "http://demo.automationtesting.in/Index.html";
	}
	 @Test
	  public void takeScreenshot() throws IOException {
	    try {
	      driver.get(url);
	      driver.findElement(By.cssSelector("#btn2")).click();
	      Thread.sleep(2000);
	      // key attribute
	      driver.findElement(By.cssSelector("input[placeholder='First Name']")).sendKeys("Rajani");
	// this is using with condition
	      driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("Reddy");
	      
	      WebElement el = driver.findElement(By.cssSelector("#yearbox"));
	      List <WebElement>optionValues = el.findElements(By.tagName("option"));
	      
	      for (WebElement optionValue : optionValues ) {
	        if (optionValue.getText().equals("2015")) {
	          optionValue.click();
	          break;
	        
	        
	        }
	      }
	      
	      System.out.println("year is selected");
	      
	      driver.findElement(By.cssSelector("button[value*='fre']")).click();
	      driver.findElement(By.cssSelector("button[value^='Ref']")).click();
	      driver.findElement(By.cssSelector("button[value$='esh']")).click();
	      
	    
	      
	      
	    } catch (Exception ex) {
	      verificationError = ex.getMessage();
	    }

	  }

	  @After
	  public void tierdown() {
	    driver.quit();
	    if (!verificationError.equals("")) {
	      Assert.fail();
	    }
	  }
	}