package com.example.apphoctuvung.views;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.apphoctuvung.R;
import com.example.apphoctuvung.data.model.Vocabulary;
import com.example.apphoctuvung.databinding.VocabularyDetailsBinding;
import com.example.apphoctuvung.views.adapter.VocabularyDetailsRecyclerAdapter;
import com.google.gson.Gson;

public class VocabularyDetails extends AppCompatActivity {
    private VocabularyDetailsBinding binding;
    private final VocabularyDetailsRecyclerAdapter vocabularyDetailsRecyclerAdapter = new VocabularyDetailsRecyclerAdapter();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = VocabularyDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ds();
    }


    private void ds() {
        Gson gson = new Gson();
        Vocabulary vo = gson.fromJson(getIntent().getStringExtra("myjson"), Vocabulary.class);
        binding.vocabulary.setText(vo.getVocabulary());
        binding.listTranslate.setAdapter(vocabularyDetailsRecyclerAdapter);
        binding.listTranslate.setLayoutManager(new LinearLayoutManager(getParent(), LinearLayoutManager.VERTICAL, false));
        if (vo != null && vo.getDetails() != null && !vo.getDetails().isEmpty()) {
            vocabularyDetailsRecyclerAdapter.setDetails(vo.getDetails());
            vocabularyDetailsRecyclerAdapter.notifyDataSetChanged();
        }
    }


}
