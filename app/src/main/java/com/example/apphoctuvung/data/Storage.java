package com.example.apphoctuvung.data;

import com.example.apphoctuvung.data.model.Vocabulary;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import io.reactivex.rxjava3.core.Single;
import io.realm.Realm;
import io.realm.RealmResults;

public class Storage {
    public Single<Vocabulary> save(Vocabulary vocabulary) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmResults<Vocabulary> results = realm.where(Vocabulary.class).equalTo("vocabulary", vocabulary.getVocabulary()).findAll();
        if (results.isEmpty()) {
            realm.copyToRealm(vocabulary);
            realm.commitTransaction();
        }
        realm.close();
        return Single.just(vocabulary);

    }

    public Single<Vocabulary> delete(Vocabulary vocabulary) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmResults<Vocabulary> results = realm.where(Vocabulary.class).equalTo("vocabulary", vocabulary.getVocabulary()).findAll();
        results.deleteAllFromRealm();
        realm.commitTransaction();
        realm.close();
        return Single.just(vocabulary);
    }

    public Single<Vocabulary> read(Vocabulary vocabulary) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Vocabulary result = realm.where(Vocabulary.class).equalTo("vocabulary", vocabulary.getVocabulary()).findFirst();
        realm.commitTransaction();
        realm.close();
        return Single.just(result);
    }

    public Single<List<Vocabulary>> readAll() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmResults<Vocabulary> realmResults = realm.where(Vocabulary.class).findAll();
        List<Vocabulary> results = realm.copyFromRealm(realmResults);
        Collections.reverse(results);
        realm.commitTransaction();
        realm.close();
        return Single.just(results);
    }

    public Single<Vocabulary> readRandom(){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmResults<Vocabulary> realmResults = realm.where(Vocabulary.class).findAll();
        List<Vocabulary> results = realm.copyFromRealm(realmResults);
        Collections.reverse(results);
        realm.commitTransaction();
        realm.close();
        int randomNum = ThreadLocalRandom.current().nextInt(0, results.size());
        return Single.just(results.get(randomNum));
    }
}
