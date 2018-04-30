package com.example.hp.sociohub;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.hp.sociohub.fragment.MakePostFragment;
import com.example.hp.sociohub.fragment.SearchTimeLineFragment;
import com.example.hp.sociohub.fragment.UserTimeLineFragment;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;


public class TwitterHome extends AppCompatActivity {

    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TwitterConfig config = new TwitterConfig.Builder(this)
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig("cj9KlTDHKRucKGRnwatQGDPJr", "VPYXo07sCDYz5SG2Fumzbu1XL2vTZWzdyOnnZUctrZp2XhZiUi"))
                .debug(true)
                .build();
        Twitter.initialize(config);

        setContentView(R.layout.activity_twitter_home);

    }

        @Override
        protected void onResume() {
            super.onResume();


            final TwitterSession session = TwitterCore.getInstance().getSessionManager()
                    .getActiveSession();

            if(session != null) {


                FragmentTransaction ft = fm.beginTransaction();

                ft.replace(R.id.main_frame, new UserTimeLineFragment()).commit();

            }

            else {

                startActivity(new Intent(TwitterHome.this , TwitterLoginActivity.class));
            }


        }

    public void open_timeline(View view) {


        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.main_frame , new UserTimeLineFragment()).commit();

    }

    public void search_timeline(View view) {

        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.main_frame , new SearchTimeLineFragment()).commit();

    }

    public void post_timeline(View view) {

        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.main_frame , new MakePostFragment()).commit();

    }

    public void log_out_twitter(View view) {

        TwitterCore.getInstance().getSessionManager()
                .clearActiveSession();

        finish();
    }

}
