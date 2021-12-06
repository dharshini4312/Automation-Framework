package helper;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotHelper {
	
	 WebDriver driver;
	Logger Log = LogManager.getLogger(WaitHelper.class.getName());

	// Click helper constrcutor
	public ScreenshotHelper(WebDriver driver) {
		this.driver = driver;
		
	}
	
	//Taking Screenshot
public  void takeScreenshot(String testName,WebDriver driver) throws IOException {
	
	File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String destinationFilePath = System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
	FileUtils.copyFile(SourceFile,new File(destinationFilePath));

}
public String takeScreenshotForFailureReport(String testName,WebDriver driver) throws IOException {

File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
String destinationFilePath = System.getProperty("user.dir")+"\\screenshots\\fail.png";
FileUtils.copyFile(SourceFile,new File(destinationFilePath));
return destinationFilePath;


}

public static String takeScreenshotForPassedReport(String testName,WebDriver driver) throws IOException {

File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
String destinationFilePath = System.getProperty("user.dir")+"\\screenshots\\pass.png";
FileUtils.copyFile(SourceFile,new File(destinationFilePath));
return destinationFilePath;


}	
}
