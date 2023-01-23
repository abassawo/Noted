import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose") version "1.1.0"
}

group = "com.lindenlabs.webapp"
version = "1.0"


//        implementation(compose.web.core)
//        implementation(compose.runtime)


kotlin {
    js(IR) {
        browser {
            testTask {
                testLogging.showStandardStreams = true
                useKarma {
                    useChromeHeadless()
                    useFirefox()
                }
            }
        }
        binaries.executable()
    }
}

dependencies {
    sourceSets {
            dependencies {
                project(":shared")
            }
    }
}
//    sourceSets {


//        }
//    }
