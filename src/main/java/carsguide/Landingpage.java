package carsguide;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage {
	
	public WebDriver driver;
	
	By signin=By.xpath("//span[text()='Sign up / Sign in']");
	//By signin=By.xpath("//*[@id='u_H-white']/div/div[2]/div[1]/ul/li[3]/a/span[1]");
	
	public Landingpage(WebDriver driver)
	{
		this.driver=driver;
	}

	public WebElement getlogin()
	{
		return driver.findElement(signin);
	}

}
