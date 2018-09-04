package com.example.android.myapplication;

import android.net.Uri;
import android.widget.ImageView;

import java.net.URI;


public class Word {
    private String mArabic ;
    private String mEnglish;
    private int maudioResourseId ;
    private int mImageResourseId = No_Image;
    private String muri ;
    private static final int No_Image = -1;
    public Word(String Arabic , String English , int ImageResourseId,int AudioResourseId){
        mArabic = Arabic ;
        mEnglish = English;
        mImageResourseId = ImageResourseId;
        maudioResourseId =AudioResourseId;
    }

    public Word(String Arabic , String English ,int AudioResourseId){
        mArabic = Arabic ;
        mEnglish = English;
        maudioResourseId =AudioResourseId;
    }
    public Word (String uri , int ImageResourseId , String English){
        muri = uri;
        mImageResourseId = ImageResourseId ;
        mEnglish = English;

    }



    public String getDeafultLanguage(){
        return mArabic;
    }

    public String getmEnglishlanguage(){
        return mEnglish;
    }

    public int getmImageResourseId (){
        return mImageResourseId;
    }

    public int getAudioResourceId() {
        return maudioResourseId;
    }

    public boolean hasImage(){
        return mImageResourseId != No_Image;
    }

    public String getUri (){
        return muri;
    }
}
