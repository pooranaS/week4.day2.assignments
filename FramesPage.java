package week4.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		//switching to frame1
		driver.switchTo().frame("frame1");
		
		driver.findElement(By.tagName("input")).sendKeys("Frames", Keys.ENTER);
		driver.switchTo().frame("frame3");
		driver.findElement(By.id("a")).click();
		driver.switchTo().defaultContent();
		
		// switching to frame2
				driver.switchTo().frame("frame2");

				// accessing Animals dropdown in frame2
				WebElement element = driver.findElement(By.id("animals"));
				Select select = new Select(element);

				// selecting values from dropdown
				select.selectByVisibleText("Baby Cat");
				// switching back to webpage
				driver.switchTo().defaultContent();
	}

}
