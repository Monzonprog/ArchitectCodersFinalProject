package com.jmonzonm.pokeapi.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.jmonzonm.pokeapi.R
import com.jmonzonm.pokeapi.data.MockWebServerRule
import com.jmonzonm.pokeapi.data.OkHttp3IdlingResource
import com.jmonzonm.pokeapi.data.fromJson
import com.jmonzonm.pokeapi.data.network.datasource.PokemonServerDataSource
import com.jmonzonm.pokeapi.presentation.MainActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject


@ExperimentalCoroutinesApi
@HiltAndroidTest
class HomeInstrumentationTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val mockServerRule = MockWebServerRule()

    @get:Rule(order = 2)
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Inject
    lateinit var okHttpClient: OkHttpClient

    @Inject
    lateinit var pokemonServerDataSource: PokemonServerDataSource

    @Before
    fun setUp() {
        mockServerRule.server.enqueue(
            MockResponse().fromJson("pokemon_list.json")
        )

        hiltRule.inject()

        val resource = OkHttp3IdlingResource.create("OkHttp", okHttpClient)
        IdlingRegistry.getInstance().register(resource)
    }

    /* If test dont find R.id.recycler disable animation from device*/
    @Test
    fun click_in_pokemon_name_and_navigate() {
        onView(withId(R.id.recycler))
            .perform(
                actionOnItemAtPosition<RecyclerView.ViewHolder>(1, click())
            )

        onView((withId(R.id.cv_pokemon_name)))
            .check(matches(hasDescendant(withText("Name"))))
    }
}