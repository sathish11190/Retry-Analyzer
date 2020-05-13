package retryLogic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	private int count = 1;
	private static int maxTry = 3;
	Properties prop = new Properties();
	public String s1;

	public boolean retry(ITestResult result) {
		try {
			prop.load(new FileInputStream(new File("./config.properties")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		s1 = prop.getProperty("TestCasesToBeRerun");
		String s2[] = s1.split("\\|");//split the test method names based on the delimiter 
		List<String> list1 = new ArrayList<String>();
		for (int i = 0; i < s2.length; i++) {
			list1.add(s2[i]);//get the test methods which has to be rerun if failed 
		}

		if (!result.isSuccess()) { // Check if test not succeed
			if (list1.contains(result.getName())) {
				if (count < maxTry) { // Check if maxtry count is reached
					count++; // Increase the maxTry count by 1
					result.setStatus(ITestResult.FAILURE); // Mark test as failed
					System.out.println(result.getMethod());
					System.out.println(result.getName());

					return true; // Tells TestNG to re-run the test
				} else {
					result.setStatus(ITestResult.FAILURE); // If maxCount reached,test marked as failed
				}
			}
		} else {
			result.setStatus(ITestResult.SUCCESS); // If test passes, TestNG marks it as passed
		}

		return false;
	}
}
