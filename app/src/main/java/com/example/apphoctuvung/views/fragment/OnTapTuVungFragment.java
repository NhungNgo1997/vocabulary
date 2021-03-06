package com.example.apphoctuvung.views.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.apphoctuvung.R;
import com.example.apphoctuvung.data.model.Vocabulary;
import com.example.apphoctuvung.databinding.OntaptuvungFragmentBinding;
import com.example.apphoctuvung.databinding.TratuvungFragmentBinding;
import com.example.apphoctuvung.views.App;
import com.example.apphoctuvung.views.adapter.TranslateRecyclerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class OnTapTuVungFragment extends Fragment {
    private OntaptuvungFragmentBinding binding;
    private Vocabulary vocabularyRandom;
    private final TranslateRecyclerAdapter recyclerAdapter = new TranslateRecyclerAdapter();

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = OntaptuvungFragmentBinding.bind(inflater.inflate(R.layout.ontaptuvung_fragment, container, false));
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        random();
        binding.imagevoice.setOnClickListener(v -> App.textToSpeechDataSource.speak(vocabularyRandom.getVocabulary()));
        binding.btncheck.setOnClickListener(v -> {
            check();
        });
        binding.btnnext.setOnClickListener(v -> {
            resetDs();
            random();
        });

    }

    private void random() {
        App.vocabularyRepository.readRandom().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Vocabulary>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {
                        binding.btncheck.setBackground(getResources().getDrawable(R.drawable.border_common));
                        binding.edittu.setText("");
                    }

                    @Override
                    public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull Vocabulary vocabulary) {
                        vocabularyRandom = vocabulary;
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {

                    }
                });
    }

    private void check() {
        final String userInput = binding.edittu.getText().toString();
        if (userInput.isEmpty()) {
        } else if (vocabularyRandom != null && userInput.toLowerCase().trim().compareTo(vocabularyRandom.getVocabulary().trim().toLowerCase()) == 0) {
            binding.btncheck.setBackground(getResources().getDrawable(R.drawable.border_green));
            ds();
        } else {
            binding.btncheck.setBackground(getResources().getDrawable(R.drawable.border_red));
        }
    }

    private void resetDs() {
        vocabularyRandom = null;
        recyclerAdapter.setDetails(Collections.emptyList());
        recyclerAdapter.notifyDataSetChanged();
    }

    private void ds() {
        binding.listTranslate.setAdapter(recyclerAdapter);
        binding.listTranslate.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        if (vocabularyRandom != null && vocabularyRandom.getDetails() != null && !vocabularyRandom.getDetails().isEmpty()) {
            recyclerAdapter.setDetails(vocabularyRandom.getDetails());
            recyclerAdapter.notifyDataSetChanged();
        }
    }
}
