package com.example.todoproject;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FirstPageFragment extends Fragment {


    public static FirstPageFragment newInstance() { return new FirstPageFragment(); }

    private TodoViewModel todoViewModel;

    private TodoCreate newTodo = new TodoCreate();
    private int todoIndex = 0;
    private TextView TVTitle;
    private TextView TVDate;
    private Button BTNext;
    private Button BTPrev;
    private Button BTDetail;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first_page, container, false);

        todoViewModel = ViewModelProviders.of(getActivity()).get(TodoViewModel.class);
        todoIndex = todoViewModel.getTodoIndex();

        TVTitle = view.findViewById(R.id.TVTitle2);
        TVDate = view.findViewById(R.id.TVDate2);

        BTNext = (Button) view.findViewById(R.id.BTNext);
        BTNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                todoIndex = (todoIndex + 1) % todoViewModel.size();
                todoViewModel.setTodoIndex(todoIndex);
                newTodo = todoViewModel.getTodo(todoIndex);
                TVTitle.setText(newTodo.getTitle());
            }
        });

        BTPrev = (Button) view.findViewById(R.id.BTPrev2);
        BTPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (todoIndex == 0) {
                    todoIndex = todoViewModel.size() - 1;
                } else {
                    todoIndex -= 1;
                }

                todoViewModel.setTodoIndex(todoIndex);
                newTodo = todoViewModel.getTodo(todoIndex);
                TVTitle.setText(newTodo.getTitle());
            }
        });

        BTDetail = (Button) view.findViewById(R.id.BTDetail);
        BTDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                todoViewModel = ViewModelProviders.of(getActivity()).get(TodoViewModel.class);
                UpdateTodoDetailFrag todoDetailFragment = UpdateTodoDetailFrag.newInstance();

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.FContainer, todoDetailFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        todoViewModel = ViewModelProviders.of(getActivity()).get(TodoViewModel.class);

        newTodo = todoViewModel.getTodo(todoIndex);
        TVTitle.setText(newTodo.getTitle());
        TVDate.setText(newTodo.getDate().toString());
    }
}