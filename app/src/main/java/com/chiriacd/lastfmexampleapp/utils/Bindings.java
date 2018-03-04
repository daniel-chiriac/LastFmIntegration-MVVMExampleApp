package com.chiriacd.lastfmexampleapp.utils;

import android.databinding.BindingAdapter;
import android.databinding.ObservableList;
import android.support.v7.widget.RecyclerView;

import com.chiriacd.lastfmexampleapp.screens.pager.album.adapter.AlbumItemViewModel;
import com.chiriacd.lastfmexampleapp.screens.pager.album.adapter.AlbumsAdapter;
import com.chiriacd.lastfmexampleapp.screens.pager.artist.adapter.ArtistItemViewModel;
import com.chiriacd.lastfmexampleapp.screens.pager.artist.adapter.ArtistsAdapter;
import com.chiriacd.lastfmexampleapp.screens.pager.track.adapter.TrackAdapter;
import com.chiriacd.lastfmexampleapp.screens.pager.track.adapter.TrackItemViewModel;

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

    @BindingAdapter("artists_adapter")
    public static void updateArtists(RecyclerView recyclerView, ObservableList<ArtistItemViewModel> artists) {
        ArtistsAdapter adapter = (ArtistsAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearArtists();
            adapter.addArtists(artists);
        }
    }

    @BindingAdapter("tracks_adapter")
    public static void updateTracks(RecyclerView recyclerView, ObservableList<TrackItemViewModel> tracks) {
        TrackAdapter adapter = (TrackAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearTracks();
            adapter.addTracks(tracks);
        }
    }

//    @InverseBindingAdapter(attribute = "android:text", event = "android:textAttrChanged")
//    public static void updateAlbums(EditText editText, ObservableField<String> term) {
//        Log.i("4Dan", "text_change " + term.get() + " " + editText.toString());
//    }
}
