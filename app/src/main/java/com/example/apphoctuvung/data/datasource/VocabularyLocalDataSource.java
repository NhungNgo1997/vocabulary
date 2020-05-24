package com.example.apphoctuvung.data.datasource;

import com.example.apphoctuvung.data.model.Alphabet;
import com.example.apphoctuvung.data.model.Vocabulary;

import java.util.List;

import io.reactivex.rxjava3.core.Single;


public interface VocabularyLocalDataSource {
    Single<Vocabulary> save(Vocabulary vocabulary);

    Single<Vocabulary> delete(Vocabulary vocabulary);

    Single<Vocabulary> read(Vocabulary vocabulary);

    Single<List<Vocabulary>> readAll();

    Single<List<Alphabet>> readAlphabet();

    Single<Vocabulary> readRandom();
}

