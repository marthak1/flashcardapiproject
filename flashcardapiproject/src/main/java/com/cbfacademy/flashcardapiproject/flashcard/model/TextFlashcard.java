package com.cbfacademy.flashcardapiproject.flashcard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "text_flashcard")
public class TextFlashcard extends Flashcard {

    public TextFlashcard(Long id, String question, String answer) {
        super(id, question, answer);

    }

    public TextFlashcard() {

    }

}
