package br.edu.ifsuldeminas.mch.tarefas.model.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "tarefas.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_TASK = " CREATE TABLE IF NOT EXISTS " +
            " tasks (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " desc TEXT, " +
            " act VARCHAR(1));";

    private DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_TASK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // não iremos trabalhar com atualização
    }
}
