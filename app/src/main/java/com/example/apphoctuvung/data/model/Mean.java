package com.example.apphoctuvung.data.model;

import java.util.ArrayList;

public class Mean {
    private String mean;
    private ArrayList<String> example;

    public Mean(String mean, ArrayList<String> example) {
        this.mean = mean;
        this.example = new ArrayList<String>(example);
    }

    public String getMean() {
        return mean;
    }

    public ArrayList<String> getExample() {
        return example;
    }

    public Mean copy() {
        final ArrayList<String> newExample = new ArrayList<String>(this.example);
        return new Mean(this.mean, newExample);
    }

}
