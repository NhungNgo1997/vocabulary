package com.example.apphoctuvung.repositories;

import com.example.apphoctuvung.data.datasource.VocabularyRemoteDataSource;
import com.example.apphoctuvung.data.model.Vocabulary;

import io.reactivex.rxjava3.core.Observable;

public class VocabularyRepositoryImpl implements VocabularyRepository {
    private VocabularyRemoteDataSource dataSource;

    VocabularyRepositoryImpl(VocabularyRemoteDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Observable<Vocabulary> remoteTranslate(String vocabulary) {
        return dataSource.translate(vocabulary);
    }
}