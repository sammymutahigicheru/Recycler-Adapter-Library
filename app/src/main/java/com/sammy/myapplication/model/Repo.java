package com.sammy.myapplication.model;

import com.google.auto.value.AutoValue;
import com.sammy.poweradapter.item.RecyclerItem;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import org.threeten.bp.ZonedDateTime;

@AutoValue
public abstract class Repo implements RecyclerItem {

    public abstract long id();

    public abstract String name();

    public abstract String description();

    public abstract User owner();

    @Json(name = "stargazers_count")
    public abstract long stargazersCount();

    @Json(name = "forks_count")
    public abstract long forksCount();

    @Json(name = "contributors_url")
    public abstract String contributorsUrl();

    @Json(name = "created_at")
    public abstract ZonedDateTime createdDate();

    @Json(name = "updated_at")
    public abstract ZonedDateTime updatedDate();


    @Override
    public long getId() {
        return id();
    }

    @Override
    public String renderKey() {
        return "Repo";
    }
    public static JsonAdapter<Repo> jsonAdapter(Moshi moshi) {
        return new AutoValue_Repo.MoshiJsonAdapter(moshi);
    }
}
