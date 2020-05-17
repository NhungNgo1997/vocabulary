package com.example.apphoctuvung.data.datasource;

import com.example.apphoctuvung.data.model.Vocabulary;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;


public interface VocabularyLocalDataSource {
    Observable save(Vocabulary vocabulary);

    Observable delete(Vocabulary vocabulary);

    Observable<Vocabulary> read(Vocabulary vocabulary);

    Observable<List<Vocabulary>> readAll();
}

