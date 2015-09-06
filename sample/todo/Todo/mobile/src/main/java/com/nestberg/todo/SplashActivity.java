package com.nestberg.todo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;


/**
 * Copyright 2015 Nestberg
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class SplashActivity extends AppCompatActivity {

    private class PageActionRunnable implements Runnable {
        private Activity curentActivity;
        private Class pageActionActivityClass;

        public PageActionRunnable(final Activity curentActivity, Class pageActionActivityClass) {
            this.curentActivity = curentActivity;
            this.pageActionActivityClass = pageActionActivityClass;
        }
        public void run() {
            Intent i = new Intent(curentActivity,pageActionActivityClass);
            startActivity(i);
        }
    };

    private Handler pageActionHandler;
    private PageActionRunnable pageActionRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Class pageActionActivityClass = Define.MAIN_ACTIVITY;

        pageActionHandler = new Handler();
        pageActionRunnable = new PageActionRunnable(this,pageActionActivityClass);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    protected void onResume() {
        super.onResume();
        pageActionHandler.postDelayed(pageActionRunnable, 2000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // remove handler.. (home key -> cancel app)
        pageActionHandler.removeCallbacks(pageActionRunnable);

    }

}
