package com.example.apphoctuvung.data.model;

import java.io.Serializable;

public class Alphabet implements Serializable {

    private String nameAlphabet;
    private String spellAlphabet;


    public Alphabet(String nameAlphabet, String spellAlphabet) {
        this.nameAlphabet = nameAlphabet;
        this.spellAlphabet = spellAlphabet;
    }

    public String getNameAlphabet() {
        return nameAlphabet;
    }

    public void setNameAlphabet(String nameAlphabet) {
        this.nameAlphabet = nameAlphabet;
    }

    public String getSpellAlphabet() {
        return spellAlphabet;
    }

    public void setSpellAlphabet(String spellAlphabet) {
        this.spellAlphabet = spellAlphabet;
    }
}
