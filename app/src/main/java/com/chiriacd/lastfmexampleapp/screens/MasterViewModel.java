package com.chiriacd.lastfmexampleapp.screens;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.util.Log;

import com.chiriacd.lastfmexampleapp.utils.RxUtils;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

public class MasterViewModel extends ViewModel {

    private final ObservableField<String> searchTerm = new ObservableField<>();

    private final MutableLiveData<String> searchTermLiveData = new MutableLiveData<>();

    private CompositeDisposable compositeDisposable;

    @Inject MasterViewModel() {
        compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(RxUtils.toObservable(searchTerm)
                .debounce(1, TimeUnit.SECONDS)
                .distinctUntilChanged()
                .onErrorResumeNext(throwable -> {
                    return Observable.just(throwable.getMessage());
                })
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(s -> {
                    searchTermLiveData.setValue(s);
                    Log.i("4dan", "S: " + s);
                })
                .subscribe());

    }

    public ObservableField<String> getSearchTerm() {
        return searchTerm;
    }

    MutableLiveData<String> getSearchTermLiveData() {
        return searchTermLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}
