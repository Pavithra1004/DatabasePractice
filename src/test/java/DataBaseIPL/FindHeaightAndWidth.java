package DataBaseIPL;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindHeaightAndWidth {
	public WebDriver driver;
	@Test
	public void checkHeaightAndWidth() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.moneycontrol.com/");
		//Thread.sleep(12000);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		WebElement ele = driver.findElement(By.id("gwd-taparea_1"));

		wait.until(ExpectedConditions.visibilityOf(ele));
		Point loc = ele.getLocation();
		int xValue = loc.getX();
		int yValue = loc.getY();
		System.out.println("X value is : "+xValue);
		System.out.println("Y value is : "+yValue);
		
//		int width = ele.getSize().getWidth();
//		int height = ele.getSize().getHeight();
//		System.out.println("width :"+width);
//		System.out.println("height :"+height);
//		
		 int height1 = ele.getRect().getHeight();
		int width1 = ele.getRect().getWidth();
		
		System.out.println("height  is : "+height1+" pixel");
		System.out.println("Width is : "+width1+" pixel");
		
		driver.quit();
		
	
	}

}
