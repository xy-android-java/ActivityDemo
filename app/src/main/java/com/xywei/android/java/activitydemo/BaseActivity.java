package com.xywei.android.java.activitydemo;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    private String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, TAG +"--- "+ "onCreate: ---onCreate()");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.d(TAG, TAG +"--- "+ "onPostCreate: ---onPostCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, TAG +"--- "+ "onStart: ---onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, TAG +"--- "+ "onResume: ---onResume");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(TAG, TAG +"--- "+ "onPostResume: ---onPostResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, TAG+"onPause: ---onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, TAG +"--- "+ "onStop: ---onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, TAG +"--- "+ "onRestart: ---onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, TAG +"--- "+ "onDestroy: ---onDestroy");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, TAG +"--- "+ "onSaveInstanceState: ---onSaveInstanceState");
    }

}
