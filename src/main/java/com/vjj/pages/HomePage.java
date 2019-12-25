package com.vjj.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.vjj.base.Page;

public class HomePage extends Page {

	/*
	 * WebDriver driver;
	 * 
	 * // creating constructor of the same class to accept the same driver class //
	 * from LoginTest class i.e the value of chromedriver
	 * 
	 * public HomePage(WebDriver driver) {
	 * 
	 * this.driver = driver; // giving the value of local driver to global Webdriver
	 * driver and is now // initialised with new chromedriver from testlogin class
	 * 
	 * }
	 */

	public void goToFreeSignup() {

		click("FreeSignupButton_XPATH");

	}

	public LoginPage goToLogin() { // this method is responsible for taking us to the login page thats why this
								// method should return the object of login page

		System.out.println("driver=" + driver);
		click("LoginButton_XPATH");
		return new LoginPage();
	}

	public void goToSupport() {

		click("SupportButton_XPATH");
	}

	public void goToCustomers() {

		click("CustomersButton_XPATH");
	}

	public void goToLearnMore() {

		click("LearnMoreButton_XPATH");
	}

	public void validateFooterLinks() {

	}

	public static void main(String[] args) {

	}

}
