package com.sourceresource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;

public class FileReader_Openmrs {
	private static Properties property;
	private static FileInputStream fileinputstream;
	private static void setup_Property() throws IOException {
		if (property==null) {
			try {
				File file =new File("C:\\Users\\sk\\eclipse-workspace\\Openmrs\\src\\main\\java\\OpenmrsTesting.properties");
				fileinputstream =new FileInputStream(file);
				property = new Properties();
				property.load(fileinputstream);
			} catch (FileNotFoundException e) {
             Assert.fail("ERROR : FILENOTFOUND EXCEPTION OCCUR DURING THE PROPERTY FILE LOADING");
			}catch (Exception e) {
	          Assert.fail("ERROR : FILENOTFOUND EXCEPTION OCCUR DURING THE PROPERTY FILE READING");

			}
		}
	}
	public String getDataProperty(String datavalue) throws IOException {
		setup_Property();
		String browsername = property.getProperty(datavalue);
		return browsername;
		
		
	}
}
