package com.twoctwop.testComponents;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listener extends BaseTest implements ITestListener {

    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
    	
        // Create a new ExtentTest
        test = extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	
        // Log the test as passed
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	
        // Log the test as failed
        test.fail(result.getThrowable());

    }

    @Override
    public void onFinish(ITestContext context) {
    	
        // Flush the ExtentReports instance
        extentReports.flush();
    }

}
