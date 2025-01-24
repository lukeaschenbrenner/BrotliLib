To include Brotli in your own Android project, visit [Maven Central](https://central.sonatype.com/artifact/io.github.lukeaschenbrenner/Brotli4Droid)
(In short, add ``implementation 'io.github.lukeaschenbrenner:Brotli4Droid:X.X.X'`` to your build.gradle)

To publish this to Maven, run the following Gradle tasks on project BrotliLib:brotli4droid:
1. clean
2. build
3. publish
4. jreleaserDeploy

There are credentials in gradle.properties you will have to self-supply. It's recommended to specify the ``GRADLE_USER_HOME`` environment variable, then put them there.