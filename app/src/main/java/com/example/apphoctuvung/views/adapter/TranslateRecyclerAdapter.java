package com.example.apphoctuvung.views.adapter;

import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apphoctuvung.R;
import com.example.apphoctuvung.data.model.Detail;
import com.example.apphoctuvung.data.model.Mean;
import com.example.apphoctuvung.databinding.TranslateItemBinding;

import java.util.ArrayList;
import java.util.List;

public class TranslateRecyclerAdapter extends RecyclerView.Adapter<TranslateRecyclerAdapter.MyViewHolder> {

    private ArrayList<Detail> details = new ArrayList<Detail>();

    public void setDetails(List<Detail> details) {
        this.details.clear();
        this.details.addAll(details);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View view = layoutInflater.inflate(R.layout.translate_item, parent, false);
        return new MyViewHolder(TranslateItemBinding.bind(view));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding();
    }

    @Override
    public int getItemCount() {
        return details.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TranslateItemBinding viewBinding;

        MyViewHolder(TranslateItemBinding viewBinding) {
            super(viewBinding.getRoot().getRootView());
            this.viewBinding = viewBinding;
        }

        void binding() {
            viewBinding.meanAndExample.removeAllViews();
            viewBinding.pos.setText(details.get(getAdapterPosition()).getPos());
            for (Mean mean : details.get(getAdapterPosition()).getMeans()) {
                final TextView meanTextView = new TextView(viewBinding.getRoot().getContext());
                meanTextView.setTextColor(Color.parseColor("#673AB7"));
                meanTextView.setTypeface(meanTextView.getTypeface(), Typeface.BOLD);
                meanTextView.setText(mean.getMean());
               viewBinding.meanAndExample.addView(meanTextView);
                if (!mean.getExample().isEmpty()) {
                    final TextView exampleLabelTextView = new TextView(viewBinding.getRoot().getContext());
                    exampleLabelTextView.setText("\nExamples: ");
                    exampleLabelTextView.setTypeface(meanTextView.getTypeface(), Typeface.BOLD);
                    viewBinding.meanAndExample.addView(exampleLabelTextView);
                }
                for (String exam : mean.getExample()) {
                    final TextView examTexView = new TextView(viewBinding.getRoot().getContext());
                    examTexView.setText(String.format(" - %s", exam));
                    viewBinding.meanAndExample.addView(examTexView);
                }
            }
        }
    }
}
