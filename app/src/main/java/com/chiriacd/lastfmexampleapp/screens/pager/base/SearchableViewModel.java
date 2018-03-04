package com.chiriacd.lastfmexampleapp.screens.pager.base;
import android.arch.lifecycle.ViewModel;

public abstract class SearchableViewModel extends ViewModel {
    public abstract void search(String s);
}
