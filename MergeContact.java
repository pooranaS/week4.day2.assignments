package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();   
        
      //open a URL
        
        driver.get("http://leaftaps.com/opentaps/control/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize(); 
     
      // Enter UserName and Password Using Id Locator
        
         driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
         driver.findElement(By.id("password")).sendKeys("crmsfa",Keys.ENTER);
         
      //Click on CRM/SFA Link   
         
         driver.findElement(By.linkText("CRM/SFA")).click();
         
      //Click on contacts Button
         
         driver.findElement(By.linkText("Contacts")).click();
         
      //Click on Merge Contacts using Xpath Locator   
         
         driver.findElement(By.linkText("Merge Contacts")).click();
         
      //Click on Widget of From Contact
         
         driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[1]")).click();
         
         //Click on First  Contact
         Set<String> windowHandles = driver.getWindowHandles();
         System.out.println(windowHandles);
         
         List<String> windowHandlesList= new ArrayList<String>(windowHandles);
         
         driver.switchTo().window(windowHandlesList.get(1)); 

         driver.findElement(By.linkText("11323")).click();
         
         driver.switchTo().window(windowHandlesList.get(0));
         
      // Click on Widget of To Contact  
         
         driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
         
         Set<String> windowHandles1 = driver.getWindowHandles();
         System.out.println(windowHandles1);
         
         List<String> windowHandlesList1= new ArrayList<String>(windowHandles1);
         
         driver.switchTo().window(windowHandlesList1.get(1)); 
         
         Thread.sleep(2000);

         driver.findElement(By.linkText("11324")).click();
         
         Thread.sleep(2000);
         
         driver.switchTo().window(windowHandlesList1.get(0)); 

      //Click on Merge button using Xpath Locator
         
         driver.findElement(By.linkText("Merge")).click();
         //Accept the Alert   
         
         Alert alert = driver.switchTo().alert();
         
         alert.accept();
         
       //Verify the title of the page  
         
         System.out.println(driver.getTitle());
         

	}

}
