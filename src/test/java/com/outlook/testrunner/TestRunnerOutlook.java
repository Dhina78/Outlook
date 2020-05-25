package com.outlook.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;		

@RunWith(Cucumber.class)				
@CucumberOptions
(strict = true,features="src/test/java/features",glue={"com.outlook.stepdefinition"})						

public class TestRunnerOutlook {

}
