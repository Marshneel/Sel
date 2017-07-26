import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"html:target/whisper-html-report", "json:target/whisper_report.json", "com.cucumber.listener.ExtentCucumberFormatter:output/report.html"}, tags = {"@SDSK,@smokePack,@WLR3,@WhiteLabel"})
public class RunnerTest {
}
