# Mapsynq
Description: 
This problem is developed using Java and Selenium. Implemented POM(Page Object Model) approach.
Supported Browsers - MOZILLA FIREFOX,GOOGLE CHROME AND INTERNET EXPLORER BROWSERS.
Supported OS - Windows, Linux and MAC(Chosen Java as it is platform independent)

Page classes:
-------------
DirectionsPage
LivePage
MapDashboardCage

TestClass:
----------
TestMapSync
This class has below methods.
 * setup - This method loads the property file, opens the respective browser and loads mapSYNQ page.
 * testADirectionsPage - This method gets the direction for the given source/destination location.
 * testBLiveTolls - This method prints toll charges for a given vehicle type if toll exist in the given location.
 * testCIncidentByDate - This method gets and prints the incidents for the given date.
 * testDMapButtonPanel - This method checks Enabling/Disabling of buttons in the button panel.
 * teardown - This method closes the driver.

Config File:
------------
Config.properties file has xpaths of the MapSync elements and user inputs as well. This is done to avoid any rework in the code if there is any change to the html elements made by the developers.

Prerequisites:
-------------
* JDK 1.8
* Eclipse which supports JDK 1.8
* Jars like Junit, Selenium are placed as part of this project and does not require to be downloaded.

Steps to Run:
------------
* Constants.java contains a variable "CONFIG_PATH" which needs to be modified with the path where this project is currently placed in your system Config.properties. Path configured in the Constants.java is as below.
  D:/Workspace/sample/MapSynqTesting/src/resources/Config.properties
* Once this path is modified, Right click on TestMapSync.java and click on Run as Junit Test case.
* Test cases will be executed and the test case results will be available in Eclipse Junit tab.





