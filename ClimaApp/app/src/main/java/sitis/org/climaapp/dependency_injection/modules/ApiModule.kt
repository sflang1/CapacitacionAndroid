package sitis.org.climaapp.dependency_injection.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import sitis.org.climaapp.R
import sitis.org.climaapp.data.http.ClimaApi
import javax.inject.Singleton

@Module
class ApiModule{

    @Singleton
    @Provides
    fun provideRetrofit(context: Context):Retrofit = Retrofit.Builder()
                .baseUrl(context.getString(R.string.api_base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

    @Singleton
    @Provides
    fun provideClimaHttpClient(retrofit: Retrofit) : ClimaApi = retrofit.create(ClimaApi::class.java)
}