package com.example.apphoctuvung.repositories;

import com.example.apphoctuvung.data.model.Vocabulary;

import io.reactivex.rxjava3.core.Single;


public interface VocabularyRepository {
    Single<Vocabulary> remoteTranslate(String vocabulary);
}
