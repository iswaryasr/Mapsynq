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
	/**
	 * This method loads the xpaths for Live Page elements
	 * Locates the element using selenium find_element_by_xpath method
	 * And stores it in a WebElement Objects. 
	 */
	public boolean loadLiveWebElements(){
		boolean isLoaded = false;
		try{
		liveTab = webDriver.findElement(By.xpath(properties.getProperty("livetabxpath")));
		incidentBtn = webDriver.findElement(By.xpath(properties.getProperty("incidentbtnxpath")));
		camerasBtn = webDriver.findElement(By.xpath(properties.getProperty("camerasbtnxpath")));
		tollsBtn = webDriver.findElement(By.xpath(properties.getProperty("tollsbtnxpath")));
		tollsLocSearchBox = webDriver.findElement(By.xpath(properties.getProperty("locsearchtxtbox")));
		selectTollLocation = webDriver.findElement(By.xpath(properties.getProperty("selecttollloc")));
		adToggle = webDriver.findElement(By.xpath(properties.getProperty("adtogglecollapse")));
		selectDate = webDriver.findElement(By.xpath(properties.getProperty("seldate")));
		isLoaded =true;
		}
		catch(Exception e){
			isLoaded = false;
		}
		return isLoaded;
	}
        
	public boolean loadLiveIncidentElements(){
		boolean isLoaded = false;
		try{
		noIncidentInfo=webDriver.findElement(By.xpath(properties.getProperty("noincinfo")));
		isLoaded = true;
		}
		catch(Exception e){
			isLoaded = false;
		}
		return isLoaded;
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
	
	public boolean clickLiveTab(){
		boolean isClicked =false;
		try{
			liveTab.click();
			isClicked = true;
		}
		catch(Exception e){
			isClicked = false;
		}
		return isClicked;
	}
	
	public boolean clickTollsTab(){
		boolean isClicked = false;
		try{
			tollsBtn.click();
			isClicked = true;
		}
		catch(Exception e){
			isClicked =false;
		}
		return isClicked;
	}
	
	public boolean selectTollLoc(){
		boolean isClicked =false;
		try{
			selectTollLocation.click();	
			isClicked = true;
		}
		catch(Exception e){
			isClicked =false;
		}
		return isClicked;		
	}
	public void closeAdToggle(){
		adToggle.click();
	}
	/**
	 * This method selects the type of vehicle for which toll charges are needed.
	 * @param vehicleType
	 */
	public boolean selectVehicleTollCharge(String vehicleType){
		boolean isClicked = false;
		try{
		vehTypeDropDown =  webDriver.findElement(By.xpath(properties.getProperty("vehicledrpdwn")));
	    vehTypeDropDown.click();
		Select drop= new Select(vehTypeDropDown);
		drop.selectByVisibleText(vehicleType);
		vehTypeDropDown.sendKeys(Keys.ENTER);
		isClicked = true;
		}
		catch(Exception e){
			isClicked = false;
		}
		return isClicked;
	}
	/**
	 * This method prints the toll charges for the give type of vehicle
	 */
	public boolean printTollCharges(){
		boolean isPrinted = false;
		try{
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
		isPrinted = true;
		}
		
		catch(Exception e){
			isPrinted = false;
		}
		return isPrinted;
	}	
    /**
     * This method clicks the Incident button.
     */
	public boolean clickIncidentsBtn(){
		boolean isClicked = false;
		try{
			incidentBtn.click();
			isClicked = true;
		}
		catch(Exception e){
			isClicked = false;
		}
		return isClicked;
	}
	/**
	 * This method selects the date for getting the incidents
	 * @param Date
	 */
	public boolean selectDate(String Date){
		boolean isSelected = false;
		try{
		System.out.println("Date:"+Date);
		Select date= new Select(selectDate);
		date.selectByVisibleText(Date);
		isSelected = true;
		}
		catch(Exception e){
			isSelected = false;
		}
		return isSelected;
	}
	/**
	 * This method checks if the incidents appear for the given date and
	 * prints the same
	 */
	public boolean checkIncidents(){
		
		boolean isSuccess = false;
		try{
		if(webDriver.findElement(By.xpath(properties.getProperty("noincinfo"))).isDisplayed()){
			isSuccess = true;
			//System.out.println("No incident appears for the given date or location");
			
		}else{
			incidentList=webDriver.findElements(By.xpath(properties.getProperty("incidents")));
			List<WebElement> incList = incidentList;
			
			if(!incList.isEmpty()){
				System.out.println("Below incident appears for the given date or location:");
				for(WebElement incident : incList) {
				//for (incList, incTimeList; incList.size(),incTimeList.size();){
					isSuccess = true;
					System.out.println("*"+incident.getText());
				}
			}
		}
		}
		catch(Exception e){
			isSuccess = false;
			System.err.println("Exception while testing incident "+e.getMessage());
		}
		
		return isSuccess;
		
	}	
	
}
