package com.example.android.myapplication;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private AudioManager mAudioManager;

    public MediaPlayer mediaPlayer;
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

    // Create Array List for family members
        final ArrayList <Word> families = new ArrayList<Word>();
        families.add(new Word("ابنة","dauther",R.drawable.family_daughter,R.raw.daughter));
        families.add(new Word("ابن","son",R.drawable.family_son,R.raw.son));
        families.add(new Word("أب","father",R.drawable.family_father,R.raw.father));
        families.add(new Word("جد","grandfather",R.drawable.family_grandfather,R.raw.gf));
        families.add(new Word("جدة","grandmother",R.drawable.family_grandmother,R.raw.gm));
        families.add(new Word("أم","mother",R.drawable.family_mother,R.raw.mother));
        families.add(new Word("الأخ الكبير","older brother",R.drawable.family_older_brother,R.raw.ob));
        families.add(new Word("الأخت الكبيرة","older sister",R.drawable.family_older_sister,R.raw.os));
        families.add(new Word("الأخ الصغير","younger brother",R.drawable.family_younger_brother,R.raw.yb));
        families.add(new Word("الأخت الصغيرة","younger sister",R.drawable.family_younger_sister,R.raw.ys));

         WordAdapter familyAdapter = new WordAdapter(this ,families,R.color.category_Family);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(familyAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = families.get(position);
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have audio focus now.

                    // Create and setup the {@link MediaPlayer} for the audio resource associated
                    // with the current word
                    mediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioResourceId());

                    // Start the audio file
                    mediaPlayer.start();
                }

            }
        });

    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }



    }
    @Override
    protected void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }
}
