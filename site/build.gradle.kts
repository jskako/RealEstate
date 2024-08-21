import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kobweb.application)
    alias(libs.plugins.serialisation.plugin)
    // alias(libs.plugins.kobwebx.markdown)
}

group = "com.gamingingrs.realestate"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            description.set("Find your dream home with our comprehensive real estate listings. Explore top properties in Croatia with detailed information and photos.")
        }
    }
}

kotlin {
    configAsKobwebApplication("realestate", includeServer = true)

    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.runtime)
        }

        jsMain.dependencies {
            implementation(libs.compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk)
            implementation(libs.silk.icons.fa)
            // implementation(libs.kobwebx.markdown)
            
        }
        jvmMain.dependencies {
            compileOnly(libs.kobweb.api) // Provided by Kobweb backend at runtime
            implementation(libs.slf4j.api)
            implementation(libs.slf4j.simple)
            implementation(libs.kmongo.coroutine)
            implementation(libs.kmongo.serialization)
            implementation(libs.kotlinx.serialization.json)
        }
    }
}
