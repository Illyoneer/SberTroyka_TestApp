package ru.glushko.sbertroyka_testapp.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.glushko.sbertroyka_testapp.data.api.DataAPIService
import ru.glushko.sbertroyka_testapp.data.repository.DataRepositoryImpl
import ru.glushko.sbertroyka_testapp.domain.repository.DataRepository

val dataModule = module {
    single<DataRepository> {
        DataRepositoryImpl(_dataAPI = get())
    }

    factory {
        provideHttpLoggingInterceptor()
    }

    factory {
        provideOkHttpClient(get())
    }

    single {
        provideRetrofit(get())
    }

    factory {
        provideDataAPIService(get())
    }
}

fun provideDataAPIService(retrofit: Retrofit): DataAPIService =
    retrofit.create(DataAPIService::class.java)

fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
    return okhttp3.OkHttpClient.Builder()
        .addNetworkInterceptor(interceptor)
        .build()
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://devapp.mosmetro.ru/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}

fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return httpLoggingInterceptor
}