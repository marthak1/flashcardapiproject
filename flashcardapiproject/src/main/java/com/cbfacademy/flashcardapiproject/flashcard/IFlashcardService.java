package com.cbfacademy.flashcardapiproject.flashcard;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public interface IFlashcardService {

    // TextFlashcard HTTP
    Flashcard createFlashcard(Flashcard createdFlashcard);

    List<Flashcard> getAllFlashcards();

    Flashcard getFlashcardById(Long id) throws NotFoundException;

    Flashcard updateFlashcard(Long id, Flashcard updatedFlashcard) throws NoSuchElementException;

    void deleteFlashcard(Long id);

}
