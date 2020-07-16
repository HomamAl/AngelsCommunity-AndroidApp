package com.example.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CharitiesListView extends AppCompatActivity {

    ListView viewList;
    String charityTitle[] = {"Macmillan Cancer Support", "British Red Cross", "Royal British Legion", "Cancer Research Uk", "British Heart Foundation"};
    String charityDescription[] = {"Macmillan Cancer Support is one of the largest British charities and provides specialist health care, information and financial support to people affected by cancer. It also looks at the social, emotional and practical impact cancer can have, and campaigns for better cancer care.",
            "The British Red Cross helps people in crisis, responding to disasters, conflicts and individual emergencies here in the UK and across the world. We enable vulnerable people to prepare for and respond to emergencies in their own communities.",
            "The Royal British Legion (RBL), sometimes called The British Legion or The Legion, is a British charity providing financial, social and emotional support to members and veterans of the British Armed Forces, their families and dependants.",
            "Cancer Research UK is a cancer research and awareness charity in the United Kingdom and Isle of Man, formed on 4 February 2002 by the merger of The Cancer Research Campaign and the Imperial Cancer Research Fund. Its aim is to reduce the number of deaths from cancer.",
            "The British Heart Foundation (BHF) is a charity organisation in the United Kingdom. It funds research to beat heartbreak from heart and circulatory diseases and their risk factors."};
    int logo[] = {R.drawable.macmillan_cancer_support, R.drawable.brc, R.drawable.royal_british_legion, R.drawable.cancer_research_uk, R.drawable.british_heart_foundation};
    // Logo, Main title and descriptions set in an array


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charities_list_view);

        viewList = findViewById(R.id.viewList);

        MyAdapter adapter = new MyAdapter(this, charityTitle, charityDescription, logo); //Creating an adapter class
        viewList.setAdapter(adapter);

        //Notifications will show when pressed on the list item
        viewList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent intent = new Intent(getApplicationContext(), Mmcs.class);
                    // put the 0 index image to charityDescription activity
//                    Bundle bundle = new Bundle();
//                    bundle.putInt("image", logo[0]);
//                    intent.putExtras(bundle);
//                    // the title and description are moved to another activity
//                    intent.putExtra("title", charityTitle[0]);
//                    intent.putExtra("description", charityDescription[0]);
//                    // set the position
//                    intent.putExtra("position", ""+0);
                    startActivity(intent);


                }
                if (position == 1) {
                    Intent intent = new Intent(getApplicationContext(), Brc.class);
//                    // put the 1 index image to charityDescription activity
//                    Bundle bundle = new Bundle();
//                    bundle.putInt("image", logo[1]);
//                    intent.putExtras(bundle);
//                    // the title and description are moved to another activity
//                    intent.putExtra("title", charityTitle[1]);
//                    intent.putExtra("description", charityDescription[1]);
//                    // set the position
//                    intent.putExtra("position", ""+1);
                    startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(getApplicationContext(), Rbl.class);
//                    // put the 2 index image to charityDescription activity
//                    Bundle bundle = new Bundle();
//                    bundle.putInt("image", logo[2]);
//                    intent.putExtras(bundle);
//                    // the title and description are moved to another activity
//                    intent.putExtra("title", charityTitle[2]);
//                    intent.putExtra("description", charityDescription[2]);
//                    // set the position
//                    intent.putExtra("position", ""+2);
                    startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(getApplicationContext(), Cruk.class);
//                    // put the 3 index image to charityDescription activity
//                    Bundle bundle = new Bundle();
//                    bundle.putInt("image", logo[3]);
//                    intent.putExtras(bundle);
//                    // the title and description are moved to another activity
//                    intent.putExtra("title", charityTitle[3]);
//                    intent.putExtra("description", charityDescription[3]);
//                    // set the position
//                    intent.putExtra("position", ""+3);
                    startActivity(intent);
                }
                if (position == 4) {
                    Intent intent = new Intent(getApplicationContext(), Bhf.class);
//                    // put the 4 index image to charityDescription activity
//                    Bundle bundles = new Bundle();
//                    bundles.putInt("image", logo[4]);
//                    intent.putExtras(bundles);
//                    // the title and description are moved to another activity
//                    intent.putExtra("title", charityTitle[4]);
//                    intent.putExtra("description", charityDescription[4]);
//                    // set the position
//                    intent.putExtra("position", ""+4);
                    startActivity(intent);
                }
            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String arrayTitle[];
        String arrayDescriptions[];
        int arrayImgs[];

        MyAdapter (Context con, String Title[], String Description[], int imags[]) {
            super(con, R.layout.charities_row, R.id.Title, Title);
            this.context = con;
            this.arrayTitle = Title;
            this.arrayDescriptions = Description;
            this.arrayImgs = imags;}

        @NonNull
        @Override
        public View getView(int order, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.charities_row, parent, false);
            ImageView logo = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.Title);
            TextView myDescription = row.findViewById(R.id.subTitle);

            //set the resources on views
            logo.setImageResource(arrayImgs[order]);
            myTitle.setText(arrayTitle[order]);
            myDescription.setText(arrayDescriptions[order]);

            return row;
        }
    }
}
