package Test1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		System.setProperty("driver.chromedriver.webdriver", "C:\\Users\\ADMIN\\eclipse-workspace\\Basic\\Driver\\chromedriver.exe");
	    driver.manage().deleteAllCookies();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	    
	    driver.get("https://demoqa.com/menu/");
	    
	    Actions act=new Actions(driver);
	    WebElement main2 = driver.findElement(By.linkText("Main Item 2"));
	    act.moveToElement(main2).build().perform();
	    
	    WebElement subItemList = driver.findElement(By.linkText("SUB SUB LIST »"));
	    act.moveToElement(subItemList).build().perform();
	    
	    WebElement sub1 = driver.findElement(By.linkText("Sub Sub Item 1"));
	    act.moveToElement(sub1).build().perform();
	    try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    act.click();

	}

}
