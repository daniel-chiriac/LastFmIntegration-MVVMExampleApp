package com.chiriacd.lastfmexampleapp.screens.pager;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import com.chiriacd.lastfmexampleapp.screens.pager.album.AlbumFragmentViewModel;

public class ViewPagerViewModel extends ViewModel {

    ObservableField<String> searchTerm = new ObservableField<>();

    private AlbumFragmentViewModel albumViewModel;

    public ViewPagerViewModel(AlbumFragmentViewModel albumViewModel) {
//        this.albumViewModel = albumViewModel
    }
}
