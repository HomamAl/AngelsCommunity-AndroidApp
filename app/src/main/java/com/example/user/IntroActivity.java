//Alicia Windsor - 1803667
package com.example.user;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout tabIndicator;
    Button btnNext;
    int position = 0;
    Button btnGetStarted;
    Button btnSkip;

    Animation btnAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // make the activity on the full screen

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //check if it has already been opened, if so do not launch this activity.

//        if (restorePrefData()){
//
//           //TODO: Change UserLocationMap.class to MainActivity.class when current location is fixed.
//
//            Intent mainActivity = new Intent (getApplicationContext(),MainActivity.class);
//            startActivity(mainActivity);
//            finish();
//
//        }

        setContentView(R.layout.activity_intro);

        //hide the action bar

        //getSupportActionBar().hide(); [had to comment this out cuz it was crashing the app]

        //ini views

        btnNext = findViewById(R.id.btn_next);
        btnGetStarted = findViewById(R.id.btn_get_started);
        tabIndicator = findViewById(R.id.tab_indicator);
        btnSkip = findViewById(R.id.btn_skip);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.button_animation);

        // fill list screen

        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Donate","Donate your Time or Money to various charities!", R.drawable.launchdonate));
        mList.add(new ScreenItem("Find Charities","Search through the list of charities to find specific ones!", R.drawable.launchsearch));
        mList.add(new ScreenItem("Earn Badges","Unlock unique badges for each donation milestone you reach!", R.drawable.launchbadges));
        mList.add(new ScreenItem("Near You","Tap 'Get Started' to see the charities closest to you!", R.drawable.launchmap));

        //setup viewpager

        screenPager = findViewById(R.id.screen_viewpager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this,mList);
        screenPager.setAdapter(introViewPagerAdapter);

        //setup tablayout with viewpager

        tabIndicator.setupWithViewPager(screenPager);

        //next button click

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                position = screenPager.getCurrentItem();
                if (position < mList.size()) {

                    position ++;
                    screenPager.setCurrentItem(position);

                }

                if(position == mList.size()-1) { //when we reach the last screen

                    loadLastScreen();
                }
            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mainActivity = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(mainActivity);
                finish();

            }
        });

        //tablayout add change listener. This makes it so that the swiping does exactly what the next button does

        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if(tab.getPosition() == mList.size()-1){

                    loadLastScreen();

                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //getstarted button on click

        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // open main action
               Intent userLocationMap = new Intent (getApplicationContext(),UserLocationMap.class);
               startActivity(userLocationMap);

                //also need to save a boolean value to storage so next time the app is open the launch page does not display

                savePrefsData(); // this is the method that saves the boolean value
                finish();

            }
        });

    }

    private boolean restorePrefData() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isIntroActivityOpenedBefore = pref.getBoolean("isIntroOpened",false);
        return isIntroActivityOpenedBefore;
    }

    private void savePrefsData() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpened",true);
        editor.commit();
    }

    //Show the GETSTARTED Button and hide the indicator and the next button
    private void loadLastScreen() {


        btnNext.setVisibility(View.INVISIBLE);
        btnGetStarted.setVisibility(View.VISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);

        //TODO: ADD an Animation the getstarted button
        //lets create the button animation:
        //set up animation
        btnGetStarted.setAnimation(btnAnim);



    }


}
