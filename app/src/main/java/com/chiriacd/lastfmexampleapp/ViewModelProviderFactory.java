package com.chiriacd.lastfmexampleapp;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import java.util.Map;

import javax.inject.Inject;

public class ViewModelProviderFactory implements ViewModelProvider.Factory {

    private Map<Class<ViewModel>, ViewModel> viewModels;

    @Inject
    public ViewModelProviderFactory(Map<Class<ViewModel>, ViewModel> viewModels) {
        this.viewModels = viewModels;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        ViewModel requestedViewModel = viewModels.get(modelClass);
        if (requestedViewModel!=null && modelClass.isAssignableFrom(requestedViewModel.getClass())){
            return (T) requestedViewModel;
        }
        throw new IllegalArgumentException("Unknown class");
    }
}
