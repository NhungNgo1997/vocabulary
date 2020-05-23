package com.example.apphoctuvung.views;

import com.example.apphoctuvung.data.model.Vocabulary;

public interface VocabularyEvent {
    void onSpeakPressed(String vocabulary);

    void onItemPressed(Vocabulary vocabulary);
}