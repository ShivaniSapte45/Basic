package test123;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\eclipse-workspace\\Basic\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.in/");
		Thread.sleep(2000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("test");
		
		File src = new File("");
		FileInputStream fis = new FileInputStream(src);
//		xssfworkbook wb = new xssfworkbook(fis);
//		XssfSheet sh = wb.getSheetAt(1);
//		int rowcount = sh.getlastRowNum();
//		
//		for(int i = 0; i<rowcount; i++)
//		{
//			String data = sh.getRow(1).getCell(0).getStringCellValue();
//			driver.findElement(By.id("twotabsearchtextbox")).sendKeys(data);
//
	}

}
