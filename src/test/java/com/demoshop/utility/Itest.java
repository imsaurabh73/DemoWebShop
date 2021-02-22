package com.demoshop.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Itest implements ITestListener {

	public void onTestStart(ITestResult result) 
	{
		System.out.println("on-test-start---ITestListener");	
	}

	public void onTestSuccess(ITestResult result)
	{
	
		System.out.println("on-test-success---ITestListener");	

	}

	public void onTestFailure(ITestResult result) 
	{
	
		System.out.println("on-test-failure---ITestListener");	

	}

	public void onTestSkipped(ITestResult result) 
	{

		System.out.println("on-test-skipped---ITestListener");	

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
