package com.chiriacd.lastfmexampleapp.screens;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.chiriacd.lastfmexampleapp.BR;
import com.chiriacd.lastfmexampleapp.R;
import com.chiriacd.lastfmexampleapp.api.LastFmService;
import com.chiriacd.lastfmexampleapp.api.results.ArtistResult;
import com.chiriacd.lastfmexampleapp.databinding.MasterActivityBinding;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MasterActivity extends DaggerAppCompatActivity  {

    @Inject LastFmService lastFmService;
    @Inject MasterViewModel viewModel;

    private MasterActivityBinding viewDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.master_activity);
        viewDataBinding.setVariable(BR.viewModel, viewModel);
        viewDataBinding.executePendingBindings();
        viewDataBinding.viewpager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        lastFmService.searchByArtist("valahia")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess(new Consumer<ArtistResult>() {
                    @Override
                    public void accept(ArtistResult artistSearchArtistResult) throws Exception {
                        Log.i("4Dan", artistSearchArtistResult.toString());
                    }
                })
                .subscribe();
    }
}
