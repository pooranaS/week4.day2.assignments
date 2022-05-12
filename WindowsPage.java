package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsPage {

	public static void main(String[] args) throws InterruptedException {

		// Open a Browser

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// open a URL

		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().window().maximize();

		// Click button to open home page in New Window

		driver.findElement(By.id("home")).click();

		Set<String> windowHandles = driver.getWindowHandles();

		List<String> windowHandleslist = new ArrayList<String>(windowHandles);

		driver.switchTo().window(windowHandleslist.get(1));
		driver.manage().window().maximize();
		Thread.sleep(2000);

		driver.close();

		Thread.sleep(2000);

		// Find the number of opened windows
		driver.switchTo().window(windowHandleslist.get(0));
		driver.findElement(By.xpath("//button[contains(text(),'Open Multiple Windows')]")).click();

		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> windowhandlesList = new ArrayList<String>(windowHandles2);

		int size = windowhandlesList.size();

		System.out.println("The number of opened windows " + size);

		String string2 = windowhandlesList.get(1);
		driver.switchTo().window(windowhandlesList.get(1));
		driver.manage().window().maximize();
		System.out.println(string2);

		driver.close();

		String string3 = windowhandlesList.get(2);
		System.out.println(string3);
		driver.switchTo().window(windowhandlesList.get(2));
		driver.manage().window().maximize();
		driver.close();

		// Close all except this window
		driver.switchTo().window(windowHandleslist.get(0));
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();

		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> windowHandles3list = new ArrayList<String>(windowHandles3);
		String string4 = windowHandles3list.get(1);
		System.out.println(string4);

		driver.switchTo().window(windowHandles3list.get(1));
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.close();

		String string5 = windowHandles3list.get(2);
		System.out.println(string5);
		driver.switchTo().window(windowHandles3list.get(2));
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.close();

		driver.switchTo().window(windowHandles3list.get(0));

		// Wait for 2 new Windows to open

		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();

		Thread.sleep(8000);

		Set<String> windowHandles4 = driver.getWindowHandles();

		List<String> windowHandles4list = new ArrayList<String>(windowHandles4);

		String string6 = windowHandles4list.get(1);

		System.out.println(string6);

		driver.switchTo().window(windowHandles4list.get(1));

		driver.manage().window().maximize();

		Thread.sleep(2000);

		driver.close();

		String string7 = windowHandles4list.get(2);

		System.out.println(string7);

		driver.switchTo().window(windowHandles4list.get(2));

		driver.manage().window().maximize();

		Thread.sleep(2000);

		driver.close();

	}

}
