import com.beust.kobalt.*
import com.beust.kobalt.plugin.packaging.*
import com.beust.kobalt.plugin.application.*
import com.beust.kobalt.plugin.kotlin.*

val buildScript = buildScript {
    repos("http://dl.bintray.com/kotlin/ktor")
    plugins("com.beust.kobalt:kobalt-line-count:0.18")
}

object Versions {
    val ktor = "0.3.3-SNAPSHOT"
    val thymeleaf = "3.0.3.RELEASE"
}

val petclinic = project {
    name = "g"
    group = "com.example"
    artifactId = name
    version = "0.1"

    assemble {
        jar {
            fatJar = true
        }
    }

    dependencies {
        compile("org.thymeleaf:thymeleaf:${Versions.thymeleaf}")
        compile("org.jetbrains.ktor:ktor-locations:${Versions.ktor}")
        compile("org.jetbrains.ktor:ktor-jetty:${Versions.ktor}")
    }

    dependenciesTest {
        compile("org.testng:testng:6.11")
    }

    application {
        mainClass = "com.example.MainKt"
    }
}

