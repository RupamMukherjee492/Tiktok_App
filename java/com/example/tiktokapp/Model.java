package com.example.tiktokapp;

public class Model {
    String VideoUrl;
    int profile;
    String name;

    public Model(String videoUrl, int profile, String name) {
        VideoUrl = videoUrl;
        this.profile = profile;
        this.name = name;
    }

    public String getVideoUrl() {
        return VideoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        VideoUrl = videoUrl;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
