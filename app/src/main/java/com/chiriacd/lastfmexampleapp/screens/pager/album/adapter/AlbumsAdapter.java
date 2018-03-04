package com.chiriacd.lastfmexampleapp.screens.pager.album.adapter;

import com.chiriacd.lastfmexampleapp.R;
import com.chiriacd.lastfmexampleapp.screens.pager.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class AlbumsAdapter extends BaseAdapter {

    private List<AlbumItemViewModel> albums;

    @Inject public AlbumsAdapter () {
        albums = new ArrayList<>();
    }

    @Override
    protected Object getObjForPosition(int position) {
        return albums.get(position);
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return R.layout.albums_item;
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public void clearAlbums() {
        albums.clear();
    }

    public void addAlbums(List<AlbumItemViewModel> albums) {
        this.albums.addAll(albums);
        notifyDataSetChanged();
    }
}
