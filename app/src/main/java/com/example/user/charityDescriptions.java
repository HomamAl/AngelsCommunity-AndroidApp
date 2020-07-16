package com.example.user;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.R;

public class charityDescriptions extends AppCompatActivity {

    ImageView viewImage;
    TextView Title, Description;
    int Place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charity_descriptions);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        viewImage = findViewById(R.id.another_imageView);
        Title = findViewById(R.id.textTitle);
        Description = findViewById(R.id.txtDescription);

        if (Place == 0) {
            Intent intent = getIntent();

            Bundle bundle = this.getIntent().getExtras();
            int pic = bundle.getInt("image");
            String logoTitle = intent.getStringExtra("title");
            String logoDescription = intent.getStringExtra("description");

            viewImage.setImageResource(pic);
            Title.setText(logoTitle);
            Description.setText(logoDescription);

            if (actionBar != null) {
                actionBar.setTitle(logoTitle);
            }
        }

        if (Place == 1) {
            Intent intent = getIntent();

            Bundle bundle = this.getIntent().getExtras();
            int pic = bundle.getInt("image");
            String logoTitle = intent.getStringExtra("title");
            String logoDescription = intent.getStringExtra("description");

            viewImage.setImageResource(pic);
            Title.setText(logoTitle);
            Description.setText(logoDescription);

            actionBar.setTitle(logoTitle);
        }

        if (Place == 2) {
            Intent intent = getIntent();

            Bundle bundle = this.getIntent().getExtras();
            int pic = bundle.getInt("image");
            String logoTitle = intent.getStringExtra("title");
            String logoDescription = intent.getStringExtra("description");

            viewImage.setImageResource(pic);
            Title.setText(logoTitle);
            Description.setText(logoDescription);

            actionBar.setTitle(logoTitle);
        }

        if (Place == 3) {
            Intent intent = getIntent();

            Bundle bundle = this.getIntent().getExtras();
            int pic = bundle.getInt("image");
            String logoTitle = intent.getStringExtra("title");
            String logoDescription = intent.getStringExtra("description");

            viewImage.setImageResource(pic);
            Title.setText(logoTitle);
            Description.setText(logoDescription);

            actionBar.setTitle(logoTitle);
        }

        if (Place == 4) {
            Intent intent = getIntent();

            Bundle bundle = this.getIntent().getExtras();
            int pic = bundle.getInt("image");
            String logoTitle = intent.getStringExtra("title");
            String logoDescription = intent.getStringExtra("description");

            viewImage.setImageResource(pic);
            Title.setText(logoTitle);
            Description.setText(logoDescription);

            actionBar.setTitle(logoTitle);
        }

    }
}
