package com.company.sympo.mmsg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Current_comitte_detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_comitte_detail);
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
