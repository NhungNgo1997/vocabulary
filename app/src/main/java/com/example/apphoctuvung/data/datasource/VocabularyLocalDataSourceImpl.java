package com.example.apphoctuvung.data.datasource;

import com.example.apphoctuvung.data.Storage;
import com.example.apphoctuvung.data.model.Vocabulary;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class VocabularyLocalDataSourceImpl implements VocabularyLocalDataSource {
    private Storage storage;

    VocabularyLocalDataSourceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public Observable save(Vocabulary vocabulary) {
        return storage.save(vocabulary);
    }

    @Override
    public Observable delete(Vocabulary vocabulary) {
        return storage.delete(vocabulary);
    }

    @Override
    public Observable<Vocabulary> read(Vocabulary vocabulary) {
        return storage.read(vocabulary);
    }

    @Override
    public Observable<List<Vocabulary>> readAll() {
        return storage.readAll();
    }
}
