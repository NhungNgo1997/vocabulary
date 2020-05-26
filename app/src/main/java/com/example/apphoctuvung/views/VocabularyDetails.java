package com.example.apphoctuvung.views;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.apphoctuvung.R;
import com.example.apphoctuvung.data.model.Vocabulary;
import com.example.apphoctuvung.databinding.VocabularyDetailsBinding;
import com.example.apphoctuvung.views.adapter.VocabularyDetailsRecyclerAdapter;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class VocabularyDetails extends AppCompatActivity {
    private VocabularyDetailsBinding binding;
    private Vocabulary listVocabulary;
    private final  VocabularyDetailsRecyclerAdapter vocabularyDetailsRecyclerAdapter= new VocabularyDetailsRecyclerAdapter();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= VocabularyDetailsBinding.inflate(getLayoutInflater());
        setContentView(R.layout.vocabulary_details);
         binding.getRoot();


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        binding.listTranslate.setAdapter(vocabularyDetailsRecyclerAdapter);
        binding.listTranslate.setLayoutManager(new LinearLayoutManager(getApplicationContext()
                , LinearLayoutManager.VERTICAL, false));






        binding.speaker.setOnClickListener(v -> App.textToSpeechDataSource.speak(listVocabulary.getVocabulary()));


    }
}
