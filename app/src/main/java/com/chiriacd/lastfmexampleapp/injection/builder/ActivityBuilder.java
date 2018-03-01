package com.chiriacd.lastfmexampleapp.injection.builder;

import com.chiriacd.lastfmexampleapp.screens.MasterActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by DanielC on 28/02/2018.
 */

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector()
    abstract MasterActivity bindMasterActivity();
}
