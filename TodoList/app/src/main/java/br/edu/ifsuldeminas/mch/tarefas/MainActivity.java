package br.edu.ifsuldeminas.mch.tarefas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import br.edu.ifsuldeminas.mch.tarefas.model.Task;
import br.edu.ifsuldeminas.mch.tarefas.model.db.TaskDAO;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private ListView todoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoList = findViewById(R.id.todo_list);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentForm = new Intent(MainActivity.this, FormActivity.class);
                startActivity(intentForm);
            }
        });

        todoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Task task = (Task) todoList.getItemAtPosition(position);

                Intent intent = new Intent(MainActivity.this, FormActivity.class);
                intent.putExtra("tarefa", task);

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        updateTasks();
    }

    private void updateTasks() {
        TaskDAO dao = new TaskDAO(this);
        List<Task> taskList = dao.loadTasks();

        ArrayAdapter<Task> arrayAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);

        todoList.setAdapter(arrayAdapter);
    }
}