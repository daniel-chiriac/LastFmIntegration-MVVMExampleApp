package com.chiriacd.lastfmexampleapp.utils.qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by DanielC on 04/03/2018.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface MasterVM {
}
