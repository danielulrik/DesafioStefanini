package br.com.ulrik.stefanini_desafio.database;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by Daniel Ulrik on 04/03/2018.
 */
@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
public interface AppDatabase {
    public static final String NAME = "AppDatabase";
    public static final int VERSION = 1;
}
