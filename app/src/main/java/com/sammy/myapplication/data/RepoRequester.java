package com.sammy.myapplication.data;

import com.sammy.myapplication.model.Repo;

import java.util.List;

import javax.inject.Inject;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class RepoRequester {

    private final RepoService service;

    @Inject
    RepoRequester(RepoService service) {
        this.service = service;
    }

    public Single<List<Repo>> getTrendingRepos() {
        return service.getTrendingRepos()
                .map(TrendingReposResponse::repos)
                .subscribeOn(Schedulers.io());
    }
}
