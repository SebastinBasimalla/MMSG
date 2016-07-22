package com.company.sympo.mmsg;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CurrentComitteeDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_comittee_details);

        TextView detailName= (TextView) findViewById(R.id.detailNameCurrentComitte);
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("TITLE");

        detailName.setText(Title);

        ImageView backarrowCurrentComittee= (ImageView) findViewById(R.id.backarrowCurrentComittee);
        backarrowCurrentComittee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }

}
