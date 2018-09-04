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
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class StoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        final ArrayList<Word> story = new ArrayList<Word>();
        story.add(new Word("https://www.youtube.com/watch?v=wZru-io_N5I&list=PLfv3tA5AoEjCX2n4RLWPdEWmie_fDyDyB",R.drawable.story1,"Hawk and their Friends"));
        story.add(new Word("https://www.youtube.com/watch?v=pdrOQmJkZBw&list=PLfv3tA5AoEjCX2n4RLWPdEWmie_fDyDyB&index=2",R.drawable.story2,"The Clever Monkey"));
        story.add(new Word("https://www.youtube.com/watch?v=f_9G25XNaio&list=PLfv3tA5AoEjCX2n4RLWPdEWmie_fDyDyB&index=3",R.drawable.story3,"The Careless Tige"));
        story.add(new Word("https://www.youtube.com/watch?v=U6P93srpjaM&list=PLfv3tA5AoEjCX2n4RLWPdEWmie_fDyDyB&index=4",R.drawable.story4,"The Golden Crab"));
        story.add(new Word("https://www.youtube.com/watch?v=yQmgB_LpTm8&index=5&list=PLfv3tA5AoEjCX2n4RLWPdEWmie_fDyDyB",R.drawable.story5,"The Brave Pig"));
        story.add(new Word("https://www.youtube.com/watch?v=EFBPGv5aOcM&index=6&list=PLfv3tA5AoEjCX2n4RLWPdEWmie_fDyDyB",R.drawable.story6,"The Clever Elephant"));
        story.add(new Word("https://www.youtube.com/watch?v=sAYDaXTIT3E&list=PLfv3tA5AoEjCX2n4RLWPdEWmie_fDyDyB&index=7",R.drawable.story7,"The Lion, Fox and the Ass"));
        story.add(new Word("https://www.youtube.com/watch?v=LaJGjV1BA88&list=PLfv3tA5AoEjCX2n4RLWPdEWmie_fDyDyB&index=8",R.drawable.story8,"The Intelligent Jackal"));
        story.add(new Word("https://www.youtube.com/watch?v=a1UJTdA-A6g&list=PLfv3tA5AoEjCX2n4RLWPdEWmie_fDyDyB&index=9",R.drawable.story9,"20 Best Short Story"));
        story.add(new Word("https://www.youtube.com/watch?v=Cy21AT_GFfs&index=10&list=PLfv3tA5AoEjCX2n4RLWPdEWmie_fDyDyB",R.drawable.story10,"Top 10 Short Stories"));


        final WordAdapter Adapter = new WordAdapter(this,story,R.color.category_Story);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = story.get(position);
                String uri = word.getUri();
                startActivity(new Intent(Intent.ACTION_VIEW , Uri.parse(uri)));

            }
        });
    }
}

