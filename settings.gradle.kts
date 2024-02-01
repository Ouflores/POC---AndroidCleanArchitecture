pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "Checkout"
include(":app")
include(":feature:checkout:checkout_presentation")
include(":feature:checkout:checkout_data")
include(":feature:checkout:checkout_domain")
include(":feature:airtime:airtime_presentation")
include(":feature:airtime:airtime_data")
include(":feature:airtime:airtime_domain")
include(":feature:my_account:my_account_presentation")
include(":feature:my_account:my_account_data")
include(":feature:my_account:my_account_domain")
include(":commons:common_ui")
include(":commons:common:common_domain")
include(":commons:common:common_data")
include(":core:core_network")
include(":core:core_database")
include(":commons:common:common")
