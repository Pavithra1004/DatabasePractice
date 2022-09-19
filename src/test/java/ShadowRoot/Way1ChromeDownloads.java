package ShadowRoot;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Way1ChromeDownloads {
	
	@Test
	public void chomeDownloads() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().window().maximize();
		driver.get("chrome://downloads/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement search=(WebElement)js.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('downloads-toolbar#toolbar').shadowRoot.querySelector('cr-toolbar#toolbar').shadowRoot.querySelector('cr-toolbar-search-field#search').shadowRoot.querySelector('div#searchTerm>input#searchInput')");
		String un="arguments[0].value='pdf'";
		js.executeScript(un, search);
		Thread.sleep(2000);
		System.out.println("Enter the text to search text field");
		driver.quit();
	}

}
