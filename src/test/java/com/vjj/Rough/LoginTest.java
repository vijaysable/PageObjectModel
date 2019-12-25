package com.vjj.Rough;

import com.vjj.base.Page;
import com.vjj.pages.HomePage;
import com.vjj.pages.LoginPage;
import com.vjj.pages.ZohoAppPage;
import com.vjj.pages.accounts.AccountsPage;
import com.vjj.pages.accounts.CreateAccounts;
import com.vjj.pages.crm.CRMHomepage;

public class LoginTest {

	public static void main(String[] args) {

		/*
		 * we are calling straight fwd objects below
		 * we should nt do like this, this is where page object model comes in
		 * driver.manage.window.maximize(); // this whole statement is design pattern
		 * these are three different methods coming from different classes
		 * we are not creating straight fwd objects here, we are getting it from their classes
		 * the object of these classes is returned from the method itself
		 * 
		 * page object model says that whichever method is responsible for taking you to the next page
		 * should actually return the object of that page
		 * 
		 * 
		 */
		
		HomePage home = new HomePage();
		LoginPage lp = home.goToLogin();
		// LoginPage login = new LoginPage();
		ZohoAppPage zoho = lp.doLogin(null, null);
		//ZohoAppPage zoho = new ZohoAppPage();
		CRMHomepage cp = zoho.goToCRM();
		//CRMHomepage crm = new CRMHomepage();
		cp.VerifyHomepage();
		
		AccountsPage account = Page.menu.goToAccounts();
		CreateAccounts acc = account.goToCreateAccount();
		acc.goToFields(null, null, null, null);
	}

}
