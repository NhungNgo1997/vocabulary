package com.example.apphoctuvung.data.datasource;

import com.example.apphoctuvung.data.model.Alphabet;
import com.example.apphoctuvung.data.model.Vocabulary;

import java.util.List;

import io.reactivex.rxjava3.core.Single;


public interface VocabularyLocalDataSource {
    Single save(Vocabulary vocabulary);

    Single delete(Vocabulary vocabulary);

    Single<Vocabulary> read(Vocabulary vocabulary);

    Single<List<Vocabulary>> readAll();
    Single<List<Alphabet>> readAlphabet();
}

