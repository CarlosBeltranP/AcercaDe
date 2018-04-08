package com.example.charlie.acercade;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShare = ((Button) findViewById(R.id.botonShare));
        btnShare.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        ShareInfo();
                    }
                });
    }

    private void ShareInfo() {

        Intent intent=null, chooser=null;

        final TextView facebook = (TextView) findViewById(R.id.face);
        final TextView github = (TextView) findViewById(R.id.git);
        final TextView gmail = (TextView) findViewById(R.id.gm);
        final TextView whatsapp = (TextView) findViewById(R.id.ws);

        intent = new Intent(Intent.ACTION_SEND)
            .setType("image/*")
            .putExtra(Intent.EXTRA_STREAM, Uri.parse("android.resource://com.example.charlie.acercade/drawable/" + Integer.toString(R.drawable.profile)))
            .putExtra(Intent.EXTRA_TEXT, "Facebook:  " + facebook.getText().toString() + "\n\nGithub:  " + github.getText().toString() + "\n\nGmail:  " + gmail.getText().toString() + "\n\nWhatsapp:  " + whatsapp.getText().toString());

        chooser=Intent.createChooser(intent, "Compartir Información");

        if(intent.resolveActivity(getPackageManager())!=null);
        startActivity(chooser);

    }

}


