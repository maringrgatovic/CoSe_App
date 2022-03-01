package com.example.cose_project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AuthorsSQLiteHelper extends SQLiteOpenHelper {

    private	static final int DATABASE_VERSION =	1;

    private	static final String	DATABASE_CREATE	= "create table	authors"
            + "(autor_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
            + " author_name TEXT NOT NULL);";

    public AuthorsSQLiteHelper(Context context) {
        super(context, "comicsdatabase.db",null, DATABASE_VERSION);
    }

    @Override
    public void	onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void	onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(AuthorsSQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + "	to	"
                        + newVersion + ",which will	destroy	all	old	data");

        db.execSQL("DROP TABLE IF EXISTS authors");
        onCreate(db);
    }
}
