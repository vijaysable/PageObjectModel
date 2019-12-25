package com.vjj.pages.crm;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.vjj.base.Page;

public class CRMHomepage extends Page {

	public void VerifyHomepage() {
		
		String Homepagetext = driver.findElement(By.xpath("//td[@class='f15 pL30']")).getText();
		Assert.assertEquals(Homepagetext, "Welcome vj.sableforever05");
	}
	
	public static void main(String[] args) {
		
		

	}

}
