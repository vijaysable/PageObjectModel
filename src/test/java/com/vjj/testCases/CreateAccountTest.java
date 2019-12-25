package com.vjj.testCases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.vj.Utilities.TestUtil;
import com.vjj.base.Page;
import com.vjj.pages.ZohoAppPage;
import com.vjj.pages.accounts.AccountsPage;
import com.vjj.pages.accounts.CreateAccounts;
import com.vjj.pages.crm.CRMHomepage;

public class CreateAccountTest {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void createAccountTest(Hashtable<String,String> table) {
		
		ZohoAppPage zoho = new ZohoAppPage();
		zoho.goToCRM();
		//CRMHomepage cp = zoho.goToCRM();
		//CRMHomepage crm = new CRMHomepage();
		//cp.VerifyHomepage();
	
		AccountsPage account = Page.menu.goToAccounts();
		CreateAccounts acc = account.goToCreateAccount();
		acc.goToFields(table.get("Account Name"), table.get("Account Site"), table.get("Parent Account"), table.get("Account Number"));
		
	}
	
	public static void main(String[] args) {
		

	}

}
