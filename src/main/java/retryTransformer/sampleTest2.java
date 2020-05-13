package retryTransformer;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class sampleTest2 {
	
	RemoteWebDriver driver;
	
	@Test(dataProvider="sampleData")	
	public void test1234(String name,String company){
		/*System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.sc.com/in/");
		
		driver.quit();*/
		System.out.println(name +company);
		System.out.println("HIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
		throw new RuntimeException();		
	}
	
	@DataProvider(name="sampleData")
	public Object[][] getExcelData(){
		return retryLogic.ExcelProvider.getDataFromExcel("test");
		
		
	}

}
