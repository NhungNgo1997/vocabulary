package com.example.apphoctuvung.views.fragment;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
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
import com.example.apphoctuvung.data.ApiUrl;
import com.example.apphoctuvung.data.Services;
import com.example.apphoctuvung.data.datasource.TextToSpeechDataSourceImpl;
import com.example.apphoctuvung.data.datasource.VocabularyRemoteDataSource;
import com.example.apphoctuvung.data.datasource.VocabularyRemoteDataSourceImpl;
import com.example.apphoctuvung.data.model.Vocabulary;
import com.example.apphoctuvung.databinding.TratuvungFragmentBinding;
import com.example.apphoctuvung.repositories.VocabularyRepository;
import com.example.apphoctuvung.repositories.VocabularyRepositoryImpl;
import com.example.apphoctuvung.views.AppContext;
import com.example.apphoctuvung.views.adapter.TranslateRecyclerAdapter;

import java.util.Locale;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TraTuVungFragment extends Fragment {
    private TratuvungFragmentBinding binding;
    private final Services services = new Retrofit.Builder()
            .baseUrl(ApiUrl.baseDomain)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Services.class);
    private final VocabularyRemoteDataSource vocabularyRemoteDataSource = new VocabularyRemoteDataSourceImpl(services);
    private final VocabularyRepository vocabularyRepository = new VocabularyRepositoryImpl(vocabularyRemoteDataSource);
    private final TranslateRecyclerAdapter recyclerAdapter = new TranslateRecyclerAdapter();
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
                    vocabularyRepository.remoteTranslate(keyWord)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new SingleObserver<Vocabulary>() {
                                @Override
                                public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {
                                }

                                @Override
                                public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull Vocabulary vocabulary) {
                                    binding.ipa.setText(vocabulary.getIpa());
                                    binding.ipa.setHint(vocabulary.getVocabulary());
                                    recyclerAdapter.setDetails(vocabulary.getDetails());
                                    recyclerAdapter.notifyDataSetChanged();
                                    binding.traTuVungProcessBar.setVisibility(View.GONE);
                                    binding.speaker.setVisibility(View.VISIBLE);
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
                textToSpeechDataSource.speak(String.valueOf(binding.ipa.getHint()));
            }
        });


    }
}
