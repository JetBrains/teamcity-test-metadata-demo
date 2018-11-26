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
        println(Code().value());
    }
}