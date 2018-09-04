package com.example.android.myapplication;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class LetterActivity extends AppCompatActivity {
    public MediaPlayer mediaPlayer;
    private AudioManager mAudioManager;
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
        setContentView(R.layout.activity_letter);
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> Number = new ArrayList<Word>();
        Number.add(new Word("A", "a" ,R.drawable.a ,R.raw.aa));
        Number.add(new Word( "B","b" ,R.drawable.bb ,R.raw.bb));
        Number.add(new Word( "C","c" ,R.drawable.c ,R.raw.cc));
        Number.add(new Word( "D","d" ,R.drawable.d ,R.raw.dd));
        Number.add(new Word( "E","e" ,R.drawable.e ,R.raw.ee));
        Number.add(new Word( "F","f" ,R.drawable.f ,R.raw.ff));
        Number.add(new Word( "G","g" ,R.drawable.g ,R.raw.gg));
        Number.add(new Word( "H","h" ,R.drawable.h ,R.raw.hh));
        Number.add(new Word( "I","i" ,R.drawable.i ,R.raw.ii));
        Number.add(new Word( "J","j" ,R.drawable.j ,R.raw.jj));
        Number.add(new Word( "K","k" ,R.drawable.k ,R.raw.kk));
        Number.add(new Word( "L","l" ,R.drawable.l ,R.raw.ll));
        Number.add(new Word( "M","m" ,R.drawable.m ,R.raw.mm));
        Number.add(new Word( "N","n" ,R.drawable.n ,R.raw.nn));
        Number.add(new Word( "O","o" ,R.drawable.o ,R.raw.oo));
        Number.add(new Word( "P","p" ,R.drawable.p ,R.raw.pp));
        Number.add(new Word( "Q","q" ,R.drawable.q ,R.raw.qq));
        Number.add(new Word( "R","r" ,R.drawable.r ,R.raw.rr));
        Number.add(new Word( "S","s" ,R.drawable.s ,R.raw.ss));
        Number.add(new Word( "T","t" ,R.drawable.t ,R.raw.tt));
        Number.add(new Word( "U","u" ,R.drawable.u ,R.raw.uu));
        Number.add(new Word( "V","v" ,R.drawable.v ,R.raw.vv));
        Number.add(new Word( "W","w" ,R.drawable.w ,R.raw.ww));
        Number.add(new Word( "X","x" ,R.drawable.x ,R.raw.xx));
        Number.add(new Word( "Y","y" ,R.drawable.y ,R.raw.yy));
        Number.add(new Word( "Z","z" ,R.drawable.z ,R.raw.zz));

        WordAdapter Adapter = new WordAdapter(this, Number, R.color.category_Letter);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(Adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = Number.get(position);

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have audio focus now.

                    // Create and setup the {@link MediaPlayer} for the audio resource associated
                    // with the current word
                    mediaPlayer = MediaPlayer.create(LetterActivity.this, word.getAudioResourceId());

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
