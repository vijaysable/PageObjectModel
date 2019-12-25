package com.vjj.pages.accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.vjj.base.Page;

public class CreateAccounts extends Page {
	
	public static void Select(WebElement dropdown, String text) {
		
		dropdown.click();
		Select select = new Select(dropdown);
		select.selectByVisibleText(text);
	}
	
	public void goToFields(String accountname, String accountsite, String parentaccount, String accountnumber) {
		
		type("AccountName_XPATH", accountname);
		type("AccountSite_XPATH", accountsite);
		type("ParentAccount_XPATH", parentaccount);;
		//Select(dropdown, "King (Sample)");
		type("AccountNumber_XPATH", accountnumber);
		
		
		
		/*
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); WebElement
		 * dropdown2 = driver.findElement(By.xpath(
		 * "//*[@id=\"Accounts_fldRow_ACCOUNTTYPE\"]/div[2]/div/span/span[1]/span"));
		 * ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+dropdown2.
		 * getLocation().x+")"); dropdown2.click(); Select(dropdown2, "Analyst");
		 * WebElement dropdown3 = driver.findElement(By.
		 * xpath("//div[@id='Accounts_fldRow_INDUSTRY']//span[@class='select2-selection select2-selection--single']"
		 * )); Select(dropdown3, "Technology");
		 * driver.findElement(By.xpath("//input[@id='Crm_Accounts_ANNUALREVENUE']")).
		 * sendKeys("4000"); WebElement dropdown4 = driver.findElement(By.
		 * xpath("//div[@id='Accounts_fldRow_RATING']//span[@class='select2-selection select2-selection--single']"
		 * )); Select(dropdown4, "Active");
		 * driver.findElement(By.xpath("//input[@id='Crm_Accounts_PHONE']")).sendKeys(
		 * "123467890");
		 * driver.findElement(By.xpath("//input[@id='Crm_Accounts_FAX']")).sendKeys(
		 * "123456");
		 * driver.findElement(By.xpath("//input[@id='Crm_Accounts_WEBSITE']")).sendKeys(
		 * "abcd@yzf.com");
		 * driver.findElement(By.xpath("//input[@id='Crm_Accounts_TICKERSYMBOL']")).
		 * sendKeys("$$"); WebElement dropdown5 = driver.findElement(By.
		 * xpath("//div[@class='createSelect newChosenSel selectEmptyVal']//span[@class='select2 select2-container select2-container--default']//span[@class='select2-selection select2-selection--single']"
		 * )); Select(dropdown5, "Partnership"); driver.findElement(By.
		 * xpath("//div[@class='createSelect newChosenSel selectEmptyVal']//span[@class='select2 select2-container select2-container--default']//span[@class='select2-selection select2-selection--single']"
		 * )).sendKeys("Prashant");
		 * driver.findElement(By.xpath("//input[@id='Crm_Accounts_SICCODE']")).sendKeys(
		 * "1234");
		 * 
		 * driver.findElement(By.xpath("//input[@id='Crm_Accounts_BILLINGSTREET']")).
		 * sendKeys("FashionStreet");
		 * driver.findElement(By.xpath("//input[@id='Crm_Accounts_BILLINGCITY']")).
		 * sendKeys("umbai");
		 * driver.findElement(By.xpath("//input[@id='Crm_Accounts_BILLINGSTATE']")).
		 * sendKeys("UP");
		 * driver.findElement(By.xpath("//input[@id='Crm_Accounts_BILLINGCODE']")).
		 * sendKeys("123123");
		 * driver.findElement(By.xpath("//input[@id='Crm_Accounts_BILLINGCOUNTRY']")).
		 * sendKeys("HAlaluya");
		 * 
		 * driver.findElement(By.xpath("//textarea[@id='Crm_Accounts_DESCRIPTION']")).
		 * sendKeys("This is a dummy account");
		 */
	}

	public static void main(String[] args) {
		
	}

}
