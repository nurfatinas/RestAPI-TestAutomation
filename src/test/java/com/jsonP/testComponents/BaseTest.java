package com.jsonP.testComponents;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.restassured.RestAssured;

public class BaseTest {

	protected static ExtentReports extentReports;  // Change to static
    protected ExtentTest extentTest;  // Change to protected

    @BeforeClass(alwaysRun = true)
    public void setup() {
        // Specify the output file for the report
        String reportPath = System.getProperty("user.dir") + "//target//html-reports//api-testing.html";

        // Extent Reports setup
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);

        extentTest = extentReports.createTest("API Testing -run using testng");

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        // Save and close the report
        extentReports.flush();
    }
    
}
