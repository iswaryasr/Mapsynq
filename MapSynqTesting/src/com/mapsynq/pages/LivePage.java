package com.mapsynq.pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.mapsynq.util.PropertyLoader;

public class LivePage {
	
	WebDriver webDriver;
	Properties properties = null;
    WebElement liveTab, incidentBtn, camerasBtn, tollsBtn, tollsLocSearchBox,vehTypeDropDown = null;
    WebElement selectTollLocation, adToggle, frame1, selectDate = null;
    WebElement noIncidentInfo = null; 
    List<WebElement> rates, incidentList, incidentTimes;
	
	public void loadLiveWebElements(){
		liveTab = webDriver.findElement(By.xpath(properties.getProperty("livetabxpath")));
		incidentBtn = webDriver.findElement(By.xpath(properties.getProperty("incidentbtnxpath")));
		camerasBtn = webDriver.findElement(By.xpath(properties.getProperty("camerasbtnxpath")));
		tollsBtn = webDriver.findElement(By.xpath(properties.getProperty("tollsbtnxpath")));
		tollsLocSearchBox = webDriver.findElement(By.xpath(properties.getProperty("locsearchtxtbox")));
		selectTollLocation = webDriver.findElement(By.xpath(properties.getProperty("selecttollloc")));
		adToggle = webDriver.findElement(By.xpath(properties.getProperty("adtogglecollapse")));
		//frame1= webDriver.findElement(By.id(properties.getProperty("ERPratesframe")));
		selectDate = webDriver.findElement(By.xpath(properties.getProperty("seldate")));
    }
        
	public void loadLiveIncidentElements(){
		
		noIncidentInfo=webDriver.findElement(By.xpath(properties.getProperty("noincinfo")));
	}
	public WebElement getLiveTab() {
		return liveTab;
	}

	public void setLiveTab(WebElement liveTab) {
		this.liveTab = liveTab;
	}

	public WebElement getIncidentBtn() {
		return incidentBtn;
	}

	public void setIncidentBtn(WebElement incidentBtn) {
		this.incidentBtn = incidentBtn;
	}

	public WebElement getCamerasBtn() {
		return camerasBtn;
	}

	public void setCamerasBtn(WebElement camerasBtn) {
		this.camerasBtn = camerasBtn;
	}

	public WebElement getTollsBtn() {
		return tollsBtn;
	}

	public void setTollsBtn(WebElement tollsBtn) {
		this.tollsBtn = tollsBtn;
	}

	public WebElement getTollsLocSearchBox() {
		return tollsLocSearchBox;
	}

	public void setTollsLocSearchBox(WebElement tollsLocSearchBox) {
		this.tollsLocSearchBox = tollsLocSearchBox;
	}

	public WebElement getVehTypeDropDown() {
		return vehTypeDropDown;
	}

	public void setVehTypeDropDown(WebElement vehTypeDropDown) {
		this.vehTypeDropDown = vehTypeDropDown;
	}

	public WebElement getSelectTollLocation() {
		return selectTollLocation;
	}

	public void setSelectTollLocation(WebElement selectTollLocation) {
		this.selectTollLocation = selectTollLocation;
	}

	public WebElement getAdToggle() {
		return adToggle;
	}

	public void setAdToggle(WebElement adToggle) {
		this.adToggle = adToggle;
	}

	public WebElement getFrame1() {
		return frame1;
	}

	public void setFrame1(WebElement frame1) {
		this.frame1 = frame1;
	}

	public WebElement getSelectDate() {
		return selectDate;
	}

	public void setSelectDate(WebElement selectDate) {
		this.selectDate = selectDate;
	}
	//List<WebElement> rates, incidentList, incidentTimes;
	public List<WebElement> getRates() {
		return rates;
	}

	public void setRates(List<WebElement> rates) {
		this.rates = rates;
	}

	public WebElement getNoIncidentInfo() {
		return noIncidentInfo;
	}

	public void setNoIncidentInfo(WebElement noIncidentInfo) {
		this.noIncidentInfo = noIncidentInfo;
	}

	public List<WebElement> getIncidentList() {
		return incidentList;
	}

	public void setIncidentList(List<WebElement> incidentList) {
		this.incidentList = incidentList;
	}

	public List<WebElement> getIncidentTimes() {
		return incidentTimes;
	}

	public void setIncidentTimes(List<WebElement> incidentTimes) {
		this.incidentTimes = incidentTimes;
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	public LivePage(WebDriver webDriver, Properties properties){
		this.webDriver = webDriver;
		this.properties =properties;
	}
	
	public void clickLiveTab(){
		liveTab.click();
	}
	public void clickTollsTab(){
		tollsBtn.click();
	}
	public void selectTollLoc(){
		selectTollLocation.click();		
	}
	public void closeAdToggle(){
		adToggle.click();
	}
	public void selectVehicleTollCharge(String vehicleType){
		vehTypeDropDown =  webDriver.findElement(By.xpath(properties.getProperty("vehicledrpdwn")));
	    vehTypeDropDown.click();
		Select drop= new Select(vehTypeDropDown);
		drop.selectByVisibleText(vehicleType);
		vehTypeDropDown.sendKeys(Keys.ENTER);			
		}
	
	public void printTollCharges(){

		rates = webDriver.findElements(By.xpath(properties.getProperty("tollrates")));
		List<WebElement> webElementList = rates;
		
		if(!webElementList.isEmpty()){
			System.out.println("Time and Rates:");
			for(WebElement rate : webElementList){
				System.out.println(""+rate.getText());
		
			}
		}else{
				System.out.println("Toll rates are blank");
		}
	}	
	
	public void clickIncidentsBtn(){
		incidentBtn.click();
	}
	public void selectDate(String Date){
		System.out.println("Date:"+Date);
		Select date= new Select(selectDate);
		date.selectByVisibleText(Date);
			
	}
	public void checkIncidents(){
		
		if(webDriver.findElement(By.xpath(properties.getProperty("noincinfo"))).isDisplayed()){
			System.out.println("No incident appears for the given date or location");
			
		}else{
			incidentList=webDriver.findElements(By.xpath(properties.getProperty("incidents")));
			List<WebElement> incList = incidentList;
			
			if(!incList.isEmpty()){
				System.out.println("Below incident appears for the given date or location:");
				for(WebElement incident : incList) {
				//for (incList, incTimeList; incList.size(),incTimeList.size();){
				
					System.out.println("*"+incident.getText());
				}
			}
		}
		
	}	
	
}
