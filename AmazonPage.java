package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPage {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://amazon.in/");
		// Clicking on search box and sending values and clicking enter
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("one plus 9 pro", Keys.ENTER);

		// getting price of First displayed Product
		String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();

		// printing Price
		System.out.println("The Price of First Product is : " + price);
		// Changing String Price to Integer
		String price1 = price.replaceAll(",", "");
		int price2 = Integer.parseInt(price1);
		System.out.println(price2);

		// Printing the OverAll Rating of First Displayed Product
		System.out.println("The OverAll Rating for First displayed Product is : "
				+ driver.findElement(By.xpath("(//span[@class='a-icon-alt'])[4]")).getText());

		// Printing the No.of.Customer Rating for First Displayed Product
		System.out.println("The No.of.Customer Ratings for First Displayed Product is : "
				+ driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText());

		// Clicking on First link of First displayed image
		driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

		// Assigning new windowsHandles and switching to new window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		String newwindowHandles = list.get(1);
		driver.switchTo().window(newwindowHandles);

		// Taking screenshot of current window
		File file = driver.getScreenshotAs(OutputType.FILE);
		File destImage = new File("./snaps/IMG002.png");
		FileUtils.copyFile(file, destImage);

		// Clicking on Add to Cart button
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(3000);
		String subtotal = driver
				.findElement(
						By.xpath("//span[contains(@class,'a-size-base-plus a-color-price a-text-bold')]/span"))
				.getText();
		
		// Printing SubTotal value
		System.out.println("The SubTotal is : " +subtotal);
		if (price.contains(subtotal)) {
			System.out.println("The Price and SubTotal value in Cart is Equal");

		} else {
			System.out.println("The Price and SubTotal value in Cart is Not Equal");
		}

		 driver.close();

	}

}
