package resources;

import org.openqa.selenium.WebDriver;

public class Page {

protected static WebDriver driver;
	
	public void setWebDriver(WebDriver driver) {
		Page.driver = driver;
	}
}
