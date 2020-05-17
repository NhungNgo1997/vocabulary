package com.example.apphoctuvung.data.model;

import java.util.ArrayList;
import java.util.List;

public class Detail {
    private String pos;
    private ArrayList<Mean> means;

    public Detail(String pos, List<Mean> means) {
        this.pos = pos;
        this.means = new ArrayList<Mean>();
        for (Mean mean : means) {
            this.means.add(mean.copy());
        }
    }

    public String getPos() {
        return pos;
    }

    public ArrayList<Mean> getMeans() {
        return means;
    }

    public Detail copy() {
        final ArrayList<Mean> newMeans = new ArrayList<Mean>();
        for (Mean mean : means) {
            newMeans.add(mean.copy());
        }
        return new Detail(this.pos, newMeans);
    }
}