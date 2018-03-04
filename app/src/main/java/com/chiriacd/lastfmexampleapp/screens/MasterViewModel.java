package com.chiriacd.lastfmexampleapp.screens;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.util.Log;

import com.chiriacd.lastfmexampleapp.utils.RxUtils;
import com.chiriacd.lastfmexampleapp.utils.SchedulersProvider;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MasterViewModel extends ViewModel {

    private final ObservableField<String> searchTerm = new ObservableField<>();

    private final MutableLiveData<String> searchTermLiveData = new MutableLiveData<>();

    @Inject
    MasterViewModel() {
        searchTerm.addOnPropertyChangedCallback(new android.databinding.Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(android.databinding.Observable sender, int propertyId) {
                Log.i("4dan", "Schanged: " + searchTerm.get());

            }
        });
        RxUtils.toObservable(searchTerm)
                .debounce(1, TimeUnit.SECONDS)
                .onErrorResumeNext(throwable -> {
                    return Observable.just(throwable.getMessage());
                })
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(s -> {
                    searchTermLiveData.setValue(s);
                    Log.i("4dan", "S: " + s);
                })
                .subscribe();
    }

    public ObservableField<String> getSearchTerm() {
        return searchTerm;
    }

    public MutableLiveData<String> getSearchTermLiveData() {
        return searchTermLiveData;
    }
}
