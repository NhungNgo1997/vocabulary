package com.example.apphoctuvung.views.fragment;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.apphoctuvung.R;
import com.example.apphoctuvung.data.Storage;
import com.example.apphoctuvung.data.datasource.TextToSpeechDataSourceImpl;
import com.example.apphoctuvung.data.datasource.VocabularyLocalDataSource;
import com.example.apphoctuvung.data.datasource.VocabularyLocalDataSourceImpl;
import com.example.apphoctuvung.data.model.Alphabet;
import com.example.apphoctuvung.data.model.Vocabulary;
import com.example.apphoctuvung.databinding.DanhsachtuvungFragmentBinding;
import com.example.apphoctuvung.databinding.HocalphabetFragmentBinding;
import com.example.apphoctuvung.views.AppContext;
import com.example.apphoctuvung.views.VocabularyEvent;
import com.example.apphoctuvung.views.adapter.AlphabetRecyclerAdapter;


import java.util.List;
import java.util.Locale;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HocAlphabetFragment extends Fragment implements VocabularyEvent {
    private HocalphabetFragmentBinding binding;
    private AlphabetRecyclerAdapter adapter = new AlphabetRecyclerAdapter(this);
    private VocabularyLocalDataSource vocabularyLocalDataSource = new VocabularyLocalDataSourceImpl(new Storage());
    private final TextToSpeech tts = new TextToSpeech(AppContext.context, new TextToSpeech.OnInitListener() {
        @Override
        public void onInit(int status) {
            tts.setLanguage(Locale.ENGLISH);
        }
    });
    private final TextToSpeechDataSourceImpl textToSpeechDataSource = new TextToSpeechDataSourceImpl(tts);


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hocalphabet_fragment, container, false);
        binding = HocalphabetFragmentBinding.bind(view);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.gridviewLearnAlphabet.setAdapter(adapter);
        binding.gridviewLearnAlphabet.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        vocabularyLocalDataSource.readAlphabet().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Alphabet>>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {
                    }

                    @Override
                    public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull List<Alphabet> alphabets) {
                        adapter.setAlphabets(alphabets);
                        adapter.notifyDataSetChanged();
                    }



                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {

                    }
                });
    }
    @Override
    public void onSpeakPressed(String vocabulary) {
        textToSpeechDataSource.speak(vocabulary);
    }

}
