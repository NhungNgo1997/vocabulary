package com.example.apphoctuvung.data.model;

import java.util.ArrayList;
import java.util.List;

public class Detail {
    private String pos;
    private List<Mean> means;

    public Detail(String pos, List<Mean> means) {
        this.pos = pos;
        this.means = means;
    }

    public String getPos() {
        return pos;
    }

    public List<Mean> getMeans() {
        return means;
    }
}