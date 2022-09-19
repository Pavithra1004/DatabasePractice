package ShadowRoot;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Way2ShadowGoogleDownlosds {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().window().maximize();
		driver.get("https://unsplash.com/s/photos/wild-animal");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.findElement(By.xpath("//img[@alt='brown elephant on green grass field during daytime']")).click();
		driver.findElement(By.xpath("//span[text()='Download free']")).click();
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.get("chrome://downloads/");
		
		WebElement root1 = driver.findElement(By.tagName("downloads-manager"));
		SearchContext root = (SearchContext) js.executeScript("return arguments[0].shadowRoot", root1);
		
		
		WebElement shadowroot4 = root.findElement(By.cssSelector("downloads-item"));
		SearchContext shadowroot5 = (SearchContext) js.executeScript("return arguments[0].shadowRoot", shadowroot4);
		
		Thread.sleep(2000);
		
		WebElement ele = shadowroot5.findElement(By.cssSelector("div[id='details']>div"));
		ele.click();
		Thread.sleep(2000);
		System.out.println("clicked the particlar element by using cssSelector");
		driver.quit();
	}

}
