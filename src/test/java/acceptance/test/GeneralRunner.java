package acceptance.test;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.junit5.Karate;
import cucumber.api.CucumberOptions;
import nonapi.io.github.classgraph.utils.Assert;
import org.junit.jupiter.api.Test;
import org.apache.commons.io.FileUtils;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;



import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@CucumberOptions(features = "classpath:features")
public class GeneralRunner {
    @Karate.Test
    Karate testUsers() {
        return Karate.run("prueba-tecnica.feature").relativeTo(getClass());
    }
}