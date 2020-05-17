package com.example.apphoctuvung.data.datasource;

import com.example.apphoctuvung.data.Services;
import com.example.apphoctuvung.data.model.Vocabulary;

import io.reactivex.rxjava3.core.Observable;

public class VocabularyRemoteDataSourceImpl implements VocabularyRemoteDataSource {
    private Services services;

    VocabularyRemoteDataSourceImpl(Services services) {
        this.services = services;
    }

    @Override
    public Observable<Vocabulary> translate(String vocabulary) {
        return services.translate(vocabulary);
    }
}