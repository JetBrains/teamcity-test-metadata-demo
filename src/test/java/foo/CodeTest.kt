package foo

import foo.bar.Code
import org.testng.annotations.Test

/**
 * @author kir
 */

@Test
class CodeTest {

    fun test_ok() {
        println("##teamcity[testMetadata key='some key' value='some value']")
        println("##teamcity[testMetadata key='a numeric value' type='number' value='${Code().value()}']")
    }

    fun test_failure() {
        test_ok();

        throw Exception("And here comes some problem");
    }
}