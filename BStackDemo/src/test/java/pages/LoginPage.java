package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.DriverFactory;

public class LoginPage 
{
	WebDriver driver = DriverFactory.getDriver();
	By username = By.id("username");
	By password = By.id("password");
	By loginBtn = By.id("login-btn");
	
	public void openLoginPage()
	{
		driver.get("https://bstackdemo.com/signin");
	}
	
	public void login(String user, String pass)
	{
		driver.findElement(username).click();
		driver.findElement(By.xpath("//div[text()='"+user+"']")).click();
		driver.findElement(password).click();
		driver.findElement(By.xpath("//div[text()='"+pass+"']")).click();
		driver.findElement(loginBtn).click();
	}
}
