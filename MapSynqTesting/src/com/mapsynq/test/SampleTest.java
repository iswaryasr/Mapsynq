package com.mapsynq.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class SampleTest {

	@Test
	public void test() {
		/*WebDriver driver = new FirefoxDriver();
		driver.get("http://www.mapsynq.com");
		 WebElement header = driver.findElement(By.className("header_logo"));
		 assertTrue((header.isDisplayed()));*/

		//fail("Not yet implemented");
	}
	
	@Test
	public void testDirectionModule() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.mapsynq.com");
		
		driver.findElement(By.xpath("//div[@class='left_tab']/a[@data-tabid='0']")).click();
		
		WebElement source=driver.findElement(By.id("poi_from"));
		WebElement dest=driver.findElement(By.id("poi_to"));
		source.clear();
		source.sendKeys("Bedok Bus Interchange");
		//WebDriverWait wait = new WebDriverWait(driver,30);
	    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='autocomplete']")));
	    Thread.sleep(2000);
	    
		if(driver.findElement(By.xpath("//div[@class='autocomplete']")).isEnabled())  {
        //assertTrue(driver.findElement(By.className("autocomplete-w1")).
			driver.findElement(By.xpath("//div[@class='autocomplete']/div[2]")).click();
		}
    	dest.clear();
		dest.sendKeys("afsdkhgajghjhgggggaf");
		
		Thread.sleep(2000);
		//Boolean isPresent = driver.findElements(By.xpath("//div[@class='autocomplete'][2]")).size() > 0;
		if(driver.findElements(By.xpath("//div[@class='autocomplete']/div[@title='Chai Chee Street']")).size()>0)  {
			driver.findElement(By.xpath("//div[@class='autocomplete']/div[@title='Chai Chee Street']")).click();
			
		} else{}
		
		driver.findElement(By.xpath("//input[@id='get_direction']")).click();
		if((driver.findElement(By.xpath("//div[@id='divPOIFromPanel']"))).getText().equalsIgnoreCase("Your search did not find any results. Please try again.")){
		    System.out.println("Search did not find any results");
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@id='traffic_route_ribbon']")).click();
		List<WebElement> webElementList = driver.findElements(By.xpath("//div[@id='trafficRouteDirection']/div/table/tbody/tr/td[2]"));
		
		if(!webElementList.isEmpty()){
			for(WebElement direction : webElementList){
				System.out.println("direction: "+direction.getText());
			}
				
		}
		
				
	}

}
