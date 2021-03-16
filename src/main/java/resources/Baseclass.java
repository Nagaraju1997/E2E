package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	
	
		public WebDriver driver;
		public Properties prop;

		public WebDriver Initilization() throws IOException, InterruptedException 
		{
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Data.properties");
			prop.load(fis);
			if (prop.getProperty("browser").equals("firefox")) {
				//System.setProperty("webdriver.gecko.driver", "C:\\Users\\KING\\geckodriver-v0.26.0-win32\\geckodriver.exe");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} 
			else
			{
				//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
				//System.setProperty("webdriver.chrome.driver", "C:\\Users\\KING\\chromedriver_win32\\Chromedriver.exe");
				WebDriverManager.chromedriver().setup();
				ChromeOptions option=new ChromeOptions();
				if(prop.getProperty("browser").contains("Headless"))
				{
					option.addArguments("Headless");
				}
				driver = new ChromeDriver(option);
				//WebDriverManager.chromedriver().setup();
			}
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.get(prop.getProperty("url"));
			return driver;
            
		}
		public String getScreenShotPath(String testcasename, WebDriver driver) throws IOException
		{
		    TakesScreenshot ts=(TakesScreenshot) driver;
			File source =ts.getScreenshotAs(OutputType.FILE);
			String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
			FileUtils.copyFile(source,new File(destinationFile));
			return destinationFile;
			/*TakesScreenshot ts=(TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("C:\\Users\\KING\\eclipse-workspace\\Maven\\Screenshots\\"+""+testCaseName+".png"));*/
		}

			
		
         /*public static void capturescreenshot(WebDriver driver, String ScreenshotName)
		{
		C:/Users/KING/eclipse-workspace/E2EProject/Screenshots/fail.jpg
			try {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("C:\\Users\\KING\\eclipse-workspace\\E2EProject\\Screenshots\\"+""+ScreenshotName+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		
}

