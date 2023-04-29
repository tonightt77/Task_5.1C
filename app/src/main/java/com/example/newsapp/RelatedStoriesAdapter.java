package com.example.newsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class RelatedStoriesAdapter extends RecyclerView.Adapter<RelatedStoriesAdapter.ViewHolder> {
    private List<News> relatedNewsList;

    public RelatedStoriesAdapter(List<News> relatedNewsList) {
        this.relatedNewsList = relatedNewsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.related_story_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final News news = relatedNewsList.get(position);

        Glide.with(holder.itemView.getContext())
                .load(news.getImageUrl())
                .into(holder.relatedStoryImage);

        holder.relatedStoryTitle.setText(news.getTitle());
        holder.relatedStoryDescription.setText(news.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsDetailFragment newsDetailFragment = NewsDetailFragment.newInstance(news);

                AppCompatActivity activity = (AppCompatActivity) v.getContext();

                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, newsDetailFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return relatedNewsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView relatedStoryImage;
        public TextView relatedStoryTitle;
        public TextView relatedStoryDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            relatedStoryImage = itemView.findViewById(R.id.related_story_image);
            relatedStoryTitle = itemView.findViewById(R.id.related_story_title);
            relatedStoryDescription = itemView.findViewById(R.id.related_story_description);
        }
    }
}
