package com.chiriacd.lastfmexampleapp.screens;

import android.arch.lifecycle.ViewModel;

import com.chiriacd.lastfmexampleapp.data.DataManager;
import com.chiriacd.lastfmexampleapp.utils.SchedulersProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel extends ViewModel {

    @Inject CompositeDisposable compositeDisposable;

    private DataManager dataManager;
    private SchedulersProvider schedulers;

    public BaseViewModel (DataManager dataManager, SchedulersProvider schedulersProvider) {
        this.dataManager = dataManager;
        this.schedulers = schedulersProvider;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    public SchedulersProvider getSchedulers() {
        return schedulers;
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}
