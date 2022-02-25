package com.example.responsivelayout;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView tv6;
    TextView tv7;
    ImageView tv8;
    int imagevalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    tv1=(TextView) findViewById(R.id.textView);
    Intent intent=getIntent();
    String name=intent.getStringExtra("name");
    tv1.setText(name);
        tv4=(TextView) findViewById(R.id.textView2);
        String disc=intent.getStringExtra("disc");
        tv4.setText(disc);
        tv5=(TextView) findViewById(R.id.textView12);
        String deg=intent.getStringExtra("degree");
        tv5.setText(deg);
        tv6=(TextView) findViewById(R.id.textView14);
        String skill=intent.getStringExtra("skill");
        tv6.setText(skill);
        tv7=(TextView) findViewById(R.id.textView13);
        String ex=intent.getStringExtra("experience");
        tv7.setText(ex);
        // initialise the layout
//        tv8 = findViewById(R.id.imageView9);
//
//        // check if any value sent from previous activity
//        Bundle bundle = getIntent().getExtras();
//
//        // if bundle is not null then get the image value
//        if (bundle != null) {
//            imagevalue = bundle.getInt("image");
//            tv8.setImageResource(imagevalue);
//        }

        Button email=(Button) findViewById(R.id.button1);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv2=(TextView) findViewById(R.id.button1);
                Uri uri=Uri.parse("http://www.gmail.com");
                Intent email= new Intent(Intent.ACTION_VIEW,uri);
                startActivity(email);
            }
        });
        Button contact=(Button) findViewById(R.id.button);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv3=(TextView) findViewById(R.id.button);
                Uri uri=Uri.parse("tel:03125949654");
                Intent value= new Intent(Intent.ACTION_DIAL,uri);
                startActivity(value);
            }
        } );
    }
}