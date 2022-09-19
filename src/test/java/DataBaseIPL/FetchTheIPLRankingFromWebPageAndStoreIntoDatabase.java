package DataBaseIPL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchTheIPLRankingFromWebPageAndStoreIntoDatabase {
	WebDriver driver;

	@Test
	public void iPLDataStoreIntoDataBase() throws SQLException
	{
		
		//webdriver
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().window().maximize();
		driver.get("https://www.google.com/search?q=IPL+ranknking+2022&oq=IPL+ranknking+2022&aqs=chrome.0.69i59j0i13l8j0i22i30.1021j0j7&sourceid=chrome&ie=UTF-8#cobssid=s");

		driver.findElement(By.xpath("//span[@class='wHYlTd RES9jf' and text()='See more']")).click();

		List<WebElement> teams = driver.findElements(By.xpath("//div[@class='tb_c immersive-container tb_stc']/descendant::table[@class='Jzru1c']//tr/td[3]"));
		List<WebElement> Mcount = driver.findElements(By.xpath("//div[@class='tb_c immersive-container tb_stc']/descendant::table[@class='Jzru1c']//tr/td[4]"));
		List<WebElement> Wount = driver.findElements(By.xpath("//div[@class='tb_c immersive-container tb_stc']/descendant::table[@class='Jzru1c']//tr/td[5]"));
		List<WebElement> Lcount = driver.findElements(By.xpath("//div[@class='tb_c immersive-container tb_stc']/descendant::table[@class='Jzru1c']//tr/td[6]"));

		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pro", "Pavithra", "Root@123");
		Statement statement = connection.createStatement();
		System.out.println(teams.size());
		try {
			int j=1;
			for(int i=0;i<=teams.size()-1;i++)
			{
				int result1=statement.executeUpdate("insert into IPL_Ranking values('"+j+"','"+teams.get(i).getText()+"','"+Mcount.get(i).getText()+"','"+Wount.get(i).getText()+"','"+Lcount.get(i).getText()+"');");
				j++;
				if(result1>=1)
				{
					System.out.println("Data inserted successfully"+i);
				}
			}
		}catch(Exception e)
		{
			e.getMessage();
		}
		connection.close();
	}
}
