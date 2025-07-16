package table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class FindValue {
	
	//https://www.google.com/search?q=how+to+find+value+from+table+in+selenium&rlz=1C1CHBD_enIN1027IN1027&source=lnms&tbm=vid&sa=X&ved=2ahUKEwicrvv0_tz-AhVpi2MGHaYuB7MQ_AUoAXoECAIQAw&biw=1366&bih=657&dpr=1#fpstate=ive&vld=cid:13219a2d,vid:aVHUP_V-nNI
	@Test
	public void checkValue()
	{
		System.setProperty("driver.chromedriver.webdriver", "C:\\Users\\ADMIN\\eclipse-workspace\\Basic\\Driver\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		int rows = driver.findElements(By.xpath("//table[@id='customers']//tbody//tr")).size();
		int col = driver.findElements(By.xpath("//table[@id='customers']//tbody//th")).size();
		
		for(int i=1; i<rows; i++)
		{
			for(int j=1; j<=col; j++) {
				
				String actual = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+(i+1)+"]/td["+j+"]")).getText();
				
				if(actual.equals("Mexico"))
				{
					System.out.println(i+" : "+j);
					break;
				}
			
			}
		}
	}

}
