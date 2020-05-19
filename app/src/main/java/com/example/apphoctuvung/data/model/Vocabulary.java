package com.example.apphoctuvung.data.model;

import java.util.ArrayList;
import java.util.List;

public class Vocabulary {
    private String vocabulary;
    private String ipa;
    private List<Detail> details;
    private List<String> also;
    private List<String> browses;

    public Vocabulary(String vocabulary, String ipa, List<Detail> details, List<String> also, List<String> browses) {
        this.vocabulary = vocabulary;
        this.ipa = ipa;
        this.details = details;
        this.also = also;
        this.browses = browses;
    }

    public String getVocabulary() {
        return vocabulary;
    }

    public String getIpa() {
        return ipa;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public List<String> getAlso() {
        return also;
    }

    public List<String> getBrowses() {
        return browses;
    }
}
