	package com.mapsynq.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mapsynq.pages.DirectionsPage;
import com.mapsynq.util.Constants;
import com.mapsynq.util.PropertyLoader;
import com.mapsynq.pages.LivePage;

public class TestMapSynq {

	
	WebDriver driver;
	
	DirectionsPage directionPage;
	LivePage livePage;
	
	@Before
	public void setup(){
		Properties prop = PropertyLoader.loadProperties();
		String browser = prop.getProperty("browser");
		String host = prop.getProperty("host");
		if(browser.equalsIgnoreCase("FIREFOX")){
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("CHROME")){
			driver = new ChromeDriver();
		}
		else{
			System.out.println("Unsupported Web Browser configured");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(host); 
	}
	
	/*@Test
	public void testDirectionsPage() throws InterruptedException{
		Properties prop = PropertyLoader.loadProperties();
		String source=prop.getProperty("srcpath");
		String dest=prop.getProperty("dstpath");
		directionPage = new DirectionsPage(driver);
		directionPage.loadDirectionWebElements();
		directionPage.clickDirectionTab();
		Thread.sleep(1000);
		directionPage.getSource().clear();
		directionPage.getDestination().clear();
		directionPage.getSource().sendKeys(source);
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//div[@class='autocomplete']")).isEnabled())  {
				driver.findElement(By.xpath("//div[@class='autocomplete']/div[2]")).click();
			}
	
		directionPage.getDestination().sendKeys(dest);
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//div[@class='autocomplete'][not(contains(@style,'display: none'))]")).isEnabled()){
			driver.findElement(By.xpath("//div[@class='autocomplete'][not(contains(@style,'display: none'))]/div[2]")).click();
			
		}
		directionPage.clickGetDirection();
		directionPage.clickTrafficRouteRibbon();
		directionPage.printTrafficRoute();
		
	}*/
	
	/*@Test
	public void testLiveTolls() throws InterruptedException{
		Properties prop = PropertyLoader.loadProperties();
		String tollsLoc=prop.getProperty("tollsLoc");
		String vehicleType=prop.getProperty("vehType");
		livePage = new LivePage(driver);
		livePage.loadLiveWebElements();
		livePage.clickLiveTab();
		livePage.clickTollsTab();
		livePage.getTollsLocSearchBox().clear();
		livePage.getTollsLocSearchBox().sendKeys(tollsLoc);
		Thread.sleep(4000);
		if(driver.findElements(By.xpath("//div[@id='singaporeerpWrapper']/div[2]/div[@class='no_result_txtSearchERPsingapore'][not(contains(@style,'display: none'))]")).size()!=0){
			System.out.println("Given Location has no tolls");
		}
		else{
			System.out.println("Given Location has tolls");
			livePage.selectTollLoc();
			if(driver.findElements(By.xpath("//div[@id='ad_toggle'][@class='sprite ad_bar_toggle ad_bar_collapse']")).size()!=0){
				livePage.closeAdToggle();
			}
			
			driver.switchTo().frame("myDropdownList");
			livePage.loadErpRatesFrameElements();
			livePage.selectVehicleTollCharge(vehicleType);
			livePage.printTollCharges();
		}
		
	}
	*/
	@Test
    public void testIncidentByDate() throws InterruptedException{
    	Properties prop = PropertyLoader.loadProperties();
    	String Date = prop.getProperty("incDate");
    	livePage = new LivePage(driver);
		livePage.loadLiveWebElements();
		livePage.clickLiveTab();
		livePage.clickIncidentsBtn();
		livePage.selectDate(Date);
		Thread.sleep(2000);
		livePage.loadLiveIncidentElements();
		livePage.checkIncidents();
        }
	
	@After
	public void teardown(){
		//Properties prop = PropertyLoader.loadProperties();
		//String browser = prop.getProperty("browser");
		//if(browser.equalsIgnoreCase("FIREFOX")){
			//driver = new FirefoxDriver();
		//}
		//else if(browser.equalsIgnoreCase("CHROME")){
			//driver = new ChromeDriver();
		//}
		//else{
			//System.out.println("Unsupported Web Browser configured");
		//}
//	driver.close(); 
	}	


}
