package com.chiriacd.lastfmexampleapp.screens;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import com.chiriacd.lastfmexampleapp.utils.RxUtils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class MasterViewModel extends BaseObservable {

    private final ObservableField<String> searchTerm = new ObservableField<>();

    MasterViewModel() {
//        Observable
//        RxUtils.toObservable(searchTerm)
//                .debounce(1, TimeUnit.SECONDS)
//                .subscribe(new Consumer<String>() {
//                    @Override
//                    public void accept(String s) throws Exception {
//
//                    }
//                });
    }
    public ObservableField<String> getSearchTerm() {
        return searchTerm;
    }
}
