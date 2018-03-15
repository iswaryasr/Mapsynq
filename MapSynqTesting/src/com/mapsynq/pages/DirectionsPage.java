package com.mapsynq.pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DirectionsPage {

	WebDriver webDriver;
	
	Properties properties = null;
	
	String sourceProp = null;
	
	String destinationProp = null;
	
	WebElement source,destination, directionButton, directionTab, trafficRouteRibbon = null;
	/**
	 * This method loads the xpaths for direction page elements
	 * Locates the element using selenium find_element_by_xpath method
	 * And stores it in a WebElement Object. 
	 * 
	 */
	public boolean loadDirectionWebElements(){
		boolean isLoaded = false;
		try{
		source = webDriver.findElement(By.xpath(properties.getProperty("srcxpath")));
		destination = webDriver.findElement(By.xpath(properties.getProperty("destxpath")));
		directionButton = webDriver.findElement(By.xpath(properties.getProperty("dirnbutnxpath")));
		directionTab = webDriver.findElement(By.xpath(properties.getProperty("dirtabxpath")));
		trafficRouteRibbon = webDriver.findElement(By.xpath(properties.getProperty("trafficroutexpath")));
		trafficRouteDirection = webDriver.findElements(By.xpath(properties.getProperty("trafficroutedirection")));
		isLoaded = true;
		}
		catch(Exception e){
			isLoaded = false;
		}
		return isLoaded;
	}
		
	public WebElement getSource() {
		return source;
	}

	public void setSource(WebElement source) {
		this.source = source;
	}

	public WebElement getDestination() {
		return destination;
	}

	public void setDestination(WebElement destination) {
		this.destination = destination;
	}

	public WebElement getDirectionButton() {
		return directionButton;
	}

	public void setDirectionButton(WebElement directionButton) {
		this.directionButton = directionButton;
	}
	
	List<WebElement> trafficRouteDirection;
	
	public List<WebElement> getTrafficRouteDirection() {
		return trafficRouteDirection;
	}

	public void setTrafficRouteDirection(List<WebElement> trafficRouteDirection) {
		this.trafficRouteDirection = trafficRouteDirection;
	}

	public WebElement getTrafficRouteRibbon() {
		return trafficRouteRibbon;
	}

	public void setTrafficRouteRibbon(WebElement trafficRouteRibbon) {
		this.trafficRouteRibbon = trafficRouteRibbon;
	}

	public DirectionsPage(WebDriver webDriver, Properties properties){
		this.webDriver = webDriver;
		this.properties = properties;
	}

	public WebElement getDirectionTab() {
		return directionTab;
	}

	public void setDirectionTab(WebElement directionTab) {
		this.directionTab = directionTab;
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	    
	public boolean clickDirectionTab(){
		boolean isClicked = false;
		try{
		directionTab.click();
		isClicked = true;
		}
		catch(Exception e){
			isClicked = false;
		}
		return isClicked;
	}
	public boolean clickGetDirection(){
		boolean isClicked = false;
		try{
		directionButton.click();
		isClicked = true;
		}
		catch(Exception e){
			isClicked = false;
		}
		return isClicked;
	}
	/**
	 * This method clicks the traffic route ribbon icon in the directions page
	 */
	public boolean clickTrafficRouteRibbon(){
		boolean isClicked = false;
		try{
		WebDriverWait wait = new WebDriverWait(webDriver,30);
	    wait.until(ExpectedConditions.visibilityOf(trafficRouteRibbon));
		trafficRouteRibbon.click();
		isClicked = true;
		}
		catch(Exception e){
			isClicked = false;
		}
		return isClicked;
	}
	/**
	 * This method prints the direction to the specified location populated in the direction
	 * page after clicking the traffic route ribbon button
	 */
	public boolean printTrafficRoute(){
        List<WebElement> webElementList = trafficRouteDirection;
		boolean isPrinted = false;
		try{
		if(!webElementList.isEmpty()){
			for(WebElement direction : webElementList){
				isPrinted = true;
				System.out.println("direction: "+direction.getText());
			}
			
	    }
		}
		catch(Exception e){
			isPrinted = false;
		}
		return isPrinted;
	}
    
	
}
