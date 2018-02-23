package com.example.gebruiker.friendsr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Steven on ${22/2} (10777679)
 */

public class FriendsAdapter extends ArrayAdapter<Friend> {
    @NonNull
    private ArrayList<Friend> friends;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }
        ImageView image = convertView.findViewById(R.id.imageID);
        TextView text = convertView.findViewById(R.id.textID);
        Friend CurrentFriend = friends.get(position);
        image.setImageDrawable(getContext().getResources().getDrawable(CurrentFriend.getDrawableId()));
        text.setText(CurrentFriend.getName());
        return convertView;
    }

    FriendsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Friend> objects) {
        super(context, resource, objects);
        friends = objects;
    }
}
