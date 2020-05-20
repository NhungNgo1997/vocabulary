package com.example.apphoctuvung.data.datasource;

import com.example.apphoctuvung.data.Storage;
import com.example.apphoctuvung.data.model.Alphabet;
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
        return Single.just(Arrays.asList(new Vocabulary("Hello", "\"/həˈləu/\"", Arrays.asList(new Detail("Noun", Arrays.asList(new Mean("xin chào", Arrays.asList(""))))), Arrays.asList(""), Arrays.asList("")),
                new Vocabulary("Hello", "\"/həˈləu/\"", Arrays.asList(new Detail("Noun", Arrays.asList(new Mean("xin chào", Arrays.asList(""))))), Arrays.asList(""), Arrays.asList("")),
                new Vocabulary("Hello", "\"/həˈləu/\"", Arrays.asList(new Detail("Noun", Arrays.asList(new Mean("xin chào", Arrays.asList(""))))), Arrays.asList(""), Arrays.asList("")),
                new Vocabulary("Hello", "\"/həˈləu/\"", Arrays.asList(new Detail("Noun", Arrays.asList(new Mean("xin chào", Arrays.asList(""))))), Arrays.asList(""), Arrays.asList("")),
                new Vocabulary("Hello", "\"/həˈləu/\"", Arrays.asList(new Detail("Noun", Arrays.asList(new Mean("xin chào", Arrays.asList(""))))), Arrays.asList(""), Arrays.asList("")),
                new Vocabulary("Hello", "\"/həˈləu/\"", Arrays.asList(new Detail("Noun", Arrays.asList(new Mean("xin chào", Arrays.asList(""))))), Arrays.asList(""), Arrays.asList("")),
                new Vocabulary("Hello", "\"/həˈləu/\"", Arrays.asList(new Detail("Noun", Arrays.asList(new Mean("xin chào", Arrays.asList(""))))), Arrays.asList(""), Arrays.asList("")),
                new Vocabulary("Hello", "\"/həˈləu/\"", Arrays.asList(new Detail("Noun", Arrays.asList(new Mean("xin chào", Arrays.asList(""))))), Arrays.asList(""), Arrays.asList("")),
                new Vocabulary("Hello", "\"/həˈləu/\"", Arrays.asList(new Detail("Noun", Arrays.asList(new Mean("xin chào", Arrays.asList(""))))), Arrays.asList(""), Arrays.asList("")),
                new Vocabulary("Hello", "\"/həˈləu/\"", Arrays.asList(new Detail("Noun", Arrays.asList(new Mean("xin chào", Arrays.asList(""))))), Arrays.asList(""), Arrays.asList(""))));
    }
@Override
    public Single<List<Alphabet>> readAlphabet(){
        return Single.just(Arrays.asList(new Alphabet("A","/eɪ/"),
                new Alphabet("B","/biː/"),
                new Alphabet("C","/siː/"),
                new Alphabet("D","/diː/"),
                new Alphabet("E","/iː/"),
                new Alphabet("F","/ɛf/"),
                new Alphabet("G","/dʒiː/"),
                new Alphabet("H","/eɪtʃ/"),
                new Alphabet("I","/aɪ/"),
                new Alphabet("J","/dʒeɪ/"),
                new Alphabet("K","/keɪ/"),
                new Alphabet("L","/ɛl/"),
                new Alphabet("M","/ɛm/"),
                new Alphabet("N","/ɛn/"),
                new Alphabet("O","/oʊ/"),
                new Alphabet("P","/piː/"),
                new Alphabet("Q","/kjuː/"),
                new Alphabet("R","/ɑr/"),
                new Alphabet("S","/ɛs/"),
                new Alphabet("T","/tiː/"),
                new Alphabet("U","/juː/"),
                new Alphabet("V","/viː/"),
                new Alphabet("W","/ˈdʌbəl.juː/"),
                new Alphabet("X","/ɛks/"),
                new Alphabet("Y","/waɪ/"),
                new Alphabet("Z","/zɛd/")));

    }
}
