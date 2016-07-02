package com.company.sympo.mmsg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ComitteeDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comittee_detail);

        TextView detailtext= (TextView) findViewById(R.id.detailtext);
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("TITLE");
        detailtext.setText(Title);

    }
}
