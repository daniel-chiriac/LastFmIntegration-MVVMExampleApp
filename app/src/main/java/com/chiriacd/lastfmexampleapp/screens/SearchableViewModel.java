package com.chiriacd.lastfmexampleapp.screens;


import android.arch.lifecycle.ViewModel;

public abstract class SearchableViewModel extends ViewModel {
    public abstract void search(String term);
}
