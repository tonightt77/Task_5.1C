package com.example.newsapp;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;
public class TopStoryAdapter extends RecyclerView.Adapter<TopStoryAdapter.ViewHolder> {
    private List<TopStory> topStories;
    private OnTopStoryClickListener onTopStoryClickListener;


    public TopStoryAdapter(List<TopStory> topStories, OnTopStoryClickListener onTopStoryClickListener) {
        this.topStories = topStories;
        this.onTopStoryClickListener = onTopStoryClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_story_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TopStory topStory = topStories.get(position);
        Glide.with(holder.topStoryImage.getContext())
                .load(topStory.getImageUrl())
                .into(holder.topStoryImage);
        holder.topStoryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTopStoryClickListener.onTopStoryClick(topStory);
            }
        });

    }


    @Override
    public int getItemCount() {
        return topStories.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView topStoryImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            topStoryImage = itemView.findViewById(R.id.top_story_image);
        }
    }

    public interface OnTopStoryClickListener {
        void onTopStoryClick(TopStory topStory);
    }
}

