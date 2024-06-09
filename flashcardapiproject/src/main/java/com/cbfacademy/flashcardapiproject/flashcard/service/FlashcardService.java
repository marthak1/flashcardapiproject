package com.cbfacademy.flashcardapiproject.flashcard.service;

import java.util.List;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

//import com.cbfacademy.flashcardapiproject.flashcard.model.ImageFlashcard;
import com.cbfacademy.flashcardapiproject.flashcard.model.TextFlashcard;

public interface FlashcardService {

    // TextFlashcard HTTP
    TextFlashcard createTextFlashcard(String question, String answer);

    List<TextFlashcard> getAllTextFlashcards();

    TextFlashcard getTextFlashcardByid(Long id) throws NotFoundException;

    TextFlashcard updateTextFlashcard(Long id, TextFlashcard updatedTextFlashcard);

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
