package com.example.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Cruk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cruk);
    }

    public void volunteer(View view){
        startActivity(new Intent(Cruk.this, CalendarActivity.class));
    }

    public void donate(View view){

        startActivity(new Intent(Cruk.this, DonateActivity.class));
    }

}
