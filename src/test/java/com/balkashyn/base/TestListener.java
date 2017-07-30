package com.balkashyn.base;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestSuccess(ITestResult tr) {
        System.out.println(tr.getTestContext().getCurrentXmlTest().getName() + " test success");
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        System.out.println(tr.getTestContext().getCurrentXmlTest().getName() + " test failed");
    }

    @Override
    public void onStart(ITestContext testContext) {
        System.out.println(testContext.getCurrentXmlTest().getName() + " test started");
    }

    @Override
    public void onFinish(ITestContext testContext) {
        System.out.println(testContext.getCurrentXmlTest().getName() + " test finished");
    }
}
