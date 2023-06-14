package com.reports;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.baseclass.BaseClass;

import net.bytebuddy.utility.privilege.GetSystemPropertyAction;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVMReport extends BaseClass {
	
	public static  void generateJVMReport(String jsonFile) throws FileNotFoundException, IOException {
		
		File reportLoc = new File(getProjectpath()+ getPropertyFileValue("jvmpath"));
	//	File reportLoc = new File(System.getProperty("user.dir")+"//target");
		
		Configuration con = new Configuration(reportLoc, "OMRHotelAutomation");
		
		con.addClassifications("Platform","Windows11");
		con.addClassifications("Sprint","21");
		con.addClassifications("Author","Siva");
		
		List<String> l = new LinkedList<String>();
		l.add(jsonFile);
		
		ReportBuilder builder= new ReportBuilder(l,con);
		builder.generateReports();

	}

	
}
