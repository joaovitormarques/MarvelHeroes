package com.example.joaovitor.marvel.main.hero;

import android.support.annotation.NonNull;

import com.example.joaovitor.shared.model.APICharacter;

import java.util.List;

/**
 * Created by joaovitor on 31/08/17.
 */

public interface HeroView {
    void showLoading();
    void dismissLoading();
    void showHeroes(@NonNull List<APICharacter> list);
    void showTryAgain();
}
