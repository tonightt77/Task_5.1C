package com.example.newsapp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;

public class NewsDetailFragment extends Fragment {

    private static final String ARG_NEWS = "news";

    private News news;

    public NewsDetailFragment() {
        // Required empty public constructor
    }

    public static NewsDetailFragment newInstance(News news) {
        NewsDetailFragment fragment = new NewsDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_NEWS, news);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Check if arguments are not null and retrieve the news object
        if (getArguments() != null) {
            news = (News) getArguments().getSerializable(ARG_NEWS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Find and assign views for news image, title, description, and related stories RecyclerView
        ImageView newsImage = view.findViewById(R.id.news_image);
        TextView newsTitle = view.findViewById(R.id.news_title);
        TextView newsDescription = view.findViewById(R.id.news_description);
        RecyclerView relatedStoriesRecyclerView = view.findViewById(R.id.related_stories_recycler_view);


        Glide.with(this)
                .load(news.getImageUrl())
                .into(newsImage);
        // Set news title and description
        newsTitle.setText(news.getTitle());
        newsDescription.setText(news.getDescription());

        // Set up layout manager for related stories RecyclerView
        relatedStoriesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        // Generate related news list and set up adapter
        List<News> relatedNewsList = generateRelatedNews();
        RelatedStoriesAdapter relatedNewsAdapter = new RelatedStoriesAdapter(relatedNewsList);
        relatedStoriesRecyclerView.setAdapter(relatedNewsAdapter);
    }

    // Method to generate a list of related news items
    private List<News> generateRelatedNews() {
        List<News> allNews = Arrays.asList(
                new News("Lewis Hamilton responds to wild F1 rumour", "Lewis Hamilton has responded to a rumour taking the F1 world by storm – amid reports a rival star has been lined up to replace him.", "https://content.api.news/v3/images/bin/a066ac2d96bfc5d19903b2c6178ce1dc?width=320"),
                new News("Shock impacts of long Covid revealed", "The shocking impacts of the condition known as long Covid have been revealed as a huge investment is made to study the “emerging health issue”.", "https://content.api.news/v3/images/bin/acd65209caaf324f51aab2c8d03f0688?width=1024"),
                new News("Russia unleashes deadliest strikes in months", "At least 25 people, including children, have been killed and many are missing after Russia launched its biggest air strike on Ukraine in months.", "https://content.api.news/v3/images/bin/c045b6eee6a98620fd2d9bdf5ced6074?width=1024"),
                new News("Naked body mauled by dogs in ‘grim’ find", "Police are investigating the circumstances surrounding the death of a man whose naked body was discovered in a “grim” backyard scene.", "https://content.api.news/v3/images/bin/3a2310a4e52673702a8bec6877a27c1d?width=320")
        );
        List<News> relatedNews = new ArrayList<>();
        Random random = new Random();

        // Add 3 random news items from the allNews list to the relatedNews list
        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(allNews.size());
            relatedNews.add(allNews.get(randomIndex));
        }

        return relatedNews;
    }
}
