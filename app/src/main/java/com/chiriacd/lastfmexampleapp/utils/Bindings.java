package com.chiriacd.lastfmexampleapp.utils;

import android.databinding.BindingAdapter;
import android.databinding.ObservableList;
import android.support.v7.widget.RecyclerView;

import com.chiriacd.lastfmexampleapp.screens.album.AlbumItemViewModel;
import com.chiriacd.lastfmexampleapp.screens.album.adapter.AlbumsAdapter;

public final class Bindings {

    private Bindings() {
        //no init
    }

    @BindingAdapter("albums_adapter")
    public static void updateAlbums(RecyclerView recyclerView, ObservableList<AlbumItemViewModel> albums) {
        AlbumsAdapter adapter = (AlbumsAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearAlbums();
            adapter.addAlbums(albums);
        }
    }
}
