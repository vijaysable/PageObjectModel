package com.vjj.pages.accounts;

import com.vjj.base.Page;

public class AccountsPage extends Page {
	
	public void goToAllAccounts() {
		
		select("AccountsPageAllAccounts_XPATH", "All Accounts");

	}
	
	public void ImportAccounts() {
		
		select("AccountsPageImportAccount_XPATH", "Import Accounts");
	}
	
	public CreateAccounts goToCreateAccount() {
		
		click("AccountsPageCreateAcc_XPATH");
		return new CreateAccounts();
	}

	public static void main(String[] args) {
		

	}

}
