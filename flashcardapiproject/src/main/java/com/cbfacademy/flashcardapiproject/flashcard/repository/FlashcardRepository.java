package com.cbfacademy.flashcardapiproject.flashcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbfacademy.flashcardapiproject.flashcard.model.Flashcard;

public interface FlashcardRepository<TextFlashcard extends Flashcard>
        extends JpaRepository<TextFlashcard, Long> {
    /*
     * additiona methods
     * findByQuestionContaining(String keyword)
     * findByAnswerContaining(String keyword)
     */
}
