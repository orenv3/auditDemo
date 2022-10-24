package com.audit.printscreen;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.audit.entities.PullRequestWarraper;

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
	
	private static WebDriver driver;
	private final String BASE_DIRECTOEY_PATH = "C:\\pullRequest_screenshots"; 
	private StringBuilder strBuilder;
	private String url;
	
	public PrintScreen(PullRequestWarraper prWarraer) {
		File directory = new File(BASE_DIRECTOEY_PATH);
		if (!(directory.exists())) {
			directory.mkdir();
		}
		this.setName("thread_of_screenshots");
		this.url = prWarraer.getPull_request().getHtml_url();
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("dd-MM-yy");
		
		strBuilder = new StringBuilder();
		strBuilder.append(sdf.format(prWarraer.getPull_request().getCreated_at()));
		strBuilder.append("_");
		strBuilder.append(prWarraer.getPull_request().getUserName());
		strBuilder.append("_");
		strBuilder.append(prWarraer.getAction());
		strBuilder.append("_");
		strBuilder.append(prWarraer.getPull_request().getId());
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
		log.info(this.getName()+" is done with "+strBuilder.toString()+".png");
		
	}
	
	
}
