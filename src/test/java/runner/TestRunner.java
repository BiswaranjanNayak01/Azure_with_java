package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"azureRestApi.azure_sql_database.stepDef"},
        tags = "@test",
        monochrome = true,
        publish = true,
        plugin = {"pretty",
                "html:Reports/AutomationReport.html",
                "html:target/cucumber-reports/cucumber-pretty.html",
                "json:target/cucumber-reports/JsonReport/CucumberTestReport.json",
        }
)

public class TestRunner extends AbstractTestNGCucumberTests {
//        https://learn.microsoft.com/en-us/rest/api/sql/databases/get?view=rest-sql-2021-11-01&tabs=HTTP
}
