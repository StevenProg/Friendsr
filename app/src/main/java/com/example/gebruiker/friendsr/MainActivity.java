package com.example.gebruiker.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import java.util.ArrayList;

/**
 * Created by Steven on ${22/2}. (10777679)
 */

public class MainActivity extends AppCompatActivity {


    ArrayList<Friend> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Friend Arya = new Friend("Arya", "I am Arya St.. I mean No One", this.getResources().getIdentifier("arya", "drawable", getPackageName()));
        Friend Cersei = new Friend("Cersei", "Look at me. Look at my face. It’s the last thing you’ll see before you die.", this.getResources().getIdentifier("cersei", "drawable", getPackageName()));
        Friend Daenerys = new Friend("Daenerys", "Daenerys Stormborn of the House Targaryen, First of Her Name, the Unburnt, Queen of the Andals and the First Men, Khaleesi of the Great Grass Sea, Breaker of Chains, and Mother of Dragons", this.getResources().getIdentifier("daenerys", "drawable", getPackageName()));
        Friend Jaime = new Friend("Jaime", "The things I do for love...", this.getResources().getIdentifier("jaime", "drawable", getPackageName()));
        Friend Jon = new Friend("Jon", "The King in the North!", this.getResources().getIdentifier("jon", "drawable", getPackageName()));
        Friend Jorah = new Friend("Jorah", "Who is this 'Jon' guy anyway?", this.getResources().getIdentifier("jorah", "drawable", getPackageName()));
        Friend Margaery = new Friend("Margaery", " The girl is as clever as she is pretty", getResources().getIdentifier("margaery", "drawable", getPackageName()));
        Friend Melisandre = new Friend("Melisandre", "The Night is Dark and Full of Terrors", this.getResources().getIdentifier("melisandre", "drawable", getPackageName()));
        Friend Sansa = new Friend("Sansa", "Thank you for your many lessons Lord Baelish. I will never forget them.", this.getResources().getIdentifier("sansa", "drawable", getPackageName()));
        Friend Tyrion = new Friend("Tyrion", "That's what I do: I drink and I know things.", this.getResources().getIdentifier("tyrion", "drawable", getPackageName()));

        friends.add(Arya);
        friends.add(Cersei);
        friends.add(Daenerys);
        friends.add(Jaime);
        friends.add(Jon);
        friends.add(Jorah);
        friends.add(Margaery);
        friends.add(Melisandre);
        friends.add(Sansa);
        friends.add(Tyrion);

        // creates adapter to switch to ProfileActivity when clicked using corresponding friend
        FriendsAdapter adapter = new FriendsAdapter(this,  R.layout.grid_item, friends);
        GridView currentView = findViewById(R.id.gridview);
        currentView.setAdapter(adapter);
        currentView.setOnItemClickListener(new GridItemClickListener());

    }
    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Friend clickedFriend = (Friend) adapterView.getItemAtPosition(i);
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend_key", clickedFriend);
            startActivity(intent);
        }
    }
}
