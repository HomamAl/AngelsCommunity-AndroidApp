package com.example.user;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import com.example.user.Database_Insert_Delete.DatabaseMain;

public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void profile(View view){
        startActivity(new Intent(Main2Activity.this, ProfilePage.class));
    }

    public void badges(View view){

        startActivity(new Intent(Main2Activity.this, Badges.class));
    }


    public void donate(View view){
        startActivity(new Intent(Main2Activity.this, DonateActivity.class));
    }

    public void test(View view){
        startActivity(new Intent(Main2Activity.this, LoginActivity2.class));
    }
    public void Reg(View view){
        startActivity(new Intent(Main2Activity.this, RegPage.class));
    }

    public void suggestions (View view){
        startActivity(new Intent(Main2Activity.this, DatabaseMain.class));
    }

    public void charities (View view){
        startActivity(new Intent(Main2Activity.this, CharitiesListView.class));
    }


}
