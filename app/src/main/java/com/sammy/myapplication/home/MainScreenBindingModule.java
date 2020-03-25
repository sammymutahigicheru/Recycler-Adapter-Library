package com.sammy.myapplication.home;

import com.bluelinelabs.conductor.Controller;
import com.sammy.myapplication.di.ControllerKey;
import com.sammy.myapplication.trending.TrendingReposComponent;
import com.sammy.myapplication.trending.TrendingReposController;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
        TrendingReposComponent.class,
})
public abstract class MainScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindTrendingReposInjector(TrendingReposComponent.Builder builder);
}
