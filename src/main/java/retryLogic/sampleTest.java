package retryLogic;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class sampleTest {
	
	RemoteWebDriver driver;
	
	@Test(/*dataProvider="sampleData",*/retryAnalyzer=Retry.class)	
	public void test1(/*String name,String company*/){
	/*	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");*/
		System.out.println("TEST 111111111111111111111111111111111");
	//	driver.quit();
		throw new RuntimeException();		
	}
	
	@Test(retryAnalyzer=Retry.class)
	public void test2(){
		System.out.println("TEST 222222222222222222222222222222");
		throw new RuntimeException();	
	}
	
	@DataProvider(name="sampleData")
	public Object[][] getExcelData(){
		return ExcelProvider.getDataFromExcel("test");
		
		
	}

}
