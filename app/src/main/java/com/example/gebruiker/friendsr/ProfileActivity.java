package com.example.gebruiker.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by Steven on ${22/2} (10777679)
 */

public class ProfileActivity extends AppCompatActivity {

    ImageView image;
    TextView bio, name;
    RatingBar rating;
    SharedPreferences.Editor editor;
    Friend retrievedFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();
        retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend_key");

        image = findViewById(R.id.ImageID);
        bio = findViewById(R.id.BioID);
        name = findViewById(R.id.NameID);
        rating = findViewById(R.id.RatingID);
        image.setImageDrawable(getResources().getDrawable(retrievedFriend.getDrawableId()));

        name.setText(retrievedFriend.getName());
        bio.setText(retrievedFriend.getBio());

        rating.setOnRatingBarChangeListener(new RatingChangeListener());

        // keeps track of earlier ratings, no earlier rating -> rating = 0.0
        editor = getSharedPreferences("rating", MODE_PRIVATE).edit();
        SharedPreferences prefs = getSharedPreferences("rating", MODE_PRIVATE);
        Float aStoredFloat = prefs.getFloat(retrievedFriend.getName(), 0);

        if(aStoredFloat != 0) {
            rating.setRating(prefs.getFloat(retrievedFriend.getName(), 0.0f));
        }
        else {
            rating.setRating(0.0f);
        }
        editor.apply();
    }

    private class RatingChangeListener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            SharedPreferences.Editor editor = getSharedPreferences("rating", MODE_PRIVATE).edit();
            editor.putFloat(retrievedFriend.getName(), v);
            editor.apply();
            retrievedFriend.setRating(v);

        }
    }
}
