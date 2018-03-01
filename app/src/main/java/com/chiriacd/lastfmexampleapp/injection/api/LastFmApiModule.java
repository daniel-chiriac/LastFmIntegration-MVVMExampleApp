package com.chiriacd.lastfmexampleapp.injection.api;

import android.content.Context;

import com.chiriacd.lastfmexampleapp.api.LastFmService;
import com.chiriacd.lastfmexampleapp.BuildConfig;
import com.chiriacd.lastfmexampleapp.injection.ApiKey;
import com.chiriacd.lastfmexampleapp.injection.ApiUrl;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class LastFmApiModule {

    private final int cacheSize = 10 * 1024 * 1024; // 10 MB

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient httpClient, @ApiUrl String apiUrl) {
        return new Retrofit.Builder()
                .baseUrl(apiUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .build();
    }

    @Provides
    @Singleton
    OkHttpClient httpClient(Interceptor interceptor, Cache cache) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(interceptor);
        HttpLoggingInterceptor httpLogger = new HttpLoggingInterceptor();
        httpLogger.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(httpLogger);
        httpClient.cache(cache);
        return httpClient.build();
    }

    @Provides
    @ApiKey
    public String provideApiKey() {
        return BuildConfig.api_key;
    }

    @Provides
    @ApiUrl
    public String provideApiUrl() {
        return BuildConfig.api_url;
    }

    @Provides
    @Singleton
    Cache cache(Context context) {
        return new Cache(context.getCacheDir(), cacheSize);
    }

    @Provides
    @Singleton
    Interceptor interceptor(@ApiKey String apiKey) {
        return chain -> {
            Request original = chain.request();
            HttpUrl originalHttpUrl = original.url();

            HttpUrl url = originalHttpUrl.newBuilder()
                    .addQueryParameter("api_key", apiKey)
                    .addQueryParameter("format", "json")
                    .build();

            Request request = original.newBuilder()
                    .url(url)
                    .build();

            return chain.proceed(request);
        };
    }

    @Provides
    @Singleton
    public LastFmService provideLastFmService(Retrofit retrofit) {
        return retrofit.create(LastFmService.class);
    }
}
