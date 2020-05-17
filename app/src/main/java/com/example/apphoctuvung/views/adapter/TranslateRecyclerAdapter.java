package com.example.apphoctuvung.views.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apphoctuvung.R;
import com.example.apphoctuvung.data.model.Detail;
import com.example.apphoctuvung.data.model.Mean;
import com.example.apphoctuvung.databinding.TranslateItemBinding;

import java.util.List;

public class TranslateRecyclerAdapter extends RecyclerView.Adapter<TranslateRecyclerAdapter.MyViewHolder> {

    private List<Detail> details;

    public TranslateRecyclerAdapter(List<Detail> details) {
        this.details = details;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View view = layoutInflater.inflate(R.layout.translate_item, parent);
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
            super(viewBinding.getRoot());
            this.viewBinding = viewBinding;
        }

        void binding() {
            viewBinding.pos.setText(details.get(getAdapterPosition()).getPos());
            final StringBuffer meanAndExample = new StringBuffer("");
            for (Mean mean : details.get(getAdapterPosition()).getMeans()) {
                meanAndExample.append(mean);
                for (String exam : mean.getExample()) {
                    meanAndExample.append("\n").append(exam).append("\n");
                }
            }
            viewBinding.meanAndExample.setText(meanAndExample);
        }
    }
}
