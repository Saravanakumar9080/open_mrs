package com.pageobjectmanager;

import com.baseclass.Baseclass;
import com.interfaceelements.OpenmrsInterfaceElements;
import com.pageobjectmodel.OpenmrsLoginpage;
import com.sourceresource.FileReader_Openmrs;

public class ProjectManagerOpenmrs extends Baseclass implements OpenmrsInterfaceElements {
	private OpenmrsLoginpage loginpage;
	private FileReader_Openmrs filereader;
	
	
	public OpenmrsLoginpage getLoginpage() {
		if (loginpage == null) {
			loginpage =new OpenmrsLoginpage(driver);
			
		}
		return loginpage;
	}
	public FileReader_Openmrs getFilereader() {
		if (filereader == null) {
			filereader =new FileReader_Openmrs();
			
			
		}
		return filereader;
	}
	
	

}
