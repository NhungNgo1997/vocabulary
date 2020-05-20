package com.example.apphoctuvung.views.fragment;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.apphoctuvung.R;
import com.example.apphoctuvung.data.model.Vocabulary;
import com.example.apphoctuvung.databinding.TratuvungFragmentBinding;
import com.example.apphoctuvung.views.App;
import com.example.apphoctuvung.views.adapter.TranslateRecyclerAdapter;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TraTuVungFragment extends Fragment {
    private TratuvungFragmentBinding binding;
    private Vocabulary lastVocabulary;
    private final TranslateRecyclerAdapter recyclerAdapter = new TranslateRecyclerAdapter();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.tratuvung_fragment, container, false);
        binding = TratuvungFragmentBinding.bind(view);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding.listTranslate.setAdapter(recyclerAdapter);
        binding.listTranslate.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        binding.inputVocabulary.setOnEditorActionListener(new EditText.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    final String keyWord = v.getText().toString();
                    binding.traTuVungProcessBar.setVisibility(View.VISIBLE);
                    App.vocabularyRepository.remoteTranslate(keyWord)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new SingleObserver<Vocabulary>() {
                                @Override
                                public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {
                                }

                                @Override
                                public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull Vocabulary vocabulary) {
                                    binding.ipa.setText(vocabulary.getIpa());
                                    recyclerAdapter.setDetails(vocabulary.getDetails());
                                    recyclerAdapter.notifyDataSetChanged();
                                    binding.traTuVungProcessBar.setVisibility(View.GONE);
                                    binding.speaker.setVisibility(View.VISIBLE);
                                    binding.star.setVisibility(View.VISIBLE);
                                    lastVocabulary = vocabulary;
                                }

                                @Override
                                public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                                    binding.traTuVungProcessBar.setVisibility(View.GONE);
                                }
                            });
                }
                return false;
            }
        });
        binding.speaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.textToSpeechDataSource.speak(lastVocabulary.getVocabulary());
            }
        });
        binding.star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.vocabularyRepository.save(lastVocabulary);
            }
        });

    }
}
