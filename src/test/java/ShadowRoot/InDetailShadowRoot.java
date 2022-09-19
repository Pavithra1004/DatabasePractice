package ShadowRoot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InDetailShadowRoot {

	public class ShadowDOMExample {

		public WebDriver driver;
		public WebElement root5;

		@BeforeTest
		public void setUp() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		@Test
		public void testGetText_FromShadowDOMElements() {
			System.out.println("Open Chrome downloads and search");
			driver.get("chrome://downloads/");

			WebElement root1 = driver.findElement(By.tagName("downloads-manager"));

			//Get shadow root element
			WebElement shadowRoot1 = expandRootElement(root1);

			WebElement root2 = shadowRoot1.findElement(By.cssSelector("downloads-toolbar"));
			WebElement shadowRoot2 = expandRootElement(root2);

			WebElement root3 = shadowRoot2.findElement(By.cssSelector("cr-toolbar"));
			WebElement shadowRoot3 = expandRootElement(root3);

			WebElement root4 = shadowRoot3.findElement(By.cssSelector("cr-toolbar-search-field#search"));
			WebElement shadowRoot4 = expandRootElement(root4);

			WebElement root5 = shadowRoot4.findElement(By.cssSelector("div#searchTerm>input#searchInput"));
			//WebElement shadowRoot5 = expandRootElement(root5);

			
		}

		private WebElement expandRootElement(WebElement root5) {
			WebElement js = (WebElement) ((JavascriptExecutor) driver);
					//.executeScript("return arguments[0].value='Pavithra'",root5);
			String un="arguments[0].value='Pavithra'";
			((JavascriptExecutor) js).executeScript(un, root5);
			return js;
		}

//		@AfterTest
//		public void tearDown() {
//			driver.quit();
//		}

}
}
