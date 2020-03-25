package com.sammy.myapplication.home;

import com.bluelinelabs.conductor.Controller;
import com.sammy.myapplication.R;
import com.sammy.myapplication.base.BaseActivity;
import com.sammy.myapplication.trending.TrendingReposController;

public class MainActivity extends BaseActivity {

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected Controller initialScreen() {
        return new TrendingReposController();
    }
}
