package com.chiriacd.lastfmexampleapp.utils;

import android.databinding.BindingAdapter;
import android.databinding.ObservableList;
import android.support.v7.widget.RecyclerView;

import com.chiriacd.lastfmexampleapp.screens.pager.album.adapter.AlbumItemViewModel;
import com.chiriacd.lastfmexampleapp.screens.pager.album.adapter.AlbumsAdapter;

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

//    @InverseBindingAdapter(attribute = "android:text", event = "android:textAttrChanged")
//    public static void updateAlbums(EditText editText, ObservableField<String> term) {
//        Log.i("4Dan", "text_change " + term.get() + " " + editText.toString());
//    }
}
