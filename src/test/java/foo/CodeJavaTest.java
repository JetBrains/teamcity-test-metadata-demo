package foo;

import foo.bar.Code;
import org.testng.annotations.Test;

import static java.lang.String.*;

/**
 * @author kir
 */


public class CodeJavaTest {

    @Test
    public void test_ok() {

        // Simple text metadata:
        System.out.println("##teamcity[testMetadata key='some key' value='some value']");

        // Numeric metadata
        System.out.println(format("##teamcity[testMetadata key='a numeric value' type='number' value='%f']", new Code().value()));

        // Reference to an artifact
        // gradle_test_report.zip should be created by specifying corresponding artifact path in TC
        String testsPath = format("gradle_test_report.zip!/classes/%s.html", getClass().getName());
        System.out.println(format("##teamcity[testMetadata key='Gradle test report' type='artifact' value='%s']", testsPath));

        publishScreenshot();
    }

    @Test
    public void test_failure() throws Exception {
        test_ok();

        throw new Exception("And here comes some problem");
    }

    private void publishScreenshot() {

        System.out.println("##teamcity[publishArtifacts 'pictureForAttention.png']");
        System.out.println("##teamcity[testMetadata type='image' name='Some screenshot' value='pictureForAttention.png']");

    }

}