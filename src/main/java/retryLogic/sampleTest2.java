package retryLogic;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class sampleTest2 {
	int count = 0;

	@Test(dataProvider = "sampleData", retryAnalyzer = Retry.class)
	public void test(String name, String company) {
		System.out.println(name+"\n"+company);
		throw new RuntimeException();
	}

	@DataProvider(name = "sampleData")
	public Object[][] getExcelData() {
		count++;
		System.out.println("COUNT" + count);
		if (count == 1)
			return ExcelProvider.getDataFromExcel("test");
		else if(count==2)
			return ExcelProvider.getDataFromExcel("test1");
		else
			return ExcelProvider.getDataFromExcel("test2");
		

	}

}
