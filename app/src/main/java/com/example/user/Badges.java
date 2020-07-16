package com.example.user;

import android.app.Dialog;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Badges extends AppCompatActivity {


    int count = 50;
    int Tcount = 1;
    Dialog myDialog;
    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badges);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DBHelper databaseHelper = new DBHelper(this);

        View imageView_B1 = findViewById(R.id.imageView_B1);
        View imageView_B2 = findViewById(R.id.imageView_B2);
        View imageView_B3 = findViewById(R.id.imageView_B3);
        View imageView_B4 = findViewById(R.id.imageView_B4);

        View imageView_TB1 = findViewById(R.id.imageView_TB1);
        View imageView_TB2 = findViewById(R.id.imageView_TB2);
        View imageView_TB3 = findViewById(R.id.imageView_TB3);
        View imageView_TB4 = findViewById(R.id.imageView_TB4);

        if (count >= 1) {
            imageView_B1.setAlpha(0);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Button button = findViewById(R.id.button);
                    button.performClick();
                }
            }, 3000);
        }
        if (count >= 10) {
            imageView_B2.setAlpha(0);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Button button = findViewById(R.id.button2);
                    button.performClick();
                }
            }, 6000);
        }
        if (count >= 50) imageView_B3.setAlpha(0);
        if (count >= 100) imageView_B4.setAlpha(0);

        if (Tcount >= 1) {
            imageView_TB1.setAlpha(0);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Button button = findViewById(R.id.button5);
                    button.performClick();
                }
            }, 4000);
        }
        if (Tcount >= 10) {
            imageView_TB2.setAlpha(0);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Button button = findViewById(R.id.button2);
                    button.performClick();
                }
            }, 6000);
        }
        if (Tcount >= 50) imageView_TB3.setAlpha(0);
        if (Tcount >= 100) imageView_TB4.setAlpha(0);

        myDialog = new Dialog(this);
    }


    public void ShowPopup(View v) {
        TextView txtclose;
        myDialog.setContentView(R.layout.popupwindow);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }

    public void ShowPopup2(View v) {
        TextView txtclose;
        myDialog.setContentView(R.layout.popupwindow2);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }

    public void ShowPopup5(View v) {
        TextView txtclose;
        myDialog.setContentView(R.layout.popupwindow5);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        myDialog.show();

    }
}

