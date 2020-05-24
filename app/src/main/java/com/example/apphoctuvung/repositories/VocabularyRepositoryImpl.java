package com.example.apphoctuvung.repositories;

import com.example.apphoctuvung.data.datasource.VocabularyLocalDataSource;
import com.example.apphoctuvung.data.datasource.VocabularyRemoteDataSource;
import com.example.apphoctuvung.data.model.Alphabet;
import com.example.apphoctuvung.data.model.Vocabulary;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Single;

public class VocabularyRepositoryImpl implements VocabularyRepository {
    private VocabularyRemoteDataSource remoteDataSource;
    private VocabularyLocalDataSource localDataSource;

    public VocabularyRepositoryImpl(VocabularyRemoteDataSource remoteDataSource, VocabularyLocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    @Override
    public Single<Vocabulary> remoteTranslate(String vocabulary) {
        return remoteDataSource.translate(vocabulary);
    }

    @Override
    public Single<Vocabulary> save(Vocabulary vocabulary) {
        return localDataSource.save(vocabulary);
    }

    @Override
    public Single<Vocabulary> delete(Vocabulary vocabulary) {
        return localDataSource.delete(vocabulary);
    }

    @Override
    public Single<Vocabulary> read(Vocabulary vocabulary) {
        return localDataSource.read(vocabulary);
    }

    @Override
    public Single<List<Vocabulary>> readAll() {
        return localDataSource.readAll();
    }

    @Override
    public Single<List<Alphabet>> readAlphabet() {
        return localDataSource.readAlphabet();
    }

    @Override
    public Single<Vocabulary> readRandom() {
      return localDataSource.readRandom();
    }
}