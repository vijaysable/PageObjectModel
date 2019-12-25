package com.vjj.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.vjj.base.Page;

public class CaptureScreenshot extends Page {
		
	public void capscreen() throws IOException {

		Date d = new Date();
		String filename = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		
		File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot1, new File("C:\\Users\\Hole\\Desktop\\Vijay\\Eclipse\\PageObjectModelBasics\\src\\test\\resources\\com\\vjj\\Screenshots\\"+filename));
		
		String path = new File("C:\\Users\\Hole\\Desktop\\Vijay\\Eclipse\\PageObjectModelBasics\\src\\test\\resources\\com\\vjj\\Screenshots\\"+filename).getAbsolutePath();
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		org.testng.Reporter.log("<a target=\"_blank\" href="+path+">screenshot</a>");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
