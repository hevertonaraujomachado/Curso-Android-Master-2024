pluginManagement {
    repositories {
        google {
            maven { setUrl ("https://artifacts.mercadolibre.com/repository/android-releases/") }
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        maven { setUrl ("https://artifacts.mercadolibre.com/repository/android-releases/") }
        mavenCentral()
    }
}

rootProject.name = "Loja Virtual"
include(":app")
