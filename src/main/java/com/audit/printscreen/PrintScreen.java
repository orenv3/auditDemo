package com.audit.printscreen;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.audit.entities.Picture;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class PrintScreen extends Thread{

	static WebDriver driver;
	String BASE_DIRECTOEY_PATH;  
	StringBuilder strBuilder;
	String url;
	Picture picture;
	
	void createFilePath(String path) {
		File directory = new File(path);
		if (!(directory.exists())) {
			directory.mkdir();
		}
	}
	
	void setNameFormat(Date date, String dateFormat, String part1, String part2, String part3) {
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(dateFormat);

		strBuilder = new StringBuilder();
		strBuilder.append(sdf.format(date));
		strBuilder.append("_");
		strBuilder.append(part1);
		strBuilder.append("_");
		strBuilder.append(part2);
		strBuilder.append("_");
		strBuilder.append(part3);
	}

	void savePrintScreenInDb() {
		
	}
	
	
	@Override
	public void run() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		driver=new ChromeDriver(options);
		driver.get(this.url);
		;
		log.debug(this.getName()+" executed and the url is: "+ this.url);
		final File scrSh = new File(BASE_DIRECTOEY_PATH+"\\"+strBuilder.toString()+".png");
		log.debug(this.getName()+" created file name: "+ strBuilder.toString()+".png");
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, scrSh);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.quit();
		log.info(this.currentThread().getName()+" is done with "+strBuilder.toString()+".png");

	}


}
