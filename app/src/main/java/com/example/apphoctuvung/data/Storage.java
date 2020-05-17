package com.example.apphoctuvung.data;

import com.example.apphoctuvung.data.model.Vocabulary;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public class Storage {
    public Single save(Vocabulary vocabulary) {
        return null;
    }

    public Single delete(Vocabulary vocabulary) {
        return null;
    }

    public Single<Vocabulary> read(Vocabulary vocabulary) {
        return null;
    }

    public Single<List<Vocabulary>> readAll() {
        return null;
    }
}
