package com.example.cose_project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class EpisodeSQLiteHelper extends SQLiteOpenHelper {

    private	static final int DATABASE_VERSION =	1;

    private	static final String	DATABASE_CREATE_2	= "create table	episodes"
            + "(episode_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
            + " episode_comic_ID INTEGER NOT NULL,"
            + " episode_title TEXT NOT NULL,"
            + " episode_tmb TEXT NOT NULL,"
            + " image_path TEXT NOT NULL);";

    public EpisodeSQLiteHelper(Context context) {
        super(context, "comicsdatabase.db",null, DATABASE_VERSION);
    }

    @Override
    public void	onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE_2);
    }

    @Override
    public void	onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(EpisodeSQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + "	to	"
                        + newVersion + ",which will	destroy	all	old	data");

        db.execSQL("DROP TABLE IF EXISTS episodes");
        onCreate(db);
    }
}
