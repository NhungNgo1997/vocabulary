package com.example.apphoctuvung.data.model;

import java.util.ArrayList;
import java.util.List;

public class Mean {
    private String mean;
    private List<String> example;

    public Mean(String mean, List<String> example) {
        this.mean = mean;
        this.example = example;
    }

    public String getMean() {
        return mean;
    }

    public List<String> getExample() {
        return example;
    }
}
