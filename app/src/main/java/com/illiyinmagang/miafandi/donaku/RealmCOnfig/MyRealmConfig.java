package com.illiyinmagang.miafandi.donaku.RealmCOnfig;

import android.app.Application;

import com.facebook.stetho.Stetho;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by user on 20/10/2018.
 */

public class MyRealmConfig extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .name("Vrteraphy_beta2")
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
