package com.ita.edu.teachua.cucumber.cucumberTestRunner;

import io.cucumber.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.ita.edu.teachua.cucumber.steps_definitions"}

)
public class AddLocationTestRunner extends AbstractTestNGCucumberTests {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun=true)
    public void setUpClass(){
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
    @Test(description = "Club Add Location Test", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runScenario(pickle.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }
}
