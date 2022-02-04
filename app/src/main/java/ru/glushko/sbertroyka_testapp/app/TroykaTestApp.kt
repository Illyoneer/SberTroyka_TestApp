package ru.glushko.sbertroyka_testapp.app

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.glushko.sbertroyka_testapp.data.api.DataAPIService
import ru.glushko.sbertroyka_testapp.di.dataModule
import ru.glushko.sbertroyka_testapp.di.domainModule
import ru.glushko.sbertroyka_testapp.di.presentationModule

class TroykaTestApp  : Application() {

    lateinit var dataAPI: DataAPIService


    companion object {
        var instance = TroykaTestApp()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        startKoin {
            androidContext(this@TroykaTestApp)
            modules(listOf(presentationModule, domainModule, dataModule))
        }
        Fresco.initialize(this)
        configureRetrofit()
    }

    private fun configureRetrofit(){
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY


        val okHttpClient = okhttp3.OkHttpClient.Builder()
            .addNetworkInterceptor(interceptor = httpLoggingInterceptor)
            .build()


        val retrofit = Retrofit.Builder()
            .baseUrl("https://devapp.mosmetro.ru/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        dataAPI = retrofit.create(DataAPIService::class.java)
    }
}