package com.vjj.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.vjj.base.Page;
import com.vjj.pages.crm.CRMHomepage;

public class ZohoAppPage extends Page {
	
	public CRMHomepage goToCRM() {
		
		click("CRMbutton_XPATH");
		return new CRMHomepage();
	}
	
	public void goToMail() {
		
		click("MailButton_XPATH");
		
	}
	
	public void goToCampaigns() {
		
		click("CampaignsButton_XPATH");
	}
	
	
	public static void main(String[] args) {
		

	}

}
