package com.el.share;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {


    Button shareButton;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitializeVariables();
        SetListners();
    }
    public void InitializeVariables(){
        shareButton = (Button) findViewById(R.id.ShareButton);
        editText = (EditText) findViewById(R.id.EditText);
    }
    public void SetListners(){
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareString(editText.getText().toString());
            }
        });
    }
    public void ShareString(String stringToShare){
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT,stringToShare);
        startActivity(Intent.createChooser(shareIntent,"Select"));
    }
}
