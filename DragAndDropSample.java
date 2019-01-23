package automationFramework;

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.WebElement;		
import org.openqa.selenium.chrome.ChromeDriver;		
import org.openqa.selenium.interactions.Actions;		

	

public class DragAndDropSample {				
	
	public static void main (String args[]) {
	String exePath = "C:\\Shankari\\JavaWorkspace\\chromedriver.exe";
	
	System.setProperty("webdriver.chrome.driver", exePath);
	
	WebDriver driver = new ChromeDriver();
 		
 		driver.get("http://demo.guru99.com/test/drag_drop.html");	
 		driver.manage().window().maximize();
         
		//Element which needs to drag.    		
        	WebElement From=driver.findElement(By.xpath("//*[@id='credit1']/a"));	
        	 WebElement amtRs = driver.findElement(By.xpath("//*[@id='fourth']/a"));
        	
     
         //Element on which need to drop.	
         WebElement To=driver.findElement(By.xpath("//*[@id='bank']/li"));		
         WebElement amt = driver.findElement(By.xpath("//*[@id='amt8']/li"));	
         WebElement Sel_link = driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul/li[1]/a"));	
       
         //Using Action class for drag and drop.		
         Actions act=new Actions(driver);	
         Actions builder = new Actions(driver);

	//Dragged and dropped.		
        // act.dragAndDrop(source,target).build().perform();	
         act.dragAndDrop(From, To).build().perform();	
         act.dragAndDrop(amtRs, amt).build().perform();
        //MoveToElement Moves the mouse to the middle of the element.
         builder.moveToElement(Sel_link)
                 .build();
         builder.perform();
       
	
}
}