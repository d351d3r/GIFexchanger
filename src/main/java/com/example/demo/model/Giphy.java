package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Giphy {

    private Giphy data;

    private Images images;

    public Giphy() {
    }

    public Giphy getData() {
        return data;
    }

    public void setData(Giphy data) {
        this.data = data;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public static class Images {
        private HashMap<String, String> original;

        public HashMap<String, String> getOriginal() {
            return original;
        }

        public void setOriginal(HashMap<String, String> original) {
            this.original = original;
        }
    }
}
