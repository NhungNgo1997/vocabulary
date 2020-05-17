package com.example.apphoctuvung.repositories;

import com.example.apphoctuvung.data.datasource.VocabularyRemoteDataSource;
import com.example.apphoctuvung.data.model.Vocabulary;

import io.reactivex.rxjava3.core.Single;

public class VocabularyRepositoryImpl implements VocabularyRepository {
    private VocabularyRemoteDataSource dataSource;

    public VocabularyRepositoryImpl(VocabularyRemoteDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Single<Vocabulary> remoteTranslate(String vocabulary) {
        return dataSource.translate(vocabulary);
    }
}