package carsguide;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
//import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.Baseclass;
import utility.dataDriven;

public class Homepage extends Baseclass {
	
	dataDriven dt=new dataDriven();
	public WebDriver driver;

	@BeforeMethod()
	public void setup() throws IOException, InterruptedException 
	{
		driver=Initilization();
		
	}
	@Test
	public void login() throws Exception 
	{
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Landingpage l = new Landingpage(driver);
		l.getlogin().click();
		Loginpage lg=new Loginpage(driver);
		lg.login().click();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		lg.email().sendKeys("test@yopmail.com");
		lg.password().sendKeys("Test@1234");
		lg.Submitbutton().click();
				
	}
	@Test
	public void logout()
	{
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Landingpage l = new Landingpage(driver);
		l.getlogin().click();
		Loginpage lg=new Loginpage(driver);
		//lg.signupbutton();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		lg.email().sendKeys("test@yopmail.com");
		lg.password().sendKeys("Test@1234");
		lg.Firstname().sendKeys("test");
		lg.Lastname().sendKeys("yop");
		lg.signupsubmit();
		
	}

	@AfterMethod()
	public void Teardown()
	{
		/*if(ITestResult.FAILURE==result.getStatus())
		{
			Baseclass.capturescreenshot(driver, result.getName());
		}*/
		driver.quit();
	}
	

   
}
