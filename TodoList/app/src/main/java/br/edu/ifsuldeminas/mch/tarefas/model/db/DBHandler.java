package br.edu.ifsuldeminas.mch.tarefas.model.db;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "tarefas.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_TASKS_CREATE_SQL =
            " CREATE TABLE " +
            " IF NOT EXISTS tasks ( " +
            " id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " description text, " +
            " active varchar(1)); ";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_TASKS_CREATE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // não vamos atualizar
    }
}
