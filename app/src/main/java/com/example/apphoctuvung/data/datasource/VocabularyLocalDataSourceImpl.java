package com.example.apphoctuvung.data.datasource;

import com.example.apphoctuvung.data.Storage;
import com.example.apphoctuvung.data.model.Detail;
import com.example.apphoctuvung.data.model.Mean;
import com.example.apphoctuvung.data.model.Vocabulary;

import java.util.Arrays;
import java.util.List;

import io.reactivex.rxjava3.core.Single;

public class VocabularyLocalDataSourceImpl implements VocabularyLocalDataSource {
    private Storage storage;

    public VocabularyLocalDataSourceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public Single save(Vocabulary vocabulary) {
        return storage.save(vocabulary);
    }

    @Override
    public Single delete(Vocabulary vocabulary) {
        return storage.delete(vocabulary);
    }

    @Override
    public Single<Vocabulary> read(Vocabulary vocabulary) {
        return storage.read(vocabulary);
    }

    @Override
    public Single<List<Vocabulary>> readAll() {
        return Single.just(Arrays.asList(new Vocabulary("Hello", "\"/həˈləu/\"", Arrays.asList(new Detail("Noun", Arrays.asList(new Mean("", Arrays.asList(""))))), Arrays.asList(""), Arrays.asList("")),
                new Vocabulary("Hello", "\"/həˈləu/\"", Arrays.asList(new Detail("Noun", Arrays.asList(new Mean("", Arrays.asList(""))))), Arrays.asList(""), Arrays.asList("")),
                new Vocabulary("Hello", "\"/həˈləu/\"", Arrays.asList(new Detail("Noun", Arrays.asList(new Mean("", Arrays.asList(""))))), Arrays.asList(""), Arrays.asList("")),
                new Vocabulary("Hello", "\"/həˈləu/\"", Arrays.asList(new Detail("Noun", Arrays.asList(new Mean("", Arrays.asList(""))))), Arrays.asList(""), Arrays.asList("")),
                new Vocabulary("Hello", "\"/həˈləu/\"", Arrays.asList(new Detail("Noun", Arrays.asList(new Mean("", Arrays.asList(""))))), Arrays.asList(""), Arrays.asList("")),
                new Vocabulary("Hello", "\"/həˈləu/\"", Arrays.asList(new Detail("Noun", Arrays.asList(new Mean("", Arrays.asList(""))))), Arrays.asList(""), Arrays.asList("")),
                new Vocabulary("Hello", "\"/həˈləu/\"", Arrays.asList(new Detail("Noun", Arrays.asList(new Mean("", Arrays.asList(""))))), Arrays.asList(""), Arrays.asList("")),
                new Vocabulary("Hello", "\"/həˈləu/\"", Arrays.asList(new Detail("Noun", Arrays.asList(new Mean("", Arrays.asList(""))))), Arrays.asList(""), Arrays.asList("")),
                new Vocabulary("Hello", "\"/həˈləu/\"", Arrays.asList(new Detail("Noun", Arrays.asList(new Mean("", Arrays.asList(""))))), Arrays.asList(""), Arrays.asList("")),
                new Vocabulary("Hello", "\"/həˈləu/\"", Arrays.asList(new Detail("Noun", Arrays.asList(new Mean("", Arrays.asList(""))))), Arrays.asList(""), Arrays.asList(""))));
    }
}
