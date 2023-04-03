package Mar25;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AdvanceReports
{
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	@BeforeTest
	public void generateReport()
	{
		report = new ExtentReports("./ExtentReport/Temp.html");
	}
	@BeforeMethod
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https:google.com");
	}
	@Test
	public void testcase1()
	{
		test = report.startTest("PASS Test");
		test.assignAuthor("MANEESH");
		test.assignCategory("Functional");
		String Expected_Title = "Google";
		String Actual_Title = driver.getTitle();
		if(Expected_Title.equalsIgnoreCase(Actual_Title))
		{
			test.log(LogStatus.PASS, "Title is Matching:::"+Expected_Title+"    "+Actual_Title);
		}else
		{
			test.log(LogStatus.FAIL, "Title is Not Matching:::"+Expected_Title+"   "+Actual_Title);
		}
	}
	@Test
	public void testcase2()
	{
		test = report.startTest("FAIL Test");
		test.assignAuthor("MANEESH");
		test.assignCategory("Functional");
		String Expected_Title = "Gmail";
		String Actual_Title = driver.getTitle();
		if(Expected_Title.equalsIgnoreCase(Actual_Title))
		{
			test.log(LogStatus.PASS, "Title is Matching:::"+Expected_Title+"   "+Actual_Title);
		}else
		{
			test.log(LogStatus.FAIL, "Title is Not Matching:::"+Expected_Title+"   "+Actual_Title);
		}
	}
	@AfterMethod
	public void tearDown()
	{
		report.endTest(test);
		report.flush();
		driver.quit();
	}

}
