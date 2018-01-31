package com.example.joaovitor.shared.network;

import com.example.joaovitor.shared.model.APIAnswer;
import com.example.joaovitor.shared.model.APICharacter;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by joaovitor on 31/08/17.
 */

public interface HeroService {
    @GET("v1/public/characters")
    Observable<APIAnswer<APICharacter>> getCharacters(
            @Query("apikey")String apiKey,
            @Query("hash")String hash,
            @Query("ts") long timestamp);
}
