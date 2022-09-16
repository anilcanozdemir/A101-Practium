package testRunners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;


@CucumberOptions(
        features = {"src/test/java/android/features"},
        glue = {"android/stepDefinitions", "util"},
        tags = "",
        plugin = {
                "summary", "pretty", "html:Reports/CucumberReport/androidReports/androidReports.html",
                "json:Reports/CucumberReport/androidReports/androidReports",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class androidRunner extends AbstractTestNGCucumberTests {


    @BeforeSuite
    public void beforeSuite() {
    }

    @BeforeTest()
    public void beforeTest() {
    }

    @BeforeClass
    public void beforeClass() {
    }

    @BeforeMethod
    public void beforeMethod() {
    }

    @BeforeGroups
    public void beforeGroup() {
    }

    @AfterMethod
    public void afterMethod() {
    }

    @AfterClass
    public void afterClass() {
    }

    @AfterTest
    public void afterTest() {
    }

    @AfterSuite
    public void afterSuite() {
    }

    @AfterGroups
    public void afterGroup() {
    }
}