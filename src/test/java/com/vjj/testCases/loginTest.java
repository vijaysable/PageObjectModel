package com.vjj.testCases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vj.Utilities.TestUtil;
import com.vjj.pages.HomePage;
import com.vjj.pages.LoginPage;

public class loginTest extends BaseTest {
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void LoginTest(Hashtable<String,String> table) {
		
		HomePage home = new HomePage();
		LoginPage lp = home.goToLogin();
		// LoginPage login = new LoginPage();
		lp.doLogin(table.get("username"), table.get("password"));
		//Assert.fail("Login test failing to check screenshot");
	}

	public static void main(String[] args) {
		

	}

}
