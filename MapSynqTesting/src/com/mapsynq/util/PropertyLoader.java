package com.mapsynq.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {
	/**
	 * This method loads the properties present in config page
	 * @return
	 */
	public static Properties loadProperties(){
		
		InputStream input = null;
		Properties properties = new Properties();
		try{
			//System.out.println(getClass().);
			input = new FileInputStream(Constants.CONFIG_PATH);
			properties.load(input);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return properties;
	}
	
	
}
