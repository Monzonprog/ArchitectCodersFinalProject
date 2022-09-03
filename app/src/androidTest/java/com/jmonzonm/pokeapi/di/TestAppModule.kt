package com.jmonzonm.pokeapi.di

import android.app.Application
import androidx.room.Room
import com.jmonzonm.pokeapi.data.database.PokemonDatabase
import com.jmonzonm.pokeapi.data.network.services.PokeApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [AppModule::class]
)
object TestAppModule {


    @Provides
    @Singleton
    fun provideDatabase(app: Application) = Room.inMemoryDatabaseBuilder(
        app,
        PokemonDatabase::class.java
    ).build()

    @Provides
    @Singleton
    fun providePokemonDao(db: PokemonDatabase) = db.pokemonDao()

    @Provides
    @Singleton
    @PokeApiUrl
    fun provideApiUrl(): String = "http://localhost:5050"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = HttpLoggingInterceptor().run {
        level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder().addInterceptor(this).build()
    }

    @Provides
    @Singleton
    fun provideRemoteService(
        @PokeApiUrl apiUrl: String,
        okHttpClient: OkHttpClient
    ): PokeApiService {
        return Retrofit.Builder()
            .baseUrl(apiUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
}