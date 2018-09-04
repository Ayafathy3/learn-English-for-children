package com.example.android.myapplication;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;

    public WordAdapter( Context context, ArrayList<Word> words, int colorResourceId ) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView( int position, View convertView, ViewGroup parent ) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).
                    inflate(R.layout.list_item, parent, false);
        }
        Word currentWord = getItem(position);

        TextView ArabicTranslation = listItemView.findViewById(R.id.Arabic);
        ArabicTranslation.setText(currentWord.getDeafultLanguage());

        TextView EnglishTranslation = listItemView.findViewById(R.id.English);
        EnglishTranslation.setText(currentWord.getmEnglishlanguage());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.Image_numbers);
        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getmImageResourseId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }


        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);
        return listItemView;
    }

}
