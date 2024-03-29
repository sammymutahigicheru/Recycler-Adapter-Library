package com.sammy.myapplication.trending;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.sammy.myapplication.R;
import com.sammy.myapplication.model.Repo;
import com.sammy.poweradapter.item.ItemRenderer;

import java.text.NumberFormat;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RepoRenderer implements ItemRenderer<Repo> {
    private final Provider<TrendingReposPresenter> presenterProvider;

    @Inject
    RepoRenderer(Provider<TrendingReposPresenter> presenterProvider){

        this.presenterProvider = presenterProvider;
    }
    @Override
    public int layoutRes() {
        return R.layout.view_repo_list_item;
    }

    @Override
    public View createView(@NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutRes(),parent,false);
        view.setTag(new ViewBinder(view,presenterProvider.get()));
        return view;
    }

    @Override
    public void renderer(@NonNull View itemView, @NonNull Repo item) {
        ((ViewBinder)itemView.getTag()).bind(item);
    }

    static class ViewBinder{
        @BindView(R.id.tv_repo_name)
        TextView repoNameText;
        @BindView(R.id.tv_repo_description)
        TextView repoDescriptionText;
        @BindView(R.id.tv_fork_count)
        TextView forkCountText;
        @BindView(R.id.tv_star_count)
        TextView starCountText;

        private Repo repo;
        ViewBinder(View itemView,TrendingReposPresenter presenter){
            ButterKnife.bind(this,itemView);
        }

        public void bind(Repo item) {
            this.repo = repo;
            repoNameText.setText(repo.name());
            repoDescriptionText.setText(repo.description());
            forkCountText.setText(NumberFormat.getInstance().format(repo.forksCount()));
            starCountText.setText(NumberFormat.getInstance().format(repo.stargazersCount()));
        }
    }
}
