package com.cbfacademy.flashcardapiproject.flashcard;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public interface FlashcardService {
    Flashcard createFlashcard(Flashcard flashcard);

    List<Flashcard> getAllFlashcards();

    Flashcard getFlashcardById(Long id) throws NotFoundException;

    Flashcard updateFlashcard(Long id, Flashcard updatedFlashcard);

    boolean deleteFlashcard(Long id);
}
