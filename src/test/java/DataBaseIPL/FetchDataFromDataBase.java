package DataBaseIPL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchDataFromDataBase {
	WebDriver driver;
	
	@Test
	public void iPLDataStoreIntoDataBase() throws SQLException
	{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	driver.manage().window().maximize();

	driver.get("https://www.google.com/search?q=IPL+ranknking+2022&oq=IPL+ranknking+2022&aqs=chrome.0.69i59j0i13l8j0i22i30.1021j0j7&sourceid=chrome&ie=UTF-8#cobssid=s");

	driver.findElement(By.xpath("//span[@class='wHYlTd RES9jf' and text()='See more']")).click();

	List<WebElement> teams = driver.findElements(By.xpath("//div[@class='tb_c immersive-container tb_stc']/descendant::table[@class='Jzru1c']//tr/td[3]"));
	
	
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pro", "Pavithra", "Root@123");
	Statement statement = connection.createStatement();
	System.out.println(teams.size());
	try {

		System.out.println("SLN" +" 		"+"TeamName "+" 	"+"Matches"+" 	"+" Win"+"	 	 "+"Loss");
				 ResultSet result1 = statement.executeQuery("select * from IPL_Ranking;");
				 while(result1.next())
				 {
					 
					 System.out.println(result1.getString(1)+ "		"+result1.getString(2)+"		"+result1.getString(3)+"		 "+result1.getString(4)+"		 "+result1.getString(5));
				 }

	}catch(Exception e)
	{
		e.getMessage();
	}
	//validation of team name
	
	ArrayList<String> list=new ArrayList<String>();
	for(WebElement teamsName:teams)
	{
		list.add(teamsName.getText());
	}
	
	ArrayList<String> list1=new ArrayList<String>();
	ResultSet result2 = statement.executeQuery("select TeamName from IPL_Ranking;");
	
	while(result2.next())
	{
		list1.add(result2.getString(1));
	}
	SoftAssert ast=new SoftAssert();
	ast.assertEquals(list, list1);
	System.out.println("TeamNames Verified sucessfully");
	ast.assertAll();
	
	connection.close();
	

}


}