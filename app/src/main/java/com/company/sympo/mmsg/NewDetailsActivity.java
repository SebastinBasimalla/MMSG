package com.company.sympo.mmsg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import model.PeopleInfoData;

public class NewDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_details);

        TextView newdetailName= (TextView) findViewById(R.id.newdetailName);
        ImageView newdetailImage= (ImageView) findViewById(R.id.newdetailImage);
        ImageView backarrow= (ImageView) findViewById(R.id.backarrow);


        Intent intent = getIntent();
        String name = intent.getExtras().getString("Name");
        String LargeImageUrl = intent.getExtras().getString("LargeImageUrl");



        newdetailName.setText(name);
        newdetailImage.setImageResource(Integer.parseInt(LargeImageUrl));

        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

       // Toast.makeText(NewDetailsActivity.this, "Name is "+Title, Toast.LENGTH_SHORT).show();
    }
}
