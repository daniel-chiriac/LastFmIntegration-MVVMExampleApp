package com.chiriacd.lastfmexampleapp.utils;

import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Cancellable;

public class RxUtils {

    public static <T> Observable<T> toObservable(@NonNull final ObservableField<T> observableField) {
        return Observable.create(new ObservableOnSubscribe<T>() {

            @Override
            public void subscribe(ObservableEmitter<T> emitter) throws Exception {
                android.databinding.Observable.OnPropertyChangedCallback callback = new android.databinding.Observable.OnPropertyChangedCallback() {
                    @Override
                    public void onPropertyChanged(android.databinding.Observable sender, int propertyId) {
                        emitter.onNext(observableField.get());
                    }
                };
                observableField.addOnPropertyChangedCallback(callback);
                emitter.setCancellable(new Cancellable() {
                    @Override
                    public void cancel() throws Exception {
                        observableField.removeOnPropertyChangedCallback(callback);
                    }
                });
            }
        });
    }
}
