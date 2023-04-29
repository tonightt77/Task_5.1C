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



public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private List<News> newsList;

    public NewsAdapter(List<News> newsList) {
        this.newsList = newsList;
    }


    public interface OnNewsClickListener {
        void onNewsClicked(News news);
    }
    // Create ViewHolder for news items
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new ViewHolder(view);
    }
    // Bind ViewHolder with data from news items
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final News news = newsList.get(position);
        // Load news image with Glide
        Glide.with(holder.itemView.getContext())
                .load(news.getImageUrl())
                .into(holder.newsImage);
        // Set news title and description
        holder.newsTitle.setText(news.getTitle());
        holder.newsDescription.setText(news.getDescription());
        // Set click listener for each news item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                if (activity instanceof MainActivity) {
                    ((MainActivity) activity).setTopStoryVisibility(View.GONE);
                }
                // Create and navigate to NewsDetailFragment
                NewsDetailFragment newsDetailFragment = NewsDetailFragment.newInstance(news);

                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, newsDetailFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    // Get the total number of news items
    @Override
    public int getItemCount() {
        return newsList.size();
    }
    // ViewHolder class for news items
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView newsImage;
        public TextView newsTitle;
        public TextView newsDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newsImage = itemView.findViewById(R.id.news_image);
            newsTitle = itemView.findViewById(R.id.news_title);
            newsDescription = itemView.findViewById(R.id.news_description);
        }
    }
}
