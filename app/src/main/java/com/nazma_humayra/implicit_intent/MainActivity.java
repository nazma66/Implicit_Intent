package com.nazma_humayra.implicit_intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText et;
    Button camera, contact_list, file_manager, dial, browser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        camera = findViewById(R.id.camera);
        contact_list = findViewById(R.id.contact_list);
        file_manager = findViewById(R.id.file_manager);
        dial = findViewById(R.id.dial);
        browser = findViewById(R.id.browser);
         et = findViewById(R.id.et);

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setAction(MediaStore.ACTION_VIDEO_CAPTURE);
                //  i.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(i);
            }
        });

        contact_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("content://contacts/people/"));
                startActivity(i);
            }
        });
        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent();
                ii.setAction(Intent.ACTION_DIAL);
                ii.setData(Uri.parse("tel:" +et.getText()));
                startActivity(ii);
            }

        });
        file_manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent();
                ii.setAction(Intent.ACTION_VIEW);
                ii.setData(Uri.parse("content://media/external/images/media/"));
                startActivity(ii);
            }
        });
        browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent();
                ii.setAction(Intent.ACTION_VIEW);
                String url = et.getText().toString();
                ii.setData(Uri.parse("https://www."+url));
                startActivity(Intent.createChooser(ii,"Title"));
            }
        });

//        For video
       /* bt_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent();
                ii.setAction(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivity(ii);
            }
        });*/
    }
}