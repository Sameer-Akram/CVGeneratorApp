package com.example.responsivelayout;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Cvform extends AppCompatActivity {
    int SELECT_IMAGE_CODE=1;
    Button sendimage;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cvform);
        TextView fullname=(TextView) findViewById(R.id.fullname);
        TextView mail=(TextView) findViewById(R.id.email);
        TextView contact=(TextView) findViewById(R.id.number);
        TextView discription=(TextView) findViewById(R.id.discprition);
        TextView finaldegree=(TextView) findViewById(R.id.degree);
        TextView skill=(TextView) findViewById(R.id.skill);
        TextView experience=(TextView) findViewById(R.id.experience);
        Button submit=(Button) findViewById(R.id.button);
        Button btn=(Button) findViewById(R.id.btn);
        imageView=findViewById(R.id.pickedImage);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setType("image/*");

                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Title"),SELECT_IMAGE_CODE);

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        String sendData=fullname.getText().toString();
                        String dis=discription.getText().toString();
                        String degre=finaldegree.getText().toString();
                        String skil=skill.getText().toString();
                        String ex=experience.getText().toString();
                        Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("name",sendData);
                        intent.putExtra("disc",dis);
                        intent.putExtra("experience",ex);
                         intent.putExtra("degree",degre);
                        intent.putExtra("skill",skil);
                        intent.putExtra("image", R.drawable.profile);
//                startActivity(sendimage);
//                      intent.putExtra("image",R.drawable.profile);
                // add the image in putExtra
                // and send the data in next activity

                        startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            Uri uri=data.getData();
            imageView.setImageURI(uri);

        }
    }
}