package com.example.apphoctuvung.data.model;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Detail extends RealmObject {
    private String pos;
    private RealmList<Mean> means;

    public String getPos() {
        return pos;
    }

    public RealmList<Mean> getMeans() {
        return means;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public void setMeans(RealmList<Mean> means) {
        this.means = means;
    }
}