package ShadowRoot;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Way3ShadowRoot {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().window().maximize();
		driver.get("http://watir.com/examples/shadow_dom.html");
		WebElement shadowHost = driver.findElement(By.cssSelector("#shadow_host"));
		SearchContext shadowRoot = shadowHost.getShadowRoot();
		WebElement shadowContent = shadowRoot.findElement(By.cssSelector("#shadow_content"));
		Thread.sleep(2000);
		if(shadowContent.getText().contains("some text")) {
			System.out.println("Text is present");
		}
		else
		{
			System.out.println("Text not present");
		}
		driver.quit();
	}
}
