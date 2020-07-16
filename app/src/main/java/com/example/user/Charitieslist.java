package com.example.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class Charitieslist extends AppCompatActivity {

    GridLayout mainGrid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charities);
        mainGrid = (GridLayout)findViewById(R.id.mainGrid);


        //Set Event
        setSingleEvent(mainGrid);
        //setToggleEvent(mainGrid);
    }

    private void setToggleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //all child item is CardView  so  cast object to CardView
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Toast.makeText(Charitieslist.this, "State : True", Toast.LENGTH_SHORT).show();

                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(Charitieslist.this, "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            // all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    if (finalI == 0) // open activity

                    {
                        Intent intent = new Intent (Charitieslist.this, Bhf.class);
                        startActivity(intent);
                    }
                    else if (finalI == 1) // open activity

                    {
                        Intent intent = new Intent (Charitieslist.this, Brc.class);
                        startActivity(intent);
                    }
                    else if (finalI == 2) // open activity

                    {
                        Intent intent = new Intent (Charitieslist.this, Cruk.class);
                        startActivity(intent);
                    }
                    else if (finalI == 3) // open activity

                    {
                        Intent intent = new Intent (Charitieslist.this, Mmcs.class);
                        startActivity(intent);
                    }
                    else if (finalI == 4) // open activity

                    {
                        Intent intent = new Intent (Charitieslist.this, Rbl.class);
                        startActivity(intent);
                    }
                    else if (finalI == 5) // open activity

                    {
                        Intent intent = new Intent (Charitieslist.this, MainActivity.class);
                        startActivity(intent);
                    }




                }
            });
        }
    }
}
