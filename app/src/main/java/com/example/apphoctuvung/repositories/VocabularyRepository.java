package com.example.apphoctuvung.repositories;

import com.example.apphoctuvung.data.model.Alphabet;
import com.example.apphoctuvung.data.model.Vocabulary;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;


public interface VocabularyRepository {
    Single<Vocabulary> remoteTranslate(String vocabulary);

    Single<Vocabulary> save(Vocabulary vocabulary);

    Single<Vocabulary> delete(Vocabulary vocabulary);

    Single<Vocabulary> read(Vocabulary vocabulary);

    Single<List<Vocabulary>> readAll();

    Single<List<Alphabet>> readAlphabet();

    Single<Vocabulary> readRandom();


}
