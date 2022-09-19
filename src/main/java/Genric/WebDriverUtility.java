package Genric;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class WebDriverUtility {





	public Actions actions;
	public Robot robot;

	/**
	 *   A mouse hover is also called as hover.
	 *  Mouse hover action is basically an action where a user places a mouse over a designated area like a hyperlink.
	 *  It can cause some event to get triggered.
	 */
	public void moveToElement(WebDriver driver, WebElement element) {
		actions=new Actions(driver);
		actions.moveToElement(element).perform();
	}
	
	public void moveToElementWithoutPerform(WebDriver driver, WebElement element) {
		actions=new Actions(driver);
		actions.moveToElement(element);
	}

	/**
	 *  The purpose of this method is to take a mouse on specific points on target elements.
	 * there are some cases where to perform some actions on an element, 
	 * it is mandatory to move the mouse to a specific location on the element only.
	 */
	public void moveToElementWithCoordinates(WebDriver driver,WebElement element,int x,int y) {
		actions=new Actions(driver);
		actions.moveToElement(element, x, y).perform();
	}

	/**
	 * The moveByOffset() method is used to move the mouse from its current position to another point on the web page.
	 * specify the x distance and the y distance the mouse has to be moved.
	 *  When the page is loaded, generally the initial position of the mouse would be (0, 0),
	 *   unless there is an explicit focus declared by the page.
	 */
	public void moveByOffset(WebDriver driver,int x, int y) {
		actions=new Actions(driver);
		actions.moveByOffset(x, y).perform();
	}

	/**
	 * This method is used to click the element
	 * but the WebElement is not passed inside the function.
	 */
	public void click(WebDriver driver) {
		actions=new Actions(driver);
		actions.click().perform();
	}
	
	/**
	 * This method is used to click a particular WebElement that is passed inside the function.
	 */
	public void clickElement(WebDriver driver, WebElement element){
		actions=new Actions(driver);
		actions.click(element).perform();
	}
	
	/**
	 * Click and hold is an action in Selenium in which we do left-click on an element and 
	 * hold it without releasing the left button of the mouse.
	  */
	public void clickAndHold(WebDriver driver) {
		actions=new Actions(driver);
		actions.clickAndHold().perform();
	}

	/**
	 *  if we want to deal with a particular WebElement on a web page, 
	 * we will have to use an overloaded version of clickAndHold() method of actions class. 
	 * It helps to avoid moving of cursor to location of any web element.
	 */
	public void clickAndHoldElement(WebDriver driver,WebElement element1,WebElement element2) {
		actions=new Actions(driver);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		actions.clickAndHold(element1).moveToElement(element2).pause(Duration.ofSeconds(10)).release().build().perform();
	}

	/**
	 * Right Click operation is also called Context Click in Selenium.
	 *  Pre-defined method context click provided by Actions class is used to perform right click operation. 
	 */
	public void contextClick(WebDriver driver) {
		actions=new Actions(driver);
		actions.contextClick().perform();
	}

	/**
	 * Right Click operation is also called Context Click in Selenium.
	 *  Pre-defined method context click provided by Actions class is used to perform right click operation. 
	 *  Element is stored Inside the functions.
	 */
	public void contextClickElement(WebDriver driver,WebElement element) {
		actions=new Actions(driver);
		actions.contextClick(element).perform();
	}

	/**
	 * Using the pre-defined double click method of Actions class, we need to perform double click operation on the web element
	 * 
	 */
	public void doubleClick(WebDriver driver) {
		actions=new Actions(driver);
		actions.doubleClick().perform();
	}
	
	/**
	 * Using the pre-defined double click method of Actions class, we need to perform double click operation on the web element
	 * The element is stored inside the function.
	 */
	public void doubleClickElement(WebDriver driver,WebElement element) {
		actions=new Actions(driver);
		actions.doubleClick(element).perform();
	}

	/**
	 * dragAndDrop(WebElement source, WebElement target): 
	 * This method performs left click, hold the click to hold the source element, 
	 * moves to the location of the target element and then releases the mouse click.
	 */
	public void dragAndDrop(WebDriver driver,WebElement element1, WebElement element2) {
		actions=new Actions(driver);
		actions.dragAndDrop(element1, element2).perform();
	}

	/**
	 * This method clicks & holds the source element and moves by a given offset, then releases the mouse.
	 *  Offsets are defined by x & y.
	 *  xOffset is horizontal movement.
	 *  yOffset is a vertical movement. 
	 */
	public void dragAndDropBy(WebDriver driver,WebElement element,int x, int y) {
		actions=new Actions(driver);
		actions.dragAndDropBy(element, x, y).perform();
	}

	public void getActiveKeyBoard(WebDriver driver) {
		actions=new Actions(driver);
		actions.getActiveKeyboard(); //========>perform
	}

	public void getActivePointer(WebDriver driver) {
		actions=new Actions(driver);
		actions.getActivePointer();//===========>perform
	}

	/**
	 * This method presses the specified key on the currently focused Web Element. 
	 * This method generally presses the "Modifier keys" such as SHIFT, CTRL, etc. 
	 * If you want to press the keyboard key on a specified web element, then that web element first needs to be focussed explicitly,
	 *  and then this method needs to be invoked.
	 * 
	 */
	
	public void keyDown(WebDriver driver) {
		actions=new Actions(driver);
		actions.keyDown(null).perform();
	}

	/**
	 * This method releases the specified key on the currently focused Web Element. 
	 * If you want to release the keyboard key on a specified web element, then that web element first needs to be focused explicitly, 
	 * and then this method needs to be invoked.
	 * 
	 */
	public void keyUp(WebDriver driver) {
		actions=new Actions(driver);
		actions.keyUp(null).perform();
	}

	/**
	 * This method is used to perform more than two actions 
	 * Therefore,,we are using build method because more than two actions. 
	 */
	
	public void keyDownAndKeyUp(WebDriver driver,String key) {
		actions=new Actions(driver);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		actions.keyDown(Keys.CONTROL).sendKeys(key).keyUp(Keys.CONTROL).build().perform();
	}
	
	/**
	 * Actions class using keys class inside sendKeys 
	 */
	public void keyInsideSendKeys(WebDriver driver) {
		actions=new Actions(driver);
		 actions.sendKeys(Keys.TAB).build().perform();
		 
	}
	
	
	/**
	 * This method first focuses on the web element, which has been passed as a parameter to the method and presses 
	 * the mentioned key on that Web Element. 
	 */
	public void keyDownElementTarget(WebDriver driver,WebElement element){
		actions=new Actions(driver);
		actions.keyDown(element, null);
	}

	/**
	 * This method first focuses on the web element, which gets passed as a parameter to the method. 
	 * Then, it releases the mentioned key on that Web Element. 
	 */
	public void keyUpWebElementTarget(WebDriver driver,WebElement element) {
		actions=new Actions(driver);
		actions.keyUp(element, null).perform();
	}

	/**
	 *This method is perform key down actions in selected target 
	 *We are using two methods that's why using build method
	 */
	
	public void keyDownElementTarget(WebDriver driver,WebElement element,String message) {
		actions=new Actions(driver);

		actions.keyDown(element, Keys.SHIFT).sendKeys(message).build().perform();
		
	}
	
	/**
	 * This method is perform key up actions in selected target 
	 * We are using two methods that's why using build method
	 */
	public void keyUpElementTarget(WebDriver driver,WebElement element,String message) {
		actions=new Actions(driver);

		actions.keyUp(element, Keys.SHIFT).sendKeys(message).build().perform();
		
	}
	
	/**
	 * This method sends a sequence of keys to a currently focused web element, i.e., 
	 * if we want to send specific characters to a web element, that element must be first focussed, 
	 * then only the mentioned characters will go to that web element. 
	 */
	public void sendKeysActions(WebDriver driver, String message) {
		actions=new Actions(driver);
		actions.sendKeys(message).perform();
	}
	
	/**
	 * This implementation of the sendKeys() method sends a sequence of characters/keys to a specific web element,
	 *  which passes as the first parameter to the method. 
	 * This method first focuses on the target web element and then performs the same action as sendKeys(CharSequence keys). 
	 */
	public void sendKeysElementTarget(WebDriver driver,WebElement element,String message) {
		actions=new Actions(driver);
		actions.sendKeys(element, message).perform();
	}

	/**
	 * This method is used to do pause actions.
	 * It can also be used between two actions 
	 * For Eg: click between "clickAndHold()" and "release()"
	 */
	public void pause(WebDriver driver) {
		actions=new Actions(driver);
		actions.pause(Duration.ofSeconds(10)).perform();
	}

	/**
	 * This method is used to do long pause actions.
	 * It can also be used between two actions 
	 * For eg: click between "clickAndHold()" and "release()"
	 */
	 

	public void longPause(WebDriver driver) {
		actions =new Actions(driver);
		actions.pause(Duration.ofSeconds(20)).perform();
	}
	
	/**
	 * It is used to release the mouse pointer which was on hold
	 * This  release function does not contain any target.
	 */
	public void release(WebDriver driver) {
		actions =new Actions(driver);
		actions.release().perform();
	}

	/**
	 * This method is used to release a particular element 
	 * Inside function, element target is given.
	 */
	public void releaseElementTarget(WebDriver driver,WebElement element) {
		actions=new Actions(driver);
		actions.release(element).perform();
	}

	/**
	 * The tick() methods were introduced in Selenium 3.2 to make selenium compatible with W3C standards. 
	 * These methods are used internally, esp the tick(Interaction), for the other methods in the Actions class. 
	 * The click() also uses this method.
	 * 
	 * tick(Action action) - You can send only one action object here ,  
	 * @param driver
	 */
	public void tick(WebDriver driver,WebElement element) {
		actions=new Actions(driver);
//		actions.tick(null);
	}

	/**
	 * whereas in tick(Interaction...actions) - You can pass array of action objects here.
	 * @param driver
	 */
	public void tickInteractions(WebDriver driver,WebElement element){
		actions=new Actions(driver);
		//actions.tick(element);
	}
	
	/**
	 * "ALERT POPUP"
	 * To handle the alert popup ,we are using alert interface
	 * alert accept
	 */
	public void alertAccept(WebDriver driver) {
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	public void alertDismiss(WebDriver driver) {
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}
	public void alertGetText(WebDriver driver) {
		Alert alert=driver.switchTo().alert();
		alert.getText();
	}
	public void alertSendKeys(WebDriver driver,String message) {
		Alert alert=driver.switchTo().alert();
		alert.sendKeys(message);
	}
	
	
	
	/**
	 * 	Robot Class
	 * This method is used for key Press actions.
	 */
	public void keyPressRobotActions(int keyCode) {
		try {
			robot=new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.keyPress(keyCode);
	
	}
	
	/**
	 * 	Robot Class
	 * This method contains Key Release Actions.
	 */
	public void keyReleaseRobotActions(int keyCode) {
		try {
			robot=new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.keyRelease(keyCode);
	
	}
	
	/**
	 * "SCREENSHOT" actions in selenium webDriver
	 * 
	 */
	
	public void screenShotActions(WebDriver driver, String filePath) {
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File src=takesScreenshot.getScreenshotAs(OutputType.FILE);
		File trg=new File(filePath);
		try {
			FileUtils.copyFile(src, trg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
