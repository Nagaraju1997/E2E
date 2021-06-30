package carsguide;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import resources.Baseclass;
import resources.ExtentReport;
import utility.ExcelUtils;
import utility.dataDriven;

public class Homepage extends Baseclass {


	public WebDriver driver;
	//private String sTestCaseName;
	
	//private int iTestCaseRow;
	
	
	//ExtentTest test;
	//ExtentReports extent=ExtentReport.getReportObject();
	/*String path = System.getProperty("user.dir")+"\\Extentreport\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);*/
	//ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	@BeforeMethod()
	public void setup() throws IOException, InterruptedException {
		//ExtentReport.getReportObject();
		//extent=ExtentReport.getReportObject();
		//extent.attachReporter(reporter);
		driver = Initilization();
		
	}


	 @Test
	 public void login() throws Exception {
		
	 ArrayList<String> data=dataDriven.getData("login");
	// test=extent.createTest("login");
	 //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
	 Landingpage l = new Landingpage(); 
	 //test.log(Status.INFO, "Landed on landing page");
	 l.getlogin().click(); 
	 Loginpage lg=new Loginpage(); 
	 lg.login().click();
	 //test.log(Status.INFO, "Landed on login page");
	 //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 //lg.email().sendKeys(sUsername); 
	 lg.email().sendKeys(data.get(1));
	 //test.log(Status.INFO, "email entered");
	 //lg.password().sendKeys(spassword);
	 lg.password().sendKeys(data.get(2));
	 //test.log(Status.INFO, "password entered");
	 lg.Submitbutton().click();
	  }
	 
    @Test
	public void logout() throws IOException {
		ArrayList<String> data=dataDriven.getData("logout");
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  // test=extent.createTest("logout");
		//System.out.println(test);
		Landingpage l = new Landingpage();
		//test.log(Status.INFO, "Landed on landing page");
		l.getlogin().click();
		Loginpage lg = new Loginpage();
		//test.log(Status.INFO, "Landed on login page");
	    //lg.signupbutton();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		lg.email().sendKeys(data.get(1));
		//test.log(Status.INFO, "email entered");
		lg.password().sendKeys(data.get(2));
		//test.log(Status.INFO, "password entered");
		lg.Firstname().sendKeys(data.get(3));
		//test.log(Status.INFO, "firstname entered");
		lg.Lastname().sendKeys(data.get(4));
		//test.log(Status.INFO, "lastname entered");
		lg.signupsubmit();
		

	}
	


	@AfterMethod()
	public void Teardown() {
		/*
		 * if(ITestResult.FAILURE==result.getStatus()) {
		 * Baseclass.capturescreenshot(driver, result.getName()); }
		 */
		//extent.attachReporter(reporter);
	   // extent.flush();
		driver.quit();
	}
	/*@DataProvider(name="getdata")
	 
	  public Object[] Authentication() throws Exception{
	 
	     // Setting up the Test Data Excel file
	 
	 ExcelUtils.setExcelFile(System.getProperty("user.dir")+"\\src\\main\\java\\utility\\TestData.xlsx","Data");
	 
	 sTestCaseName = this.toString();
	 
	    // From above method we get long test case name including package and class name etc.
	 
	    // The below method will refine your test case name, exactly the name use have used
	 
	    sTestCaseName = ExcelUtils.getTestCaseName(this.toString());
	 
	     // Fetching the Test Case row number from the Test Data Sheet
	 
	     // Getting the Test Case name to get the TestCase row from the Test Data Excel sheet
	 
	 iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);
	 
	     Object[][] testObjArray = ExcelUtils.getTableArray(System.getProperty("user.dir")+"\\src\\main\\java\\utility\\TestData.xlsx","Data",iTestCaseRow);
	 
	      return (testObjArray);
	 
	}*/
 
	/*@DataProvider
		public static ArrayList<String> getData(String testcaseName) throws IOException
		{
		//fileInputStream argument
		ArrayList<String> a=new ArrayList<String>();

		FileInputStream fis=new FileInputStream("C:\\Users\\KING\\eclipse-workspace\\E2EProject\\src\\main\\java\\utility\\TestData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);

		int sheets=workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
		if(workbook.getSheetName(i).equalsIgnoreCase("Data"))
		{
		XSSFSheet sheet=workbook.getSheetAt(i);
		//Identify Testcases coloum by scanning the entire 1st row

		Iterator<Row>  rows= sheet.iterator();// sheet is collection of rows
		Row firstrow= rows.next();
		Iterator<Cell> ce=firstrow.cellIterator();//row is collection of cells
		int k=0;
		int coloumn = 0;
		while(ce.hasNext())
		{
		Cell value=ce.next();

		if(value.getStringCellValue().equalsIgnoreCase("Test Case"))
		{
		coloumn=k;

		}

		k++;
		}
		System.out.println(coloumn);

		////once coloumn is identified then scan entire testcase coloum to identify purcjhase testcase row
		while(rows.hasNext())
		{

		Row r=rows.next();

		if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcaseName))
		{

		////after you grab purchase testcase row = pull all the data of that row and feed into test

		Iterator<Cell>  cv=r.cellIterator();
		while(cv.hasNext())
		{
		Cell c= cv.next();
		if(c.getCellTypeEnum()==CellType.STRING)
		{

		a.add(c.getStringCellValue());
		}
		else{

		a.add(NumberToTextConverter.toText(c.getNumericCellValue()));

		}
		}
		}

		}
		}
		}
		return a;
		}*/
		

	}
	

