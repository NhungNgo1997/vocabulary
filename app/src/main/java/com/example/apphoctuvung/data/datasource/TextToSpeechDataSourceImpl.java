package com.example.apphoctuvung.data.datasource;

import android.speech.tts.TextToSpeech;

public class TextToSpeechDataSourceImpl implements TextToSpeechDataSource {
    final private TextToSpeech tts;

    public TextToSpeechDataSourceImpl(TextToSpeech tts) {
        this.tts = tts;
    }

    @Override
    public void speak(String vocabulary) {
        tts.stop();
        tts.speak(vocabulary, TextToSpeech.QUEUE_FLUSH, null, "");
    }
}
