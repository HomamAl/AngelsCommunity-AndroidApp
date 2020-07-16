package com.example.user.Database_Insert_Delete;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.user.R;

public class DatabaseEdit extends AppCompatActivity {

    private static final String TAG = "EditDataActivity";

    private Button buttonSave,buttonDelete;
    private EditText editableItems;

    HelpDatabase myDatabaseHelper;

    private String chosenName;
    private int chosenID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_edit);
        buttonSave = findViewById(R.id.buttonSave);
        buttonDelete = findViewById(R.id.buttonDelete);
        editableItems = findViewById(R.id.editableItems);
        myDatabaseHelper = new HelpDatabase(this);

        //get the intent extra from the ListViewContent Activity
        Intent receivedIntent = getIntent();

        //we get the itemID that was passed as an extra
        chosenID = receivedIntent.getIntExtra("id",-1); //NOTE: -1 is just the default value

        //we get the name that was passed as an extra
        chosenName = receivedIntent.getStringExtra("name");

        //set the text to show the current selected name
        editableItems.setText(chosenName);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = editableItems.getText().toString();
                if(!item.equals("")){
                    myDatabaseHelper.nameUpdate(item,chosenID,chosenName);
                }else{
                    msgToast("You must enter a name!!");
                }
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDatabaseHelper.nameDelete(chosenID,chosenName);
                editableItems.setText("");
                msgToast("Removed from database!!");
            }
        });

    }

    //Customize toast massage
    private void msgToast(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}


