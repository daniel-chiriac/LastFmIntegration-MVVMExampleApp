package com.chiriacd.lastfmexampleapp.screens.pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.chiriacd.lastfmexampleapp.screens.MasterViewModel;
import com.chiriacd.lastfmexampleapp.screens.pager.album.AlbumFragment;
import com.chiriacd.lastfmexampleapp.screens.pager.album.AlbumFragmentViewModel;
import com.chiriacd.lastfmexampleapp.utils.RxUtils;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private static final int FRAGMENT_COUNT = 3;
    private static final int ALBUM_FRAGMENT = 0;
    private static final int ARTIST_FRAGMENT = 1;
    private static final int TRACK_FRAGMENT = 2;


    @Inject
    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
//        this.masterViewModel = masterViewModel;
    }

//    private void registerObservables() {
//        RxUtils.toObservable(masterViewModel.getSearchTerm())
//                .debounce(1, TimeUnit.SECONDS)
//                .skip(1)
//                .doOnNext(new Consumer<String>() {
//                    @Override
//                    public void accept(String s) throws Exception {
//
//                    }
//                })
//                .subscribe();
//    }

    @Override
    public Fragment getItem(int position) {
        AlbumFragment albumFragment = AlbumFragment.Companion.newInstance();
        switch (position) {
            case ALBUM_FRAGMENT:

                return albumFragment;
        }
        return AlbumFragment.Companion.newInstance();
    }

    @Override
    public String getPageTitle(int position) {
        switch (position) {
            case ALBUM_FRAGMENT: return "Album";
            case ARTIST_FRAGMENT: return "Artist";
            case TRACK_FRAGMENT: return "Track";
        }
        return "";
    }

    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }
}
