package com.example.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Mmcs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mmcs);
    }

    public void volunteer(View view){
        startActivity(new Intent(Mmcs.this, CalendarActivity.class));
    }

    public void donate(View view){

        startActivity(new Intent(Mmcs.this, DonateActivity.class));
    }

}
