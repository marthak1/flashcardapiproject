package com.cbfacademy.flashcardapiproject.flashcard;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public interface FlashcardService {

    // TextFlashcard HTTP
    Flashcard createFlashcard(Flashcard createdFlashcard);

    List<Flashcard> getAllFlashcards();

    Flashcard getFlashcardByid(Long id) throws NotFoundException;

    Flashcard updateFlashcard(Long id, Flashcard updatedFlashcard) throws NoSuchElementException;

    void deleteFlashcard(Long id);

    /*
     * *ImageFlashCard HTTPS
     * ImageFlashcard createImageFlashcard(String question, String answer, String
     * imageUrl);
     * 
     * List<ImageFlashcard> getAllImageFlashcards();
     * 
     * ImageFlashcard getImageFlashcardById(Long id) throws NotFoundException;
     * 
     * ImageFlashcard updateImageFlashcard(Long id, ImageFlashcard
     * updatedImageFlashcard);
     * 
     * void deleteImageFlashcard(Long id);
     * 
     * /*
     * // Base HTTP
     * Flashcard createFlashcard(Flashcard flashcard);
     * 
     * List<Flashcard> getAllFlashcards();
     * 
     * Flashcard getFlashcardById(Long id) throws NotFoundException;
     * 
     * Flashcard updateFlashcard(Long id, Flashcard updatedFlashcard);
     * 
     * void deleteFlashcard(Long id);
     */

}
