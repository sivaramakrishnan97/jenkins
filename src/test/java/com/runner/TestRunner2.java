package com.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.baseclass.BaseClass;
import com.reports.JVMReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(tags="@login3",
				plugin = {"json:target//OMR.json", "pretty"},
				snippets=SnippetType.CAMELCASE,
				monochrome=true,
				dryRun=false,
				features= {"src//test//resources//Features"},
				glue= {"com.stepdefinition"})
public class TestRunner2 extends BaseClass {
	
	@AfterClass
	public static void afterClass() throws FileNotFoundException, IOException {
		JVMReport.generateJVMReport(getPropertyFileValue("jsonpath"));
		//JVMReport.generateJVMReport("target//OMR.json");
		System.out.println("SUCCESS");
	}


}