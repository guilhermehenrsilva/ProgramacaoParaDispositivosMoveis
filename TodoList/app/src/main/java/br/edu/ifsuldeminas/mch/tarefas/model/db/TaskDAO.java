package br.edu.ifsuldeminas.mch.tarefas.model.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsuldeminas.mch.tarefas.model.Task;

public class TaskDAO extends DAO {

    public TaskDAO(Context context) {
        super(context);
    }

    public boolean save(Task task){
        SQLiteDatabase dataBase = openToWrite();

        ContentValues contentValues = new ContentValues();
        contentValues.put("description", task.getDescription());
        contentValues.put("active", task.isActive() ? "1" : "0");

        dataBase.insert("tasks", null, contentValues);

        dataBase.close();

        return true;
    }

    public List<Task> loadTasks() {
        SQLiteDatabase dataBase = openToRead();
        List<Task> tasks = new ArrayList<Task>();
        String sql = "SELECT * FROM tasks;";
        Cursor cursor = dataBase.rawQuery(sql, null);

        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String description = cursor.getString(
                    cursor.getColumnIndexOrThrow("description"));
            boolean active = Boolean.getBoolean(
                    cursor.getString(cursor.getColumnIndexOrThrow("active")));
            Task task = new Task(id, description);
            task.setActive(active);
            tasks.add(task);
        }
        cursor.close();
        dataBase.close();
        return tasks;
    }

    public void delete(Task task) {
        SQLiteDatabase dataBase = openToWrite();

        String[] params = {task.getId().toString()};
        dataBase.delete("tasks", "id = ?", params);

        dataBase.close();
    }

    public void update(Task task) {
        SQLiteDatabase dataBase = openToWrite();

        ContentValues contentValues = new ContentValues();
        contentValues.put("description", task.getDescription());
        contentValues.put("active", task.isActive() ? "1" : "0");

        String[] params = {task.getId().toString()};
        dataBase.update("tasks", contentValues, "id = ?", params);

        dataBase.close();
    }
}
