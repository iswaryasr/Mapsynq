package com.mapsynq.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {
	/**
	 * 
	 * @return
	 */
	public static Properties loadProperties(){
		
		InputStream input = null;
		Properties properties = new Properties();
		try{
			//System.out.println(getClass().);
			input = new FileInputStream("D:/Workspace/sample/MapSynqTesting/src/resources/Config.properties");
			properties.load(input);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return properties;
	}
	
	
}
