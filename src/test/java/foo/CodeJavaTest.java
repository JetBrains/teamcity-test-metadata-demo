package foo;

import foo.bar.Code;
import org.testng.annotations.Test;

import static java.lang.String.*;
import static java.lang.System.*;

public class CodeJavaTest {

    @Test
    public void test_ok() {

        // Simple text metadata:
        out.println("##teamcity[testMetadata key='some key' value='some value']");

        // Numeric metadata
        out.println(format("##teamcity[testMetadata key='a numeric value' type='number' value='%f']",
                new Code().value()));

        // Reference to an artifact
        // gradle_test_report.zip should be created by specifying corresponding artifact path in TC
        String testsPath = format("gradle_test_report.zip!/classes/%s.html", getClass().getName());
        
        out.println(format("##teamcity[testMetadata key='Gradle test report' type='artifact' value='%s']",
                testsPath));

        publishScreenshot();
    }

    private void publishScreenshot() {

        out.println("##teamcity[publishArtifacts 'pictureForAttention.png']");
        out.println("##teamcity[testMetadata type='image' name='Some screenshot' value='pictureForAttention.png']");

    }

    @Test
    public void test_failure() throws Exception {
        test_ok();

        throw new Exception("And here comes some problem");
    }

}