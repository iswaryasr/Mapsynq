package com.mapsynq.pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mapsynq.util.PropertyLoader;

public class DirectionsPage {

	WebDriver webDriver;
	
	Properties properties = null;
	
	String sourceProp = null;
	
	String destinationProp = null;
	
	WebElement source,destination, directionButton, directionTab, trafficRouteRibbon = null;
	
	public void loadDirectionWebElements(){
		source = webDriver.findElement(By.xpath(properties.getProperty("srcxpath")));
		destination = webDriver.findElement(By.xpath(properties.getProperty("destxpath")));
		directionButton = webDriver.findElement(By.xpath(properties.getProperty("dirnbutnxpath")));
		directionTab = webDriver.findElement(By.xpath(properties.getProperty("dirtabxpath")));
		trafficRouteRibbon = webDriver.findElement(By.xpath(properties.getProperty("trafficroutexpath")));
		trafficRouteDirection = webDriver.findElements(By.xpath(properties.getProperty("trafficroutedirection")));
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

	public DirectionsPage(WebDriver webDriver){
		this.webDriver = webDriver;
		properties = PropertyLoader.loadProperties();
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

	    
	public void clickDirectionTab(){
		directionTab.click();
		
	}
	public void clickGetDirection(){
		directionButton.click();
	}
	
	public void clickTrafficRouteRibbon(){
		WebDriverWait wait = new WebDriverWait(webDriver,30);
	    wait.until(ExpectedConditions.visibilityOf(trafficRouteRibbon));
		trafficRouteRibbon.click();
	}
	public void printTrafficRoute(){
        List<WebElement> webElementList = trafficRouteDirection;
		
		if(!webElementList.isEmpty()){
			for(WebElement direction : webElementList){
				System.out.println("direction: "+direction.getText());
			}
	}
	
	
	}
	
}
