package com.example.user.Database_Insert_Delete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.R;

public class DatabaseMain extends AppCompatActivity {

    HelpDatabase myDatabaseHelper;
    private Button addButton, ViewDataButton;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite__charity);
        editText =  findViewById(R.id.editText);
        addButton = findViewById(R.id.addButton);
        ViewDataButton = findViewById(R.id.btnView);
        myDatabaseHelper = new HelpDatabase(this);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                if (editText.length() != 0) {
                    DataAdd(newEntry);
                    editText.setText("");
                } else {
                    msgToast("You must write something in the text field!!"); }

            }
        });

        ViewDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DatabaseMain.this, ListViewContent.class);
                startActivity(intent); }
        });

    }


    public void DataAdd(String newEntry) {
        boolean dataInsert = myDatabaseHelper.dataAdd(newEntry);

        if (dataInsert) {
            msgToast("Data Successfully Inserted!!!");
        } else { msgToast("Something went wrong!!!"); }
    }

    //Customize toast massage
    private void msgToast(String msg){
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
    }
}

