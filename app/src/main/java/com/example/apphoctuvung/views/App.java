package com.example.apphoctuvung.views;

import android.app.Application;
import android.speech.tts.TextToSpeech;

import com.example.apphoctuvung.data.ApiUrl;
import com.example.apphoctuvung.data.Services;
import com.example.apphoctuvung.data.Storage;
import com.example.apphoctuvung.data.datasource.TextToSpeechDataSourceImpl;
import com.example.apphoctuvung.data.datasource.VocabularyLocalDataSource;
import com.example.apphoctuvung.data.datasource.VocabularyLocalDataSourceImpl;
import com.example.apphoctuvung.data.datasource.VocabularyRemoteDataSource;
import com.example.apphoctuvung.data.datasource.VocabularyRemoteDataSourceImpl;
import com.example.apphoctuvung.repositories.VocabularyRepository;
import com.example.apphoctuvung.repositories.VocabularyRepositoryImpl;

import java.util.Locale;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.realm.Realm;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    final private static Services services = new Retrofit.Builder()
            .baseUrl(ApiUrl.baseDomain)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Services.class);
    final private static VocabularyRemoteDataSource vocabularyRemoteDataSource = new VocabularyRemoteDataSourceImpl(services);
    final private static VocabularyLocalDataSource vocabularyLocalDataSource = new VocabularyLocalDataSourceImpl(new Storage());
    public final static VocabularyRepository vocabularyRepository = new VocabularyRepositoryImpl(vocabularyRemoteDataSource, vocabularyLocalDataSource);
    static TextToSpeech tts;
    public static TextToSpeechDataSourceImpl textToSpeechDataSource;

    @Override
    public void onCreate() {
        super.onCreate();
        AppContext.context = getApplicationContext();
        Realm.init(AppContext.context);
        App.tts = new TextToSpeech(AppContext.context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                tts.setLanguage(Locale.ENGLISH);
            }
        });
        App.textToSpeechDataSource = new TextToSpeechDataSourceImpl(tts);
    }
}
