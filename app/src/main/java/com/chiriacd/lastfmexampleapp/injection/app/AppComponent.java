package com.chiriacd.lastfmexampleapp.injection.app;

import android.app.Application;

import com.chiriacd.lastfmexampleapp.injection.api.LastFmApiModule;
import com.chiriacd.lastfmexampleapp.injection.app.modules.AppModule;
import com.chiriacd.lastfmexampleapp.injection.builder.ActivityBuilder;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;


@Component(modules = {AndroidSupportInjectionModule.class, ActivityBuilder.class, LastFmApiModule.class,
        AppModule.class})
@Singleton
public interface AppComponent extends AndroidInjector<MyApp> {
    void inject(MyApp application);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
