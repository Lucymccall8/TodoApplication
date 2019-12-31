package com.example.todoproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewFrag extends Fragment {

    private RecyclerView todoRV;
    RVAdapter RVAdapter;
    private TodoViewModel todoViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        todoViewModel = ViewModelProviders.of(getActivity()).get(TodoViewModel.class);

        todoRV = (RecyclerView) view.findViewById(R.id.todo_recycler_view);
        todoRV.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    //create todoholder method for adapter

    public class TodoHolder extends RecyclerView.ViewHolder {

        private TodoCreate newTodo = new TodoCreate();

        public TodoHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.fragment_recycler_view, parent, false));
        }

        public void bind(TodoCreate todo) {
            newTodo = todo;
        }
    }

        public class RVAdapter extends RecyclerView.Adapter<RecyclerViewFrag.TodoHolder> {

            private ArrayList<TodoCreate> todoS;

            public RVAdapter(ArrayList<TodoCreate> todos) {
                todos = todoS;
            }

            @NonNull
            @Override
            public RecyclerViewFrag.TodoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater layoutInflater = LayoutInflater.from(getActivity());


                return new TodoHolder(layoutInflater, parent);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerViewFrag.TodoHolder holder, int position) {
            }

            @Override
            public int getItemCount() {
                return todoS.size();
            }
        }
    }
