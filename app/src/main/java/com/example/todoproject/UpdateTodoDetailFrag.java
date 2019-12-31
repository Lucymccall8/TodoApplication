package com.example.todoproject;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class UpdateTodoDetailFrag extends Fragment {


    private TodoViewModel todoViewModel;
    private TodoCreate newTodo = new TodoCreate();
    private int otodoIndex = 0;

    private TextView  TVtodoTitle;
    private TextView TVtodoDate;
    private EditText ETtodoDetail;
    private CheckBox CBisTodoComplete;
    private CheckBox CBisTodoPending;
    private Button BTupdateTodoDetail;

    public static UpdateTodoDetailFrag newInstance() { return new UpdateTodoDetailFrag(); }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_todo_detail, container, false);

   todoViewModel = ViewModelProviders.of(getActivity()).get(TodoViewModel.class);
   otodoIndex = todoViewModel.getTodoIndex();
   newTodo = todoViewModel.getTodo(otodoIndex);


   // gets the id of each view, and makes it set the contents of each to a todo when the user uses them.
   TVtodoTitle = view.findViewById(R.id.TVTitle);
   TVtodoTitle.setText(newTodo.getTitle());

   TVtodoDate = view.findViewById(R.id.TVDate);
   TVtodoDate.setText(newTodo.getDate().toString());

   ETtodoDetail = view.findViewById(R.id.ETDetail);
   ETtodoDetail.setText(newTodo.getDetail());

   CBisTodoComplete = view.findViewById(R.id.CBComplete);
   CBisTodoComplete.setChecked(newTodo.isComplete());

   CBisTodoPending = view.findViewById(R.id.CBPending);
   CBisTodoPending.setChecked(newTodo.isPending());

   // defines the detail button for first page, and implements and onclick listener.
   BTupdateTodoDetail = (Button) view.findViewById((R.id.BTDetail));
   BTupdateTodoDetail.setOnClickListener(new View.OnClickListener(){

       @Override
       public void onClick(View v) {
           // when the button is clicked, new todos detail is taken from the edit text, and changed into string and stored
           newTodo.setDetail(ETtodoDetail.getText().toString());
           // the state of the checkboxes are saved
           newTodo.setIsComplete(CBisTodoComplete.isChecked());
           newTodo.setIsPending(CBisTodoPending.isChecked());
           // the index of the todo is saved for the view model, so it knows which todo to display later
           todoViewModel.setTodo(otodoIndex, newTodo);

           //this new instance is defined within the FirstPageFragment
            FirstPageFragment mainFragment = FirstPageFragment.newInstance();

           FragmentTransaction transaction = getFragmentManager().beginTransaction();
           // this fragment goes into the fragment container. FContainer is the layout within the main activity
           transaction.replace(R.id.FContainer, mainFragment);
           transaction.addToBackStack(null);
           // this ommits the changes
           transaction.commit();
       }
   });

   // this returns the view, so that we can see it
   return view;
    }
}
