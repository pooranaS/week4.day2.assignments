package week4.day2.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Dropdown.html");

		// Finding first dropdown and assigning to webelement and selecting values by
		// index

		WebElement dd1 = driver.findElement(By.id("dropdown1"));
		Select select = new Select(dd1);
		select.selectByIndex(2);

		// Finding second dropdown and assigning to webelement and selecting values by
		// text

		WebElement dd2 = driver.findElement(By.name("dropdown2"));
		Select select1 = new Select(dd2);
		select1.selectByVisibleText("Selenium");

		// Finding third dropdown and assigning to webelement and selecting values by
		// value
		WebElement dd3 = driver.findElement(By.id("dropdown3"));
		Select select2 = new Select(dd3);
		select2.selectByValue("1");

		// Finding fourth dropdown and assigning to webelement and finding no.of options
		// available
		WebElement dd4 = driver.findElement(By.className("dropdown"));
		Select select3 = new Select(dd4);
		List<WebElement> options = select3.getOptions();
		System.out.println("The No.of.Options available under dropdown is : " + options.size());

		// Finding fifth dropdown and sending values
		driver.findElement(By.xpath("(//select)[5]")).sendKeys("UFT/QTP", Keys.ENTER);

		// Finding sixth dropdown and assigning to webelement and selecting multiple
		// values
		WebElement dd5 = driver.findElement(By.xpath("(//select)[6]"));
		Select select4 = new Select(dd5);
		select4.selectByValue("4");
		select4.selectByIndex(1);
	}

}
