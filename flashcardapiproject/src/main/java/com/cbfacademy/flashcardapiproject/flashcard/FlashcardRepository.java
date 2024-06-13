package com.cbfacademy.flashcardapiproject.flashcard;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {
    /*
     * additional methods
     * findByQuestionContaining(String keyword)
     * findByAnswerContaining(String keyword)
     */
}
