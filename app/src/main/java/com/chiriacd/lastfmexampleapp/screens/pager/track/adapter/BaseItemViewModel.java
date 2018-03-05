package com.chiriacd.lastfmexampleapp.screens.pager.track.adapter;

import android.arch.lifecycle.ViewModel;

import com.chiriacd.lastfmexampleapp.screens.pager.ItemClickListener;

import io.reactivex.annotations.Nullable;

public abstract class BaseItemViewModel extends ViewModel {

    private final ItemClickListener listener;

    public BaseItemViewModel(@Nullable ItemClickListener listener) {
        this.listener = listener;
    }

    public abstract String getItemClickedUrl();

    public void itemClicked() {
        if (listener != null) {
            listener.onItemWithUrl(getItemClickedUrl());
        }
    }
}
