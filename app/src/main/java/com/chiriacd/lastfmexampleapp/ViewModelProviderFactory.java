package com.chiriacd.lastfmexampleapp;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import javax.inject.Inject;

public class ViewModelProviderFactory implements ViewModelProvider.Factory {

    private ViewModel viewModel;

    @Inject
    public ViewModelProviderFactory(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(viewModel.getClass())){
            return (T) viewModel;
        }
        throw new IllegalArgumentException("Unknown class");
    }
}
