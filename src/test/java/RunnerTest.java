import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"html:target/whisper-html-report", "json:target/whisper_report.json", "com.cucumber.listener.ExtentCucumberFormatter:output/report.html"}, tags = {"@NA87,@NA60,@NA61,@NA64"})
public class RunnerTest {
}
