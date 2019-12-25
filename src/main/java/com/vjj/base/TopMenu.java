package com.vjj.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vjj.pages.accounts.AccountsPage;

public class TopMenu extends Page {

	/*
	 * TopMenu ISA page????
	 * 
	 * Homepage HASA topmenu
	 * Accountspage HASA topmenu
	 * 
	 * Every Page HASA topmenu
	 * 
	 * how to get driver? topmenu is already encapsulated in page
	 * so we cannot extends page over here coz topmenu is not a page
	 * 
	 * we can use Page.driver.findElement()
	 * or
	 * creating constructor
	 * 
	 */
	
	WebDriver driver;
	
	public TopMenu(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	public void goToHome() {

	}

	public void goToLeads() {

	}

	public void goToContacts() {

	}

	public AccountsPage goToAccounts() {
		
		click("AccountsTab_XPATH");
		//WebDriverWait wait1 = new WebDriverWait(driver, 10);
		//wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("AccountsTab_XPATH")))).click();
		//driver.findElement(By.xpath(OR.getProperty("AccountsTab_XPATH"))).click();
		return new AccountsPage();
	}

	public void goToDeals() {

	}

	public void goToActivities() {

	}

	public void goToReports() {

	}

	public void goToAnalytics() {

	}

	public void goToProjects() {

	}
	
	public void signOut() {
		
		
	}

	public static void main(String[] args) {
		

	}

}
