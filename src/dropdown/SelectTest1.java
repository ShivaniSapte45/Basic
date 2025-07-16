package dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = null;
		WebElement ele = driver.findElement(By.xpath(""));
		Select country = new Select (ele);
		country.selectByVisibleText(null);
		country.selectByValue(null);
		country.selectByIndex(0);
		country.deselectAll();
		country.deselectByIndex(0);
		country.deselectByValue(null);
		country.deselectByVisibleText(null);
		country.getFirstSelectedOption();
		
		List<WebElement> allOptions= country.getOptions();
		for(WebElement options : allOptions)
		{
			System.out.println(options.getText());
		}
		

	}

}
