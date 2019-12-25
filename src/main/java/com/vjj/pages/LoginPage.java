package com.vjj.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.vjj.base.Page;

public class LoginPage extends Page {

	
	public ZohoAppPage doLogin(String username, String password) {
		
		//String username="vj.sableforever05@gmail.com";
		//String password="Realattitude@123";
		type("EmailAddress_XPATH", username);
		click("NextButton_XPATH");
		type("PasswordButton_XPATH", password);
		wait(By.xpath("//form[@id='login']//button[@id='nextbtn']"));
		click("SignInButton_XPATH");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return new ZohoAppPage();
	}
	
	public void backToOldVersion(String username, String password) {
		
		click("BackToOldVersion_XPATH");
		type("OldversionUsername_XPATH", username);
		type("OldversionPassword_XPATH", password);
		click("OldVersionSubmit_XPATH");
	}
	
	public void oneAuth() {
		
		
	}

	public static void main(String[] args) {
		

	}

}
