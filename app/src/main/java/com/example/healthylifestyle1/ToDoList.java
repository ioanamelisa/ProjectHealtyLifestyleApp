package com.example.healthylifestyle1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ToDoList extends AppCompatActivity {

    private EditText todoEditText;
    private ListView todoListView;
    private ArrayList<String> todoItems;
    private ArrayAdapter<String> todoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_list);

        todoEditText = findViewById(R.id.todoEditText);
        todoListView = findViewById(R.id.todoListView);

        todoItems = new ArrayList<>();
        todoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, todoItems);
        todoListView.setAdapter(todoAdapter);

        todoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = todoItems.get(position);
                item = "*" + item; // marked as done
                todoItems.set(position, item);

                //sorting the items based on the nr of checks
                Collections.sort(todoItems, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        int count1 = countChecks(o1);
                        int count2 = countChecks(o2);
                        return Integer.compare(count1, count2);
                    }

                    private int countChecks(String item) {
                        //count the nr of checks
                        int count = 0;
                        for (char c : item.toCharArray()) {
                            if (c == '*') {
                                count++;
                            }
                        }
                        return count;
                    }
                });
                todoAdapter.notifyDataSetChanged();
            }
        });

        todoListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                todoItems.remove(position);
                todoAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    public void addTodoItem(View view) {
        String itemText = todoEditText.getText().toString().trim();
        if (!itemText.isEmpty()) {
            todoItems.add(itemText);

            //sort the items based on nr of checks
            Collections.sort(todoItems, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int count1 = countChecks(o1);
                    int count2 = countChecks(o2);
                    return Integer.compare(count1, count2);
                }

                private int countChecks(String item) {
                    // Count the number of checks (number of "*")
                    int count = 0;
                    for (char c : item.toCharArray()) {
                        if (c == '*') {
                            count++;
                        }
                    }
                    return count;
                }
            });

            todoAdapter.notifyDataSetChanged();
            todoEditText.setText("");
        }
    }
}