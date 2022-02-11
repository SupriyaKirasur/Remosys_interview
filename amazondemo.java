import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class amazondemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://amazon.in");
		//driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		//driver.findElement(By.name("email")).sendKeys("ktriya21@gmail.com");
		//driver.findElement(By.id("continue")).click();
		
		
		Select cat = new Select(driver.findElement(By.id("searchDropdownBox")));
		cat.selectByVisibleText("Baby");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("gifts for baby");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/span[3]/div[2]/div[6]/div/div/div/div/div[2]/div[1]/h2/a")).click();
		Thread.sleep(5000);
		
		Set<String> allwindows = driver.getWindowHandles();
		Object[] windows = allwindows.toArray();
		String window1 = windows[0].toString();
		String window2 = windows[1].toString();
		
		
		driver.switchTo().window(window2);
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("add-to-cart-button")).click();
		
		Thread.sleep(10000);
		
		//go to cart
		driver.findElement(By.xpath("//*[@href='/gp/cart/view.html?ref_=sw_gtc']")).click();
		
		Thread.sleep(10000);
		//delete
		driver.findElement(By.cssSelector("input[value='Delete']")).click();
		
		Thread.sleep(5000);
		
		driver.switchTo().window(window1);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/span[3]/div[2]/div[6]/div/div/div/div/div[2]/div[1]/h2/a")).click();
		Thread.sleep(10000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//tagname[@title='Add gift options']")));
		
		Thread.sleep(10000);
		
		
		
		
		
		
		
		
	}

}
