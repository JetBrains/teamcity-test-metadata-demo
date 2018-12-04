# teamcity-test-metadata-demo

A sample project which shows how to report test metadata/attachments to TeamCity 2018.2+

The project contains TeamCity configuration ([.teamcity/settings.kts](https://github.com/JetBrains/teamcity-test-metadata-demo/blob/master/.teamcity/settings.kts) so you can add the corresponding project 
to TeamCity server via **Create project**=>**From a repository URL**.

The project itself is a Kotlin/Gradle project with TestNG test.

See [CodeTest.kt](https://github.com/JetBrains/teamcity-test-metadata-demo/blob/master/src/test/java/foo/CodeTest.kt) for the test metadata reporting code.
