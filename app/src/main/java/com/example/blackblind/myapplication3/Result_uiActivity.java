package com.example.blackblind.myapplication3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Result_uiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_ui);

        ImageView imageView1 = findViewById(R.id.imageView1);
        ImageView imageView2 = findViewById(R.id.imageView2);
        ImageView imageView3 = findViewById(R.id.imageView3);
        imageView1.setImageResource(R.drawable.hi);
        imageView2.setImageResource(R.drawable.hi);
        imageView3.setImageResource(R.drawable.hi);

        Intent intent = getIntent();
        String query = intent.getStringExtra("query");

        TextView tv1 = findViewById(R.id.textView1);
        TextView tv2 = findViewById(R.id.textView2);
        TextView tv3 = findViewById(R.id.textView3);
        tv1.setText(query);
        tv2.setText(query);
        tv3.setText(query);
    }
}
