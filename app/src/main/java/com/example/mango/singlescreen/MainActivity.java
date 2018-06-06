package com.example.mango.singlescreen;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<TeamMember> teamList = new ArrayList<>();
    private RecyclerView recyclerView, categoryRec;
    private TeamAdapter teamAdapter;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Preparing Data for Team Member.
        teamData();
        //Preparing data for Popular Cources
        List<Integer[]> popularCourcees = new ArrayList<>();
        popularCourcees.add(new Integer[]{R.string.categoryNN, R.drawable.nn});
        popularCourcees.add(new Integer[]{R.string.categoryDD, R.drawable.dd});
        popularCourcees.add(new Integer[]{R.string.categoryAN, R.drawable.an});
        popularCourcees.add(new Integer[]{R.string.categoryFSD, R.drawable.fsd});
        popularCourcees.add(new Integer[]{R.string.categoryROBO, R.drawable.robo});


        // click listener for website.
        LinearLayout linkLayout = (LinearLayout) findViewById(R.id.link_layout);
        linkLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://" + getString(R.string.website))));
            }
        });

        //Click listener for Phone.
        LinearLayout phoneLayout = (LinearLayout) findViewById(R.id.phone_layout);
        phoneLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:" + getString(R.string.phone))));
            }
        });

        //Click listener for Map.
        LinearLayout mapLayout = (LinearLayout) findViewById(R.id.map_layout);
        mapLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("https://www.google.co.in/maps/place/2465+Latham+St,+Mountain+View,+CA+94040,+USA/@37.3999133,-122.1105521,17z/data=!3m1!4b1!4m5!3m4!1s0x808fb098443680fd:0xc806a7a80752e40c!8m2!3d37.3999133!4d-122.1083634");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }

            }
        });




        recyclerView = (RecyclerView) findViewById(R.id.team_view);
        categoryRec =  (RecyclerView) findViewById(R.id.categoryRec);

        teamAdapter = new TeamAdapter(teamList);
        categoryAdapter = new CategoryAdapter(popularCourcees, this);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager categoryLayout = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);

        //Settings for Team Members.
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(teamAdapter);

        //Settings for Popular Cources
        categoryRec.setItemAnimator(new DefaultItemAnimator());
        categoryRec.setLayoutManager(categoryLayout);
        categoryRec.setAdapter(categoryAdapter);

    }

    private void teamData()
    {
        teamList.add(new TeamMember("https://d125fmws0bore1.cloudfront.net/webpack/production/app/components/AboutUs/assets/leaders/Sebastian.jpg",
                    "Sebastian Thrun", "FOUNDER, PRESIDENT"));

        teamList.add(new TeamMember("https://d125fmws0bore1.cloudfront.net/webpack/production/app/components/AboutUs/assets/leaders/Vish.jpg",
                    "Vish Makhijani", "CEO"));

        teamList.add(new TeamMember("https://d125fmws0bore1.cloudfront.net/webpack/production/app/components/AboutUs/assets/leaders/Clarissa.jpg",
                "Clarissa Shen", "CHIEF OPERATING OFFICER"));

        teamList.add(new TeamMember("https://d125fmws0bore1.cloudfront.net/webpack/production/app/components/AboutUs/assets/leaders/Christian.jpg",
                "Christian Plagemann", "VP, LEARNING"));

        teamList.add(new TeamMember("https://d125fmws0bore1.cloudfront.net/webpack/production/app/components/AboutUs/assets/leaders/Salwa.jpg",
                "Salwa Muhammad", "VP, UDACITY CONNECT"));

        teamList.add(new TeamMember("https://d125fmws0bore1.cloudfront.net/webpack/production/app/components/AboutUs/assets/leaders/Kathleen.jpg",
                "Kathleen Mullaney", "VP, CAREERS & PEOPLE OPS"));
    }
}
