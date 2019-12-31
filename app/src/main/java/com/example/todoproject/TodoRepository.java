package com.example.todoproject;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;

public class TodoRepository {

    private static TodoRepository TodoRepo;

    // create arraylist, off the todo java class
    private ArrayList<TodoCreate> todoList;

    public static TodoRepository newInstance() {
        if (TodoRepo == null) {
            TodoRepo = new TodoRepository();
        }

        // return the created todorepo
        return TodoRepo;
    }

    private TodoRepository() {
        todoList = new ArrayList<>();
        initiateTest();
    }

    private void initiateTest() {
        for (int i=0; i < 3; i++) {
            TodoCreate todo = new TodoCreate();
            todo.setID(i);
            todo.setTitle("Title " + i);
            todo.setDetail("Detail for task " + todo.getTitle());
            todo.setDate(new Date());
            todo.setIsComplete(false);
            todo.setIsPending(false);

            todoList.add(todo);
        }
    }

    public ArrayList getTodoList() { return this.todoList; }

    public int size() { return todoList.size(); }

    public TodoCreate getTodo(int todoIndex) { return this.todoList.get(todoIndex); }

    public TodoCreate setTodo(int todoIndex, TodoCreate todo)  { return this.todoList.set (todoIndex, todo); }

    public void addTodo (TodoCreate todo) { todoList.add(todo); }
}
