package com.example.android.myapplication;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  // create object
        ImageView numbers = findViewById(R.id.Number_image_view);
        ImageView letters = findViewById(R.id.letters_image_view);
        ImageView colors = findViewById(R.id.colors_image_view);
        ImageView animals = findViewById(R.id.animals_image_view);
        ImageView family = findViewById(R.id.family_image_view);
        ImageView word = findViewById(R.id.words_image_view);
        ImageView story = findViewById(R.id.story_image_view);
        ImageView conversation = findViewById(R.id.conversation_image_view);

        // create onclicklistener for numbers
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , NumbersActivity.class );
                startActivity(intent);
            }
        });
        // crate onclicklistener for letter
        letters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , LetterActivity.class );
                startActivity(intent);
            }
        });
        // create onclicklistener for family
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this ,FamilyActivity.class );
                startActivity(intent);
            }
        });
        // create onclicklistener for Colors
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , ColorsActivity.class );
                startActivity(intent);
            }
        });
        // create onclicklistener for Phrases
        word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , PhraseActivity.class );
                startActivity(intent);
            }
        });

        // create onclicklistener for Story
        story.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , StoryActivity.class );
                startActivity(intent);
            }
        });
          // create onclicklistener for Story
        animals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , AnimalActivity.class );
                startActivity(intent);
            }
        });

        // create onclicklistener for Story
        conversation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , ConversationActivity.class );
                startActivity(intent);
            }
        });

    }
}