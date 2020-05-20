package com.example.apphoctuvung.data.model;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Mean extends RealmObject {
    private String mean;
    private RealmList<String> example;

    public String getMean() {
        return mean;
    }

    public RealmList<String> getExample() {
        return example;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public void setExample(RealmList<String> example) {
        this.example = example;
    }
}
