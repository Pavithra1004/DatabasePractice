package ShadowRoot;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleDownload {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("inspirational quotes images download",Keys.ENTER);
		driver.findElement(By.xpath("//div[@class='xte2qe OXEsB l5X1Ye']/descendant::div[@data-docid='3XLugItLTR30pM']")).click();
		driver.findElement(By.xpath("//div[@jsname='CGzTgf']/descendant::div[@jsname='QH4tvd']/descendant::span[@class='q7UPLe K8E1Be pFBf7b']")).click();
		
		Set<String>allIds=driver.getWindowHandles();
		for(String id:allIds) {
			driver.switchTo().window(id)
;
			if(driver.getTitle().contains("Wallpaper")) {
				break;
			}
		}
		
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
		driver.findElement(By.xpath("//div[@id='nav-below']/descendant::div[@class='down-wall']")).click();
		
		driver.get("chrome://downloads/");
		
		WebElement root=driver.findElement(By.tagName("downloads-manager"));
		SearchContext shadowDom1 = getShadowDOMTest(driver,root);
		
		WebElement root1 = shadowDom1.findElement(By.cssSelector("downloads-item"));
		SearchContext shadowDom2 =getShadowDOMTest(driver,root1);

		WebElement element=shadowDom2.findElement(By.cssSelector("div[id='title-area']>a"));
		element.click();
	}

	
	public static SearchContext getShadowDOMTest(WebDriver driver, WebElement element){
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		SearchContext shadowDom=(SearchContext)jse.executeScript("return arguments[0].shadowRoot", element);
		return shadowDom;
		
	}

}
