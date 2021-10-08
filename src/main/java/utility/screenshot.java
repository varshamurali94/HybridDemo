package utility;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenshot {
	public static int count = 0;
	public static void captureScreenShot(WebDriver driver) throws Exception
	{
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // store file to temprary location
		//Now you can do whatever you need to do with it, for example copy somewhere download org.apache.commons.io.FileUtils class API set classpath and use this class to copy.
		String screenshotpath = System.getProperty("user.dir")+"\\src\\test\\java\\screenshot\\errorimage"+count+++".jpeg";
		
		FileUtils.copyFile(scrFile, new File(screenshotpath));

		/*
		byte scrFile[] = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES); // store file as byte
		String screenshotpath = System.getProperty("user.dir")+"\\src\\test\\java\\screenshot\\errorimage.jpeg";
		
		FileOutputStream fos=new FileOutputStream(screenshotpath);  // create file blank image 0 byte
		fos.write(scrFile);
		fos.close();
		*/
	}

}
