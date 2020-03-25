package com.sammy.myapplication.trending;

import com.sammy.myapplication.data.RepoRequester;
import com.sammy.myapplication.di.ScreenScope;
import com.sammy.myapplication.model.Repo;
import com.sammy.poweradapter.adapter.RecyclerDataSource;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;

@ScreenScope
class TrendingReposPresenter implements RepoAdapter.RepoClickedListener {

    private final TrendingReposViewModel viewModel;
    private final RepoRequester repoRequester;
    private final RecyclerDataSource source;

    @Inject
    TrendingReposPresenter(TrendingReposViewModel viewModel, RepoRequester repoRequester,
                           RecyclerDataSource source) {
        this.viewModel = viewModel;
        this.repoRequester = repoRequester;
        this.source = source;
        loadRepos();
    }

    private void loadRepos() {
        repoRequester.getTrendingRepos()
                .doOnSubscribe(__ -> viewModel.loadingUpdated().accept(true))
                .doOnEvent((d, t) -> viewModel.loadingUpdated().accept(false))
                .doOnSuccess(__ ->viewModel.reposUpdated().run())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(source::setData, viewModel.onError());
    }

    @Override
    public void onRepoClicked(Repo repo) {

    }
}
