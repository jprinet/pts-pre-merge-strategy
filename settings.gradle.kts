plugins {
    id("com.gradle.enterprise") version "3.16.1"
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
}

rootProject.name = "pts-pre-merge-strategy"

gradleEnterprise {
    server = "https://foo.bar"
}