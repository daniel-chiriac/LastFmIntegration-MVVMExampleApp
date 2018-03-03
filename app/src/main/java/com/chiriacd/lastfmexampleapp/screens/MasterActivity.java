package com.chiriacd.lastfmexampleapp.screens;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.chiriacd.lastfmexampleapp.BR;
import com.chiriacd.lastfmexampleapp.R;
import com.chiriacd.lastfmexampleapp.databinding.MasterActivityBinding;
import com.chiriacd.lastfmexampleapp.screens.pager.MyFragmentPagerAdapter;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MasterActivity extends DaggerAppCompatActivity  {

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
}
