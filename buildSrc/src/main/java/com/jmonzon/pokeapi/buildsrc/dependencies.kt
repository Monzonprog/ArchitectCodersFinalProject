package com.jmonzon.pokeapi.buildsrc

object Libs {
    object Hilt {
        private const val version = "2.43"
        const val android = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-compiler:$version"
        const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
        const val test = "com.google.dagger:hilt-android-testing:$version"
    }

    object ManageImages {
        object Lottie {
            private const val version = "5.2.0"
            const val lottie = "com.airbnb.android:lottie:$version"
        }

        object Glide {
            private const val version = "4.13.1"
            const val glide = "com.github.bumptech.glide:glide:$version"
            const val compiler = "com.github.bumptech.glide:compiler:$version"
        }
    }

    object AndroidX {

        const val coreKtx = "androidx.core:core-ktx:1.7.0"
        const val appCompat = "androidx.appcompat:appcompat:1.4.1"

        object Activity {
            private const val version = "1.4.0"
            const val ktx = "androidx.activity:activity-ktx:1.4.0"
        }

        object Lifecycle {
            private const val version = "2.4.1"
            const val viewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
        }

        object Navigation {
            private const val version = "2.5.0"
            const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:$version"
            const val uiKtx = "androidx.navigation:navigation-ui-ktx:$version"
            const val featuresFragment =
                "androidx.navigation:navigation-dynamic-features-fragment:$version"
            const val gradlePlugin =
                "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
        }
    }
}