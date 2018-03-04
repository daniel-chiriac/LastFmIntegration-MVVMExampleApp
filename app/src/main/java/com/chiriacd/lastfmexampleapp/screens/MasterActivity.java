package com.chiriacd.lastfmexampleapp.screens;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.chiriacd.lastfmexampleapp.BR;
import com.chiriacd.lastfmexampleapp.R;
import com.chiriacd.lastfmexampleapp.databinding.MasterActivityBinding;
import com.chiriacd.lastfmexampleapp.screens.pager.MyFragmentPagerAdapter;
import com.chiriacd.lastfmexampleapp.screens.qualifier.MasterVM;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MasterActivity extends DaggerAppCompatActivity  {

    @Inject @MasterVM ViewModelProvider.Factory viewModelFactory;
    private MasterActivityBinding viewDataBinding;

    @Inject MyFragmentPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MasterViewModel masterViewModel = ViewModelProviders.of(this, viewModelFactory).get(MasterViewModel.class);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.master_activity);
        viewDataBinding.setVariable(BR.viewModel, masterViewModel);
        viewDataBinding.executePendingBindings();
        viewDataBinding.viewpager.setAdapter(pagerAdapter);
    }
}
