package com.example.todoproject;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class TodoViewModel extends ViewModel {

    private int todoIndex = 0;

    private TodoCreate selectedTodo = new TodoCreate();

    private TodoRepository todoRepository = TodoRepository.newInstance();

    public int getTodoIndex() {
        return todoIndex;
    }

    public void setTodoIndex(int todoIndex) {
        this.todoIndex = todoIndex;
        selectedTodo = todoRepository.getTodo(todoIndex);
    }

    public ArrayList getTodoList() { return todoRepository.getTodoList(); }

    public int size() { return todoRepository.size(); }

    public TodoCreate getTodo(int todoIndex) { return todoRepository.getTodo(todoIndex); }

    public void setTodo(int todoIndex, TodoCreate todo) { todoRepository.setTodo(todoIndex, todo); }
}
