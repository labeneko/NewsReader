package com.example.takahiro_tsuno.newsreader.ui.activity;

import android.os.Bundle;

import com.example.takahiro_tsuno.newsreader.R;
import com.example.takahiro_tsuno.newsreader.domain.rss.Rss;
import com.example.takahiro_tsuno.newsreader.infrastructure.AndroidUtils;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;


public class HomeActivity extends BaseActivity {

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_home;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("test");

        Serializer serializer = new Persister();
        String xmlString = new String(AndroidUtils.openAssetAsByteArray(this, "yahoonews.xml"));

        Rss rss;

        try {
            rss = serializer.read(Rss.class, xmlString);
            System.out.println(rss.getChannel().getTitle());
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
