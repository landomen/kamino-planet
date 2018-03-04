package com.landomen.kaminoplanet.data.source.remote

import com.landomen.kaminoplanet.BuildConfig
import com.landomen.kaminoplanet.data.source.remote.planet.service.PlanetService
import com.landomen.kaminoplanet.data.source.remote.resident.service.ResidentService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Domen Lanišnik on 03/03/2018.
 * domen.lanisnik@gmail.com
 */
@Module
class NetModule {

    @Provides
    @Singleton
    internal fun providePlanetService(retrofit: Retrofit): PlanetService {
        return retrofit.create(PlanetService::class.java)
    }

    @Provides
    @Singleton
    internal fun provideResidentService(retrofit: Retrofit): ResidentService {
        return retrofit.create(ResidentService::class.java)
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(@Named("serverBaseUrl") serverUrl: String,
                                 okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(serverUrl)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    @Named("serverBaseUrl")
    internal fun provideServerBaseUrl(): String {
        return BuildConfig.SERVER_BASE_URL
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build()
    }

    @Provides
    @Singleton
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

}