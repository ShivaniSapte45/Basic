package Test1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		System.setProperty("driver.chromedriver.webdriver", "C:\\Users\\ADMIN\\eclipse-workspace\\Basic\\Driver\\chromedriver.exe");
	    driver.manage().deleteAllCookies();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	    
	    driver.get("https://demoqa.com/select-menu");
	    
	    WebElement ele=driver.findElement(By.xpath("//*[@id='oldSelectMenu']"));
	    Select option = new Select(ele);
	    System.out.println("First selected option - "+option.getFirstSelectedOption().getText());
	    option.selectByVisibleText("Green");
	    
	    System.out.println("Options are - " );
	    List<WebElement> options = option.getOptions();
	    for(WebElement text:options)
	    {
	    	System.out.println(text.getText());
	    }
	
	    driver.quit();
	    
	
	}

}
