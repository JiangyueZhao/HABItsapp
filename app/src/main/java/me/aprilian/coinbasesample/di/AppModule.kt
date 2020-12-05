
package me.aprilian.coinbasesample.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.aprilian.coinbasesample.BuildConfig
import me.aprilian.coinbasesample.api.BasicAuthInterceptor
import me.aprilian.coinbasesample.api.CoinApiService
import me.aprilian.coinbasesample.repository.ApiHelper
import me.aprilian.coinbasesample.repository.ApiHelperImpl
import me.aprilian.coinbasesample.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module