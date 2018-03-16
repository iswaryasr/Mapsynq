# Mapsynq
Description: This exercise is developed in Java and Selenium. Implemented using POM(Page Object Model).
This will work in MOZILLA FIREFOX,GOOGLE CHROME AND INTERNET EXPLORER BROWSERS.
As this project is done in java, it is capable of running in any OS.

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
Config.properties file has xpaths of the MapSync elements and user inputs as well.

Prerequisites:
-------------
* JDK 1.8
* I had Config.properties file placed in "D:/Workspace/sample/MapSynqTesting/src/resources/Config.properties".So please update the path of config file in Constants class in the variable "CONFIG_PATH".




