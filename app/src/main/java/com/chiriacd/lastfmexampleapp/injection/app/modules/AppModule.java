package com.chiriacd.lastfmexampleapp.injection.app.modules;

import android.app.Application;
import android.content.Context;


import com.chiriacd.lastfmexampleapp.utils.AppSchedulers;
import com.chiriacd.lastfmexampleapp.utils.SchedulersProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;


@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides SchedulersProvider provideSchedulers() {
        return new AppSchedulers();
    }

    @Provides CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }
}
