package com.chiriacd.lastfmexampleapp.injection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by DanielC on 28/02/2018.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiKey {

}
