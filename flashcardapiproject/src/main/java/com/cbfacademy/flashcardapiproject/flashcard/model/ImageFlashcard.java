package com.cbfacademy.flashcardapiproject.flashcard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "image_flashcard")
public class ImageFlashcard extends Flashcard {
    private String imageUrl;

    public ImageFlashcard(Long id, String question, String answer, String imageUrl) {
        super(id, question, answer);
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
