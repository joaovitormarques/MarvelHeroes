package com.example.joaovitor.marvel.main.hero;

import android.graphics.Bitmap;

import com.example.joaovitor.marvel.BuildConfig;
import com.example.joaovitor.marvel.main.MainView;
import com.example.joaovitor.shared.HashGenerator;
import com.example.joaovitor.shared.network.HeroService;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by joaovitor on 31/08/17.
 */

public class HeroPresenter {


    private HeroView heroView;
    private HeroService heroService;

    HeroPresenter(HeroView heroView, HeroService heroService) {
        this.heroView = heroView;
        this.heroService = heroService;
    }

    public void startRequest() {

        HashGenerator hashGenerator = new HashGenerator(BuildConfig.api_key, BuildConfig.api_private_key);

        heroService.getCharacters(hashGenerator.getPublicKey(), hashGenerator.getHashMD5(), hashGenerator.getTimestamp())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(() -> heroView.showLoading())
                .doAfterTerminate(() -> heroView.dismissLoading())
                .subscribe(apiAnswer -> {
                    heroView.showHeroes(apiAnswer.data.results);
                }, throwable -> {
                    heroView.showTryAgain();
                });
    }
}
