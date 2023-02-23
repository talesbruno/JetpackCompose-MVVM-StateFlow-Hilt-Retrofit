package co.talesbruno.consumeapifreetogame.di

import co.talesbruno.consumeapifreetogame.data.api.FreeToGameApi
import co.talesbruno.consumeapifreetogame.data.repository.GamesRepositoryImpl
import co.talesbruno.consumeapifreetogame.domain.repository.GamesRepository
import co.talesbruno.consumeapifreetogame.domain.useCase.GetAllGamesUseCase
import co.talesbruno.consumeapifreetogame.domain.useCase.GetGameByIdUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideCurrencyService(retrofit: Retrofit): FreeToGameApi =
        retrofit.create(FreeToGameApi::class.java)

    @Provides
    @Singleton
    fun providesFreeToGameApi(gsonConverterFactory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.freetogame.com/api/")
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun providesGamesRepository(freeToGameApi: FreeToGameApi): GamesRepository =
        GamesRepositoryImpl(freeToGameApi)

    @Provides
    fun provideGetAllGamesUseCase(gamesRepository: GamesRepository) =
        GetAllGamesUseCase(gamesRepository)

    @Provides
    fun provideGameByIdUseCase(gamesRepository: GamesRepository) =
        GetGameByIdUseCase(gamesRepository)

}