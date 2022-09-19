package ShadowRoot;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowRootDom {

	@Test
	public void shadowElement() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://partners.pointsville.com/");

//		//username txt
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		WebElement username=(WebElement)js.executeScript("return document.querySelector(\"#root > div > div.flex-block > div.form-block > form > div.MuiGrid-root.flx-align-center.pt-30.MuiGrid-item.MuiGrid-grid-xs-12.MuiGrid-grid-sm-12 > div > div > div > div > input\")");
//		String un="arguments[0].value='Pavithra'";
//		((JavascriptExecutor)driver).executeScript(un, username);
//		Thread.sleep(2000);
//		//password txt
//		WebElement password=(WebElement)js.executeScript("return document.querySelector(\"#root > div > div.flex-block > div.form-block > form > div:nth-child(2) > div > div > div > div > input\")");
//		String pwd="arguments[0].value='Pavithra@123'";
//		((JavascriptExecutor)driver).executeScript(pwd, password);
//
//		Thread.sleep(2000);
//		//signup btn
//		WebElement signUp= (WebElement)js.executeScript("return document.querySelector(\"#root > div > div.flex-block > div.form-block > form > div.btn-flex-box > button > span.MuiButton-label\")");
//		((JavascriptExecutor)driver).executeScript("arguments[0].click();", signUp);
		
		driver.findElement(By.name("userName")).sendKeys("Pavithra");
	}
}