package ObjectRepo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class DrawSignaturePage {
	public WebDriver driver;
	public DrawSignaturePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/*
	 * click alert
	 */
	@FindBy(id="canvas_signature")
	private WebElement canvas;

	@FindBy(xpath="//div[@class='draw-field']")
	private WebElement length;



	public void signatureCanvas() throws IOException 
	{
		Genric.WebDriverUtility	webDriverDataUtility=new Genric.WebDriverUtility();
		webDriverDataUtility.dragAndDropBy(driver, canvas, 0, 0);

		webDriverDataUtility.clickAndHold(driver);
		webDriverDataUtility.moveByOffset(driver, -20, 90);
		webDriverDataUtility.release(driver);

		webDriverDataUtility.clickAndHold(driver);
		webDriverDataUtility.moveByOffset(driver, 20, -90);
		webDriverDataUtility.release(driver);

		webDriverDataUtility.clickAndHold(driver);
		webDriverDataUtility.moveByOffset(driver, 40, 90);
		webDriverDataUtility.release(driver);

		webDriverDataUtility.clickAndHold(driver);
		webDriverDataUtility.moveByOffset(driver, -30, -70);
		webDriverDataUtility.release(driver);


		webDriverDataUtility.clickAndHold(driver);
		webDriverDataUtility.moveByOffset(driver, -30, 0);
		webDriverDataUtility.release(driver);

		//B

		webDriverDataUtility.clickAndHold(driver);
		webDriverDataUtility.moveByOffset(driver,70, 0);
		webDriverDataUtility.release(driver);

		webDriverDataUtility.clickAndHold(driver);
		webDriverDataUtility.moveByOffset(driver,0, 70);
		webDriverDataUtility.release(driver);

		webDriverDataUtility.clickAndHold(driver);
		webDriverDataUtility.moveByOffset(driver,0, -70);
		webDriverDataUtility.release(driver);

		webDriverDataUtility.clickAndHold(driver);
		webDriverDataUtility.moveByOffset(driver,0, 20);
		webDriverDataUtility.release(driver);

		webDriverDataUtility.clickAndHold(driver);
		webDriverDataUtility.moveByOffset(driver,0, -20);
		webDriverDataUtility.release(driver);

		webDriverDataUtility.clickAndHold(driver);
		webDriverDataUtility.moveByOffset(driver,0, -5);
		webDriverDataUtility.release(driver);

		webDriverDataUtility.clickAndHold(driver);
		webDriverDataUtility.moveByOffset(driver,0, 5);
		webDriverDataUtility.release(driver);

		webDriverDataUtility.clickAndHold(driver);
		webDriverDataUtility.moveByOffset(driver,30, 0);

		webDriverDataUtility.moveByOffset(driver,0, 30);

		webDriverDataUtility.moveByOffset(driver,-30, 0);

		webDriverDataUtility.release(driver);

		webDriverDataUtility.clickAndHold(driver);
		webDriverDataUtility.moveByOffset(driver,30, 0);

		webDriverDataUtility.moveByOffset(driver,0, 30);

		webDriverDataUtility.moveByOffset(driver,-30, 0);

		webDriverDataUtility.release(driver);

		//c

		webDriverDataUtility.moveToElementWithCoordinates(driver, canvas, 130, 90);
		webDriverDataUtility.clickAndHold(driver);

		webDriverDataUtility.moveByOffset(driver,20, -80);
		webDriverDataUtility.moveByOffset(driver,50, -10);


		webDriverDataUtility.release(driver);
	}
	public void takeScreenShot() throws IOException
	{

		Screenshot expImage =new AShot().takeScreenshot(driver, canvas);
		ImageIO.write(expImage.getImage(), "png", new File("./screenshot/image.png"));

		
	}
	public void compareImage() throws IOException {
		//BufferedImage expImage = ImageIO.read(new File("D:\\TySelenium\\TYSSProject\\screenshot\\image.png"));
		BufferedImage expImage = ImageIO.read(new File("D:\\TySelenium\\TYSSProject\\ScreenShotOutput\\Screenshot 2022-09-02 152149.png"));
		Screenshot img = new	AShot().takeScreenshot(driver,canvas);
	 BufferedImage actImage = img.getImage();
	 ImageDiffer imgDiff=new ImageDiffer();
	  ImageDiff diff = imgDiff.makeDiff(expImage, actImage);
	  if(diff.hasDiff()==true)
	  {
		  System.out.println("Images are  same");
	  }
	  else
	  {
		  System.out.println("Images are not same");
	  }
	
	
	}
	
}

