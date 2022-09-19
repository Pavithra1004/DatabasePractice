package DataBaseIPL;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VCheckHW {
	 WebDriver driver;
	 @BeforeTest
	 public void setup() throws Exception {
		 WebDriverManager.chromedriver().setup();
	  driver =new ChromeDriver();     
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://only-testing-blog.blogspot.com/2014/09/selectable.html");
	 }
	 
	 @Test
	 public void getSize() throws Exception {
	  //Locate element for which you wants to get height and width.
	        WebElement Image = driver.findElement(By.xpath("//img[@border='0']"));
	        
	        //Get width of element.
	        int ImageWidth = Image.getSize().getWidth();
	        System.out.println("Image width Is "+ImageWidth+" pixels");
	        
	        //Get height of element.
	        int ImageHeight = Image.getSize().getHeight();        
	        System.out.println("Image height Is "+ImageHeight+" pixels");
	 }

}
