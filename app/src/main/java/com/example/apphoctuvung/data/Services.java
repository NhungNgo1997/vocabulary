package com.example.apphoctuvung.data;

import com.example.apphoctuvung.data.model.Vocabulary;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Services {
    @GET(ApiUrl.translatePath)
    Observable<Vocabulary> translate(@Path("vocabulary") String vocabulary);
}

