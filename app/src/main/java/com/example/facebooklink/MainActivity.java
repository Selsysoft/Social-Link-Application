package com.example.facebooklink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import libs.mjn.scaletouchlistener.ScaleTouchListener;

public class MainActivity extends AppCompatActivity {
    ImageView facebook,instagram,twitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        facebook = findViewById(R.id.facebook);
        instagram = findViewById(R.id.instagram);
        twitter = findViewById(R.id.twitter);

        twitter.setOnTouchListener(new ScaleTouchListener(config) {
            @Override
            public void onClick(View v) {
                Intent twitterIntent = openTwitter(MainActivity.this);

                startActivity(twitterIntent);
            }
        });

        instagram.setOnTouchListener(new ScaleTouchListener(config) {
            @Override
            public void onClick(View v) {
                Intent instagramIntent = openInstagram(MainActivity.this);

                startActivity(instagramIntent);
            }
        });

        facebook.setOnTouchListener(new ScaleTouchListener(config) {
            @Override
            public void onClick(View v) {

                Intent facebookIntent = openFacebook(MainActivity.this);

                startActivity(facebookIntent);
            }
        });

    }
    public static Intent openInstagram(Context context) {
        try {
            context.getPackageManager()
                    .getPackageInfo("com.instagram", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/l_selcuk_l/"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/l_selcuk_l/"));
        }


    }
    public static Intent openTwitter(Context context) {
        try {
            context.getPackageManager()
                    .getPackageInfo("com.twitter", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://twitter.com/l_Selcuk_l"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://twitter.com/l_Selcuk_l"));
        }


    }
    public static Intent openFacebook(Context context) {
        try {
            context.getPackageManager()
                    .getPackageInfo("com.facebook", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/selcuk.turedi.7"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/selcuk.turedi.7"));
        }


    }

    ScaleTouchListener.Config config = new ScaleTouchListener.Config(
            300,    // Duration
            0.85f,  // ScaleDown
            0.85f); // Alpha
}
