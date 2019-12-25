package com.vjj.pages.accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.vjj.base.Page;

public class ImportAccounts extends Page {

	public void goToFromOtherCRM() {
		
		click("ImportAccWhichCRM_XPATH");
		select("ImportAccDropdown_XPATH", "Zoho CRM");
		
	}
	
	public static void main(String[] args) {
		

	}

}
