package carsguide;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {
	
		
		public WebDriver driver;
		
		By signin=By.xpath("//a[contains(text(),'sign in')]");
		By emailusername=By.xpath("//input[@name='email']");
		By pwd=By.xpath("//input[@name='password']");
		By submit=By.xpath("//button[@type='submit']");
		By Signup=By.linkText("Sign Up");
		By Firstname=By.xpath("//input[@name='given_name']");
		By Lastname=By.xpath("//input[@name='family_name']");
		By signupsubmitbtn=By.xpath("//span[contains(text(),'Sign Up')]");
		
		
		public Loginpage(WebDriver driver)
		{
			this.driver=driver;
		}

		public WebElement login()
		{
			return driver.findElement(signin);
		}
		public WebElement email()
		{
			return driver.findElement(emailusername);
		}
        public WebElement password()
        {
        	return driver.findElement(pwd);
        }
        public WebElement Submitbutton()
        {
        	return driver.findElement(submit);
        }
        public WebElement signupbutton()
        {
        	return driver.findElement(Signup);
        }
        public WebElement Firstname()
        {
        	return driver.findElement(Firstname);
        }
        public WebElement Lastname()
        {
        	return driver.findElement(Lastname);
        }
        public WebElement signupsubmit()
        {
        	return driver.findElement(signupsubmitbtn);
        }
	}



