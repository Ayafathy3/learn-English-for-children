package com.example.android.myapplication;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class ConversationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        final ArrayList<Word> con = new ArrayList<Word>();
      con.add(new Word("https://www.youtube.com/watch?v=zxCDS0QRyXQ",R.drawable.con1,"Sorry"));
        con.add(new Word("https://www.youtube.com/watch?v=lqSBEc1WLTk",R.drawable.con2,"Ask A Shopkeeper"));
        con.add(new Word("https://www.youtube.com/watch?v=pNVynlHDe4w",R.drawable.con3,"At The Fruit Shop"));
        con.add(new Word("https://www.youtube.com/watch?v=7k4uBAiJsMM",R.drawable.con4," What's your name?"));
        con.add(new Word("https://www.youtube.com/watch?v=hDx1i9JJEO0",R.drawable.con5," What's this?"));
        con.add(new Word("https://www.youtube.com/watch?v=YCaa5ZNolQY",R.drawable.con6,"I can sing"));
        con.add(new Word("https://www.youtube.com/watch?v=J6E5ftWii8s",R.drawable.con7,"Animals"));
        con.add(new Word("https://www.youtube.com/watch?v=Go52OhcZL1o",R.drawable.con8,"Colors"));
        con.add(new Word("https://www.youtube.com/watch?v=TeyK3s6ypB8",R.drawable.con9,"Food"));
        con.add(new Word("https://www.youtube.com/watch?v=Qtu-3gTSymM",R.drawable.con10," Numbers"));


        final WordAdapter Adapter = new WordAdapter(this,con,R.color.category_Conversation);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = con.get(position);
                String uri = word.getUri();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(uri)));

            }
        });
    }
    }
