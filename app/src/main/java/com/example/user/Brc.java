package com.example.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.user.R;

public class Brc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brc);
    }

    public void volunteer(View view){
        startActivity(new Intent(Brc.this, CalendarActivity.class));
    }

    public void donate(View view){

        startActivity(new Intent(Brc.this, DonateActivity.class));
    }

}
