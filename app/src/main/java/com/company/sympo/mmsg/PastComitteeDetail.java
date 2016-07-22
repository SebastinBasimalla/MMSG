package com.company.sympo.mmsg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PastComitteeDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comittee_detail);

        TextView detailtext= (TextView) findViewById(R.id.detailtext);
        TextView detailName= (TextView) findViewById(R.id.detailName);
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("TITLE");
       // detailtext.setText(Title);
        detailName.setText(Title);


        ImageView backarrow= (ImageView) findViewById(R.id.backarrow);
        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
