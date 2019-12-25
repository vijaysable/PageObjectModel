package com.vjj.testCases;

import org.testng.annotations.AfterSuite;

import com.vjj.base.Page;

public class BaseTest {

	@AfterSuite
	public void tearDown() {
		
		Page.quit();
	}
	
	public static void main(String[] args) {
		

	}

}
