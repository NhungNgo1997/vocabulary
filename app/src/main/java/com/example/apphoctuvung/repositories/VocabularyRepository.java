package com.example.apphoctuvung.repositories;

import com.example.apphoctuvung.data.model.Vocabulary;

import io.reactivex.rxjava3.core.Observable;


public interface VocabularyRepository {
    Observable<Vocabulary> remoteTranslate(String vocabulary);
}
