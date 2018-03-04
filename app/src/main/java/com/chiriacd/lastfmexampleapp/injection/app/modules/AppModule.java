package com.chiriacd.lastfmexampleapp.injection.app.modules;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;


import com.chiriacd.lastfmexampleapp.ViewModelProviderFactory;
import com.chiriacd.lastfmexampleapp.injection.app.MyApp;
import com.chiriacd.lastfmexampleapp.screens.qualifier.MasterVM;
import com.chiriacd.lastfmexampleapp.utils.AppSchedulers;
import com.chiriacd.lastfmexampleapp.utils.SchedulersProvider;

import java.util.Map;

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


    @Provides
    ViewModelProvider.Factory provideAlbumFragmentViewModelProviderFactory(@MasterVM Map<Class<ViewModel>, ViewModel> viewModels) {
        return new ViewModelProviderFactory(viewModels);
    }
}
