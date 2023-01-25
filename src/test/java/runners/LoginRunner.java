package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = { "pretty" },
		monochrome = true, // salida de consola más legible
		features = "src/test/resources/features/login/login.feature", // 0
		glue = {"steps.Hooks","steps"}, 
		tags = ("@loginCorrecto or @loginIncorrecto"))

public class LoginRunner {

}
