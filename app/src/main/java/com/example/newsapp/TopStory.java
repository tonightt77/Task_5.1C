package com.example.newsapp;

public class TopStory {
    private String title;
    private String description;
    private String imageUrl;

    public TopStory(String title, String description, String imageUrl) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }
   // public TopStory(String imageUrl) {
    //    this.imageUrl = imageUrl;
   // }
   public String getTitle() {
       return title;
   }

    public String getDescription() {
        return description;
    }
    public String getImageUrl() {
        return imageUrl;
    }


}


