package com.example.joaovitor.marvel.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.example.joaovitor.marvel.R;
import com.example.joaovitor.marvel.main.favorite.FavoriteFragment;
import com.example.joaovitor.marvel.main.hero.HeroFragment;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by joaovitor on 30/08/17.
 */

public class MainActivity extends AppCompatActivity implements MainView {

    @Bind(R.id.tabs)
    TabLayout tabLayout;

    @Bind(R.id.view_pager)
    ViewPager viewPager;

    private HeroFragment heroFragment;
    private FavoriteFragment favoriteFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setUp();
    }

    private void setUp() {
        heroFragment = new HeroFragment();
        favoriteFragment = new FavoriteFragment();
        FragmentsAdapter fragmentsAdapter = new FragmentsAdapter(getSupportFragmentManager());
        fragmentsAdapter.add(heroFragment, getString(R.string.principal_title));
        fragmentsAdapter.add(favoriteFragment, getString(R.string.favorite_title));
        viewPager.setAdapter(fragmentsAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}
