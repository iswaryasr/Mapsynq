package com.mapsynq.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MapDashboardCage {
	
	WebDriver webDriver;
	Properties properties = null;

	WebElement btnpanelTraffic, btnpanelIncidents, btnpanelParking, btnpanelCameras, btnpanelTolls = null;
	
	public void loadButtonPanelElements(){
		btnpanelTraffic = webDriver.findElement(By.xpath(properties.getProperty("btnpnltraffic")));
		btnpanelIncidents = webDriver.findElement(By.xpath(properties.getProperty("btnpnlincidents")));
		btnpanelParking = webDriver.findElement(By.xpath(properties.getProperty("btnpnlparking")));
		btnpanelCameras = webDriver.findElement(By.xpath(properties.getProperty("btnpnlcameras")));
		btnpanelTolls = webDriver.findElement(By.xpath(properties.getProperty("btnpnltolls")));

	}
	
	public WebDriver getWebDriver() {
		return webDriver;
	}



	public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}



	public Properties getProperties() {
		return properties;
	}



	public void setProperties(Properties properties) {
		this.properties = properties;
	}



	public WebElement getBtnpanelTraffic() {
		return btnpanelTraffic;
	}



	public void setBtnpanelTraffic(WebElement btnpanelTraffic) {
		this.btnpanelTraffic = btnpanelTraffic;
	}



	public WebElement getBtnpanelIncidents() {
		return btnpanelIncidents;
	}



	public void setBtnpanelIncidents(WebElement btnpanelIncidents) {
		this.btnpanelIncidents = btnpanelIncidents;
	}



	public WebElement getBtnpanelParking() {
		return btnpanelParking;
	}



	public void setBtnpanelParking(WebElement btnpanelParking) {
		this.btnpanelParking = btnpanelParking;
	}



	public WebElement getBtnpanelCameras() {
		return btnpanelCameras;
	}



	public void setBtnpanelCameras(WebElement btnpanelCameras) {
		this.btnpanelCameras = btnpanelCameras;
	}



	public WebElement getBtnpanelTolls() {
		return btnpanelTolls;
	}



	public void setBtnpanelTolls(WebElement btnpanelTolls) {
		this.btnpanelTolls = btnpanelTolls;
	}



	public void checkButtonPanelItems(){
		if(checkButton(btnpanelTraffic,"speedButtonItemInActive","speedButtonItemActive","Traffic")){
			System.out.println("Traffic Button working as expected");
		}
	}
	
    public boolean checkButton(WebElement element,String inactiveCss, String activeCss, String button){
    	boolean exitMethod = false;
    	boolean isButtonActive = false;
    	boolean isButtonInActive = false;
    	while(!exitMethod){
    		element.click();
    		if(element.getAttribute("class").equalsIgnoreCase(activeCss)){
    			System.out.println(button+" button is enabled");
    			isButtonInActive = true;
    		}
    		else if(element.getAttribute("class").equalsIgnoreCase(inactiveCss)){
    			System.out.println(button+" button is disabled");
    			isButtonActive = true;
    		}
    		if(isButtonActive && isButtonInActive){
    			exitMethod = true;
    		}
    	}
    	return exitMethod;
    }
    	
	public MapDashboardCage(WebDriver webDriver, Properties properties) {
		this.webDriver = webDriver;
		this.properties = properties;
	}

}
