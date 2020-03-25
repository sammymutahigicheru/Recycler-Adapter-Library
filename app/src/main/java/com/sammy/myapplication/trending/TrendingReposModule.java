package com.sammy.myapplication.trending;

import com.sammy.poweradapter.adapter.RecyclerDataSource;
import com.sammy.poweradapter.item.ItemRenderer;
import com.sammy.poweradapter.item.RecyclerItem;
import com.sammy.poweradapter.item.RenderKey;

import java.util.Map;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
public abstract class TrendingReposModule {
    @Binds
    @IntoMap
    @RenderKey("Repo")
    abstract ItemRenderer<? extends RecyclerItem> bindRepoRenderer(RepoRenderer repoRenderer);

    @Provides
    static RecyclerDataSource provideRecyclerDataSource(Map<String,ItemRenderer<? extends RecyclerItem>> rendererMap){
        return new RecyclerDataSource(rendererMap);
    }
}
