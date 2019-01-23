package automationFramework;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;

public class findNABBranch{

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String exePath = "C:\\Shankari\\JavaWorkspace\\chromedriver.exe";
		System.out.println("Chrome ..."+exePath);
		System.setProperty("webdriver.chrome.driver", exePath);
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://nab.com.au");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.findElement(By.partialLinkText("Find a branch")).click();
		driver.findElement(By.id("address")).sendKeys("Glen Waverley VIC 3150, Australia");
		driver.findElement(By.id("search")).click();
		
	//To scroll down the page until the element is visible
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//*[@id=\'criteriaBc0\']"));
	    js.executeScript("arguments[0].scrollIntoView(true);", Element);
	    
		String s = driver.findElement(By.partialLinkText("Glen Waverley - SmartATM")).getTagName();
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='resultColumn']/div[1]/div[2]/h3/a")));
		
		driver.findElement(By.partialLinkText("Glen Waverley - SmartATM")).click();
		
		
		 File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
   	     ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -250)", "");	
	
	    DateFormat dateFormat = new SimpleDateFormat("MMddyyyyHHmmss");
	    Date date = new Date();
	    String date1= dateFormat.format(date);

	     //The below method will save the screen shot in c drive with name "screenshot.png"
	      try {
	     	
	            FileUtils.copyFile(scrFile, new File("C:\\Shankari\\JavaWorkspace\\ScreenShot\\screenshot_"+date1+"NAB"+".png"));
	       } catch (IOException e) {
	            // TODO Auto-generated catch block
	            System.out.println("Exception in capturing screenshot ....."+e);
	        }
	   
	        
	      	WebElement brancheschk = driver.findElement(By.name("criteriaBranch0"));
	      
	      	boolean deChk = driver.findElement(By.name("criteriaBranch0")).isSelected();
	      	if(deChk==true) {
		      	brancheschk.click();
		      	try {
		       	File scrFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		      
			        	FileUtils.copyFile(scrFile1, new File("C:\\Shankari\\JavaWorkspace\\ScreenShot\\screenshot_"+date1+"NABATM"+".png"));
			       } catch (IOException e) {
			            // TODO Auto-generated catch block
			            System.out.println("Exception in capturing screenshot ....."+e);
			        }
	      	}
}
}
