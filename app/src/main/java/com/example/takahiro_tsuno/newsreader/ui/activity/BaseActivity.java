package com.example.takahiro_tsuno.newsreader.ui.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.example.takahiro_tsuno.newsreader.R;


public abstract class BaseActivity extends ActionBarActivity {

    protected abstract int getLayoutResourceId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
    }
}
