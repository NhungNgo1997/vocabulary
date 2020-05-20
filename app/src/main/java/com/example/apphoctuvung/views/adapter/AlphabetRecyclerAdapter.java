package com.example.apphoctuvung.views.adapter;





import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apphoctuvung.R;
import com.example.apphoctuvung.data.model.Alphabet;

import com.example.apphoctuvung.databinding.AlphabetItemBinding;
import com.example.apphoctuvung.views.VocabularyEvent;


import java.util.ArrayList;
import java.util.List;

public class AlphabetRecyclerAdapter extends RecyclerView.Adapter<AlphabetRecyclerAdapter.MyViewHolder> {
    private VocabularyEvent event;
    private ArrayList<Alphabet> alphabets = new ArrayList<Alphabet>();

    public AlphabetRecyclerAdapter(VocabularyEvent event) {
        this.event = event;
    }

    public void setAlphabets(List<Alphabet> alphabets) {
        this.alphabets.clear();
        this.alphabets.addAll(alphabets);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("dmmmmmm", "ddd");
        final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View view = layoutInflater.inflate(R.layout.alphabet_item, parent, false);
        return new MyViewHolder(AlphabetItemBinding.bind(view));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding();
    }

    @Override
    public int getItemCount() {
        return alphabets.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private AlphabetItemBinding viewBinding;

        MyViewHolder(AlphabetItemBinding viewBinding) {
            super(viewBinding.getRoot().getRootView());
            this.viewBinding = viewBinding;
        }

        void binding() {
            viewBinding.tvAlphabet.setText(alphabets.get(getAdapterPosition()).getNameAlphabet());
            viewBinding.tvSpell.setText(alphabets.get(getAdapterPosition()).getSpellAlphabet());
            viewBinding.speaker.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    event.onSpeakPressed(alphabets.get(getAdapterPosition()).getNameAlphabet());
                }
            });
        }
    }
}