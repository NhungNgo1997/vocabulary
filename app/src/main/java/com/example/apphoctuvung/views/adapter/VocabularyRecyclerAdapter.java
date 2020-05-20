package com.example.apphoctuvung.views.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.example.apphoctuvung.R;
import com.example.apphoctuvung.data.model.Vocabulary;
import com.example.apphoctuvung.databinding.VocabularyItemBinding;
import com.example.apphoctuvung.views.App;
import com.example.apphoctuvung.views.VocabularyEvent;

import java.util.ArrayList;
import java.util.List;

public class VocabularyRecyclerAdapter extends RecyclerView.Adapter<VocabularyRecyclerAdapter.MyViewHolder> {
    private VocabularyEvent event;
    private ArrayList<Vocabulary> vocabularies = new ArrayList<>();

    public VocabularyRecyclerAdapter(VocabularyEvent event) {
        this.event = event;
    }

    public void setVocabularies(List<Vocabulary> vocabularies) {
        this.vocabularies.clear();
        this.vocabularies.addAll(vocabularies);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View view = layoutInflater.inflate(R.layout.vocabulary_item, parent, false);
        return new MyViewHolder(VocabularyItemBinding.bind(view));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding();
    }

    @Override
    public int getItemCount() {
        return vocabularies.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private VocabularyItemBinding viewBinding;

        MyViewHolder(VocabularyItemBinding viewBinding) {
            super(viewBinding.getRoot().getRootView());
            this.viewBinding = viewBinding;
        }

        void binding() {
            viewBinding.vocabulary.setText(vocabularies.get(getAdapterPosition()).getVocabulary());
            viewBinding.ipa.setText(vocabularies.get(getAdapterPosition()).getIpa());
            viewBinding.pos.setText(vocabularies.get(getAdapterPosition()).getDetails().get(0).getPos());
            viewBinding.mean.setText(vocabularies.get(getAdapterPosition()).getDetails().get(0).getMeans().get(0).getMean());
            viewBinding.speaker.setOnClickListener(v -> event.onSpeakPressed(vocabularies.get(getAdapterPosition()).getVocabulary()));
            viewBinding.vocabularyItem.setSwipeListener(new SwipeRevealLayout.SwipeListener() {
                @Override
                public void onClosed(SwipeRevealLayout view) {

                }

                @Override
                public void onOpened(SwipeRevealLayout view) {
                    viewBinding.delete.setOnClickListener(v -> {
                        App.vocabularyRepository.delete(vocabularies.get(getAdapterPosition()));
                        vocabularies.remove(getAdapterPosition());
                        viewBinding.vocabularyItem.close(true);
                        notifyDataSetChanged();
                    });
                }

                @Override
                public void onSlide(SwipeRevealLayout view, float slideOffset) {

                }
            });

        }
    }
}