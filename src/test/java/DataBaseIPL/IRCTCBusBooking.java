package DataBaseIPL;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ObjectRepo.IRCTCBusBookingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class IRCTCBusBooking {
	
	WebDriver driver;
	String ele="IRCTC Bus";
	
	@BeforeMethod
	public void open() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		Thread.sleep(2000);
	}
	

	@Test
	public void iRCTCBusBooking() throws SQLException, InterruptedException, EncryptedDocumentException, IOException
	{
		String from="Bangalore";
		String to="Tumkur";
		IRCTCBusBookingPage iRCTCBusBookingPage=new IRCTCBusBookingPage(driver);
		iRCTCBusBookingPage.alertClick();
		Thread.sleep(2000);
		iRCTCBusBookingPage.headerName1();
		iRCTCBusBookingPage.headerName2();
		iRCTCBusBookingPage.busClick();
		Thread.sleep(2000);
		iRCTCBusBookingPage.switchWindow(driver, ele);
		
		iRCTCBusBookingPage.departFromSelect(driver, from);
		
		iRCTCBusBookingPage.toSelect(driver, to);
		iRCTCBusBookingPage.dateSelect();
		iRCTCBusBookingPage.searchBus();
		iRCTCBusBookingPage.clickAfter6PM();
		iRCTCBusBookingPage.getData(driver);

		
	}
	@AfterMethod
	public void close()
	{
		driver.close();
	}
}