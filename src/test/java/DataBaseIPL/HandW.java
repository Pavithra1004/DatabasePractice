package DataBaseIPL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandW {
	@Test
	public void handW()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://en.wikipedia.org/wiki/IPhone");
		
		WebElement ele = driver.findElement(By.xpath("//figure[@class='cbnnr-icon ']"));
		
		int h = ele.getSize().getHeight();
		int w = ele.getSize().getWidth();
		
		System.out.println("Image width Is "+w+" pixels");

		     
		System.out.println("Image height Is "+h+" pixels");
	}

}
