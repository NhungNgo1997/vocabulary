package com.example.apphoctuvung.data.datasource;

import com.example.apphoctuvung.data.model.Vocabulary;

import io.reactivex.rxjava3.core.Observable;

public interface VocabularyRemoteDataSource {
    public Observable<Vocabulary> translate(String vocabulary);
}
