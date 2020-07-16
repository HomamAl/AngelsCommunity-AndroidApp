package com.example.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.user.R;

public class Bhf extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhf);
    }

    public void volunteer(View view){
        startActivity(new Intent(Bhf.this, CalendarActivity.class));
    }

    public void donate(View view){

        startActivity(new Intent(Bhf.this, DonateActivity.class));
    }

}
