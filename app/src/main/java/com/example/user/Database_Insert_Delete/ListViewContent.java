package com.example.user.Database_Insert_Delete;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.R;

import java.util.ArrayList;

public class ListViewContent extends AppCompatActivity {

    private static final String TAG = "ListViewContent";

    HelpDatabase myDatabaseHelper;

    private ListView myListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewcontent_layout);
        myListView = findViewById(R.id.viewList);
        myDatabaseHelper = new HelpDatabase(this);

        populateListView();
    }

    private void populateListView() {
        Log.d(TAG, "PopulateListView: Displaying data in the ListView.");

        //get the data and append to a list
        Cursor data = myDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            //get the value from the database in the first column (column 1)
            //add it to the ArrayList after
            listData.add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData); //create the list adapter and set it (the adapter)

        myListView.setAdapter(adapter);

        //set an onItemClickListener to the database ListView
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String Name = adapterView.getItemAtPosition(i).toString();
                Log.d(TAG, "onItemClick: You Clicked on " + Name);

                Cursor data = myDatabaseHelper.itemIDget(Name); //get the id associated with that name
                int item_ID = -1;
                while(data.moveToNext()){
                    item_ID = data.getInt(0);
                }
                if(item_ID > -1){
                    Log.d(TAG, "onItemClick: The ID is: " + item_ID);
                    Intent editScreenIntent = new Intent(ListViewContent.this, DatabaseEdit.class);
                    editScreenIntent.putExtra("id",item_ID);
                    editScreenIntent.putExtra("name",Name);
                    startActivity(editScreenIntent);
                }
                else{
                    toastMessage("No ID is associated with that name!!");
                }
            }
        });
    }

    //Customize toast massage
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}