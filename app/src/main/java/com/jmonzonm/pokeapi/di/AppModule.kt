package com.jmonzonm.pokeapi.di

import android.app.Application
import androidx.room.Room
import com.jmonzonm.data.repositoriy.datasource.PokemonLocalDataSource
import com.jmonzonm.data.repositoriy.datasource.PokemonRemoteDataSource
import com.jmonzonm.pokeapi.data.database.PokemonDao
import com.jmonzonm.pokeapi.data.database.PokemonDatabase
import com.jmonzonm.pokeapi.data.database.PokemonRoomDataSource
import com.jmonzonm.pokeapi.data.network.datasource.PokemonServerDataSource
import com.jmonzonm.pokeapi.data.network.services.PokeApiService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    @PokeApiUrl
    fun providePokeApiUrl(): String = "https://pokeapi.co/api/v2/"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = HttpLoggingInterceptor().run {
        level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder().addInterceptor(this).build()
    }

    @Provides
    @Singleton
    fun providePokeApiService(
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

    @Provides
    @Singleton
    fun provideDatabase(application: Application) = Room.databaseBuilder(
        application,
        PokemonDatabase::class.java,
        "pokemon-db"
    ).build()


    @Provides
    @Singleton
    fun providePokemonDao(db: PokemonDatabase): PokemonDao {
        return db.pokemonDao()
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class AppDataModule {
    @Binds
    abstract fun bindRemoteDataSource(remoteDataSource: PokemonServerDataSource): PokemonRemoteDataSource

    @Binds
    abstract fun bindLocalDataSource(pokemonRoomDataSource: PokemonRoomDataSource): PokemonLocalDataSource
}