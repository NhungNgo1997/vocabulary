package com.example.apphoctuvung.data.model;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Vocabulary extends RealmObject {
    private String vocabulary;
    private String ipa;

    public String getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(String vocabulary) {
        this.vocabulary = vocabulary;
    }

    public String getIpa() {
        return ipa;
    }

    public void setIpa(String ipa) {
        this.ipa = ipa;
    }

    public RealmList<Detail> getDetails() {
        return details;
    }

    public void setDetails(RealmList<Detail> details) {
        this.details = details;
    }

    public RealmList<String> getAlso() {
        return also;
    }

    public void setAlso(RealmList<String> also) {
        this.also = also;
    }

    public RealmList<String> getBrowses() {
        return browses;
    }

    public void setBrowses(RealmList<String> browses) {
        this.browses = browses;
    }

    private RealmList<Detail> details;
    private RealmList<String> also;
    private RealmList<String> browses;

}
