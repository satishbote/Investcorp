package org.ejagruti.investcorp.generic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileReader {
	private  String GetParameterValue_child(String ParameterName) throws IOException
	{
		InputStream input = null;
		Properties prop = new Properties();
		input = getClass().getClassLoader().getResourceAsStream("config.properties");
		System.out.println(input);
		// load a properties file
		prop.load(input);
		String ParameterValue=prop.getProperty(ParameterName);
		System.out.println(ParameterValue);
		return ParameterValue;

	}
	public static String GetParameterValue(String ParameterName) throws IOException
	{
		PropertiesFileReader pf=new PropertiesFileReader();
		return pf.GetParameterValue_child(ParameterName);
	}
}
