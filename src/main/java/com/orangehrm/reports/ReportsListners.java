package com.orangehrm.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import lombok.SneakyThrows;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ReportsListners implements ITestListener {

    ExtentSparkReporter extentSparkReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;

    public void onTestStart ( ITestResult result ) {
        extentTest = extentReports.createTest ( result.getMethod ( ).getDescription ( ) );
    }

    public void onTestSuccess ( ITestResult result ) {
        extentTest.pass ( result.getMethod ( ).getDescription ( ) + " : PASSED" );
    }

    public void onTestFailure ( ITestResult result ) {
        extentTest.fail ( result.getMethod ( ).getDescription ( ) + " : FAILED" );
    }

    public void onTestSkipped ( ITestResult result ) {
        extentTest.skip ( result.getMethod ( ).getDescription ( ) + " : SKIPPED"  );
    }

    @SneakyThrows
    public void onStart ( ITestContext context ) {
        File file = new File ( System.getProperty ( "user.dir" ) + "/report.html" );
        extentSparkReporter = new ExtentSparkReporter ( file );
        final  File reportConfig = new File ( "extentReportConfig.json" );
        extentSparkReporter.loadJSONConfig ( reportConfig );

        extentReports = new ExtentReports ( );
        extentReports.attachReporter ( extentSparkReporter );

    }

    public void onFinish ( ITestContext context ) {
        extentReports.flush ( );
        try {
            Desktop.getDesktop ( ).browse ( new File ( "report.html" ).toURI ( ) );
        } catch (IOException exception) {
            exception.printStackTrace ( );
        }
    }
}
