package com.cbfacademy.flashcardapiproject.flashcard.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.cbfacademy.flashcardapiproject.flashcard.model.Flashcard;
//import com.cbfacademy.flashcardapiproject.flashcard.model.ImageFlashcard;
import com.cbfacademy.flashcardapiproject.flashcard.model.TextFlashcard;

public interface FlashcardService {

    // TextFlashcard HTTP
    TextFlashcard createTextFlashcard(TextFlashcard createdTextFlashcard);

    List<TextFlashcard> getAllTextFlashcards();

    TextFlashcard getTextFlashcardByid(Long id) throws NotFoundException;

    TextFlashcard updateTextFlashcard(Long id, Flashcard updatedTextFlashcard) throws NoSuchElementException;

    void deleteTextFlashcard(Long id);

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
