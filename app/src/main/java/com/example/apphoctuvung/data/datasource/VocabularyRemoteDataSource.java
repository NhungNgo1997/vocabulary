package com.example.apphoctuvung.data.datasource;

import com.example.apphoctuvung.data.model.Vocabulary;

import io.reactivex.rxjava3.core.Single;

public interface VocabularyRemoteDataSource {
    public Single<Vocabulary> translate(String vocabulary);
}
