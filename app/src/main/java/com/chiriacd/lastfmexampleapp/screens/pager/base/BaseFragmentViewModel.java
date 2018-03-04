package com.chiriacd.lastfmexampleapp.screens.pager.base;

import com.chiriacd.lastfmexampleapp.api.LastFmService;
import com.chiriacd.lastfmexampleapp.utils.SchedulersProvider;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseFragmentViewModel extends SearchableViewModel {

    private final CompositeDisposable compositeDisposable;

    private final LastFmService dataManager;
    private final SchedulersProvider schedulers;

    public BaseFragmentViewModel(LastFmService dataManager, SchedulersProvider schedulersProvider) {
        this.dataManager = dataManager;
        this.schedulers = schedulersProvider;
        this.compositeDisposable = new CompositeDisposable();
    }

    public LastFmService getLastFmService() {
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
