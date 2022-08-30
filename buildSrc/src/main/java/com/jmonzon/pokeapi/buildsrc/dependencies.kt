@file:Suppress("unused")

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

        object Coil {
            private const val version = "2.1.0"
            const val coil = "io.coil-kt:coil:$version"
            const val coilSvg = "io.coil-kt:coil-svg:$version"
        }
    }

    object Retrofit {
        private const val version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val converterGson = "com.squareup.retrofit2:converter-gson:$version"
    }

    object OkHttp3 {
        private const val version = "4.9.3"
        const val loginInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object Arrow {
        private const val version = "1.0.1"
        const val core = "io.arrow-kt:arrow-core:$version"
    }

    object Kotlin {
        private const val version = "1.6.10"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"

        object Coroutines {
            private const val version = "1.6.0"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
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

    object JavaX {
        const val inject = "javax.inject:javax.inject:1"
    }

    object Room {
        private const val version = "2.4.3"
        const val runtime = "androidx.room:room-runtime:$version"
        const val ktx = "androidx.room:room-ktx:$version"
        const val compiler = "androidx.room:room-compiler:$version"
    }

    object Test {
        private const val version = "1.4.0"
        const val runner = "androidx.test:runner:$version"
        const val rules = "androidx.test:rules:$version"

        object Ext {
            private const val version = "1.1.3"
            const val junit = "androidx.test.ext:junit-ktx:$version"
        }

        object Espresso {
            private const val version = "3.4.0"
            const val contrib = "androidx.test.espresso:espresso-contrib:$version"
        }

        object JUnit {
            private const val version = "4.13.2"
            const val junit = "junit:junit:$version"
        }

        object Mockito {
            const val kotlin = "org.mockito.kotlin:mockito-kotlin:4.0.0"
            const val inline = "org.mockito:mockito-inline:4.4.0"
        }

        const val turbine = "app.cash.turbine:turbine:0.7.0"
    }
}