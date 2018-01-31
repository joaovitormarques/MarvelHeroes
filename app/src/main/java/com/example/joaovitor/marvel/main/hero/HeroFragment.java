package com.example.joaovitor.marvel.main.hero;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.joaovitor.marvel.R;
import com.example.joaovitor.marvel.main.HeroAdapter;
import com.example.joaovitor.shared.model.APICharacter;
import com.example.joaovitor.shared.network.HeroService;
import com.example.joaovitor.shared.network.RetroFitManager;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by joaovitor on 31/08/17.
 */

public class HeroFragment extends Fragment implements HeroView{

    public HeroFragment() {
    }

    @Bind(R.id.hero_list)
    RecyclerView heroList;

    @Bind(R.id.loading_view)
    LinearLayout loadingView;

    @Bind(R.id.box_try_again_view)
    RelativeLayout tryAgainView;

    private HeroPresenter heroPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hero, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        heroPresenter = new HeroPresenter(this, RetroFitManager.getInstance().createService(HeroService.class));
        heroPresenter.startRequest();
    }

    @Override
    public void showLoading() {
        loadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissLoading() {
        loadingView.setVisibility(View.GONE);
    }

    @Override
    public void showHeroes(@NonNull List<APICharacter> list) {
        HeroAdapter heroAdapter = new HeroAdapter(list);
        heroList.setLayoutManager(new GridLayoutManager(getContext(), 2));
        heroList.setAdapter(heroAdapter);
    }

    @Override
    public void showTryAgain() {
        tryAgainView.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.try_again_button)
    void onClickTryAgain(){
        tryAgainView.setVisibility(View.GONE);
        heroPresenter.startRequest();
    }
}
