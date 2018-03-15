package com.mapsynq.test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.mapsynq.pages.DirectionsPage;
import com.mapsynq.pages.LivePage;
import com.mapsynq.pages.MapDashboardCage;
import com.mapsynq.util.PropertyLoader;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMapSynq {

	WebDriver driver;
	DirectionsPage directionPage;
	LivePage livePage;
	MapDashboardCage dashboardPage;
	Properties prop;
	/**
	 * This method sets up the environment like loading the property file 
	 * and which driver to be loaded and opens the respective browser
	 * @throws InterruptedException 
	 */
	@Before
	public void setup() throws InterruptedException{
		prop = PropertyLoader.loadProperties();
		String browser = prop.getProperty("browser");
		String host = prop.getProperty("host");
		
		if(browser.equalsIgnoreCase("FIREFOX")){
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("CHROME")){
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("IE")){
			driver = new InternetExplorerDriver();
		}
		else{
			System.out.println("Unsupported Web Browser configured");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(host); 
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//a[@class='header_logo sprite']")).isDisplayed()){
			System.out.println("mapSYNQ page loaded succesfully");
			
		}
	}


	/**
	 * This method gets the direction for the given source/destination location
	 * @throws InterruptedException
	 */
	@Test
	public void testADirectionsPage() throws InterruptedException{
		String source=prop.getProperty("srcpath");
		String dest=prop.getProperty("dstpath");
		directionPage = new DirectionsPage(driver, prop);
		Assert.assertTrue(directionPage.loadDirectionWebElements());
		Assert.assertTrue(directionPage.clickDirectionTab());
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
		Assert.assertTrue(directionPage.clickGetDirection());
		Assert.assertTrue(directionPage.clickTrafficRouteRibbon());
		Assert.assertTrue(directionPage.printTrafficRoute());

	}
	/**
	 * This method prints toll charges for a given vehicle type if toll exist in the given location
	 */

 
	@Test
	public void testBLiveTolls() throws InterruptedException{
		String tollsLoc=prop.getProperty("tollsLoc");
		String vehicleType=prop.getProperty("vehType");
		livePage = new LivePage(driver, prop);
		Assert.assertTrue(livePage.loadLiveWebElements());
		Assert.assertTrue(livePage.clickLiveTab());
		Assert.assertTrue(livePage.clickTollsTab());
		livePage.getTollsLocSearchBox().clear();
		livePage.getTollsLocSearchBox().sendKeys(tollsLoc);
		Thread.sleep(4000);
		if(driver.findElements(By.xpath("//div[@id='singaporeerpWrapper']/div[2]/div[@class='no_result_txtSearchERPsingapore'][not(contains(@style,'display: none'))]")).size()!=0){
			System.out.println("Given Location has no tolls");
		}
		else{
			System.out.println("Given Location has tolls");
			Assert.assertTrue(livePage.selectTollLoc());
			if(driver.findElements(By.xpath("//div[@id='ad_toggle'][@class='sprite ad_bar_toggle ad_bar_collapse']")).size()!=0){
				livePage.closeAdToggle();
			}

			//driver.switchTo().frame("myDropdownList");
			Assert.assertTrue(livePage.selectVehicleTollCharge(vehicleType));
			Assert.assertTrue(livePage.printTollCharges());
		}

	}
	/**
	 * This method gets and prints the incidents for the given date.
	 */
	@Test
	public void testCIncidentByDate() throws InterruptedException{
		String Date = prop.getProperty("incDate");
		livePage = new LivePage(driver, prop);
		Assert.assertTrue(livePage.loadLiveWebElements());
		Assert.assertTrue(livePage.clickLiveTab());
		Assert.assertTrue(livePage.clickIncidentsBtn());
		Assert.assertTrue(livePage.selectDate(Date));
		Thread.sleep(2000);
		Assert.assertTrue(livePage.loadLiveIncidentElements());
		Assert.assertTrue(livePage.checkIncidents());
	}

	/**
	 * This method checks Enabling/Disabling of buttons in the button panel 
	 * @throws InterruptedException
	 */
	@Test
	public void testDMapButtonPanel() throws InterruptedException{
		dashboardPage = new MapDashboardCage(driver, prop);
		dashboardPage.loadButtonPanelElements();
		Assert.assertTrue(dashboardPage.checkButton(dashboardPage.getBtnpanelIncidents(),"incidentsButtonItemInActive","incidentsButtonItemActive","Incidents"));
		//	System.out.println("Incident Button working as expected");
		
		Assert.assertTrue(dashboardPage.checkButton(dashboardPage.getBtnpanelParking(),"parkingButtonItemInActive","parkingButtonItemActive","Parking"));
				//System.out.println("Parking Button working as expected");

		Assert.assertTrue(dashboardPage.checkButton(dashboardPage.getBtnpanelCameras(),"cameraButtonItemInActive","cameraButtonItemActive","Camera"));
    			//System.out.println("Camera Button working as expected");

		Assert.assertTrue(dashboardPage.checkButton(dashboardPage.getBtnpanelTolls(), "erpButtonItemInActive","erpButtonItemActive","Toll"));
	}

	@After
	public void teardown(){
		driver.close(); 
	}	


}
