package com.cbfacademy.flashcardapiproject;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.cbfacademy.flashcardapiproject.flashcard.Flashcard;
import com.cbfacademy.flashcardapiproject.flashcard.FlashcardRepository;
import com.cbfacademy.flashcardapiproject.flashcard.IFlashcardService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FlashcardServiceTest {

    @Autowired
    private IFlashcardService flashcardService;

    @MockBean
    private FlashcardRepository flashcardRepository;

    // Test Post Flashcard
    @Test
    public void testCreateFlashcard() {
        Flashcard mockFlashcard = new Flashcard(1L, "John", "Doe");
        Mockito.when(flashcardRepository.save(any(Flashcard.class))).thenReturn(mockFlashcard);

        Flashcard result = flashcardService.createFlashcard(new Flashcard());
        assertEquals(mockFlashcard, result);
    }

    // Test Get Flashcard By Id
    @Test
    public void testGetFlashcardById() throws NotFoundException {
        Long id = 1L;
        Flashcard mockFlashcard = new Flashcard(1L, "John", "Doe");
        Mockito.when(flashcardRepository.findById(id)).thenReturn(Optional.of(
                mockFlashcard));

        Optional<Flashcard> result = Optional.ofNullable(flashcardService.getFlashcardById(id));
        assertTrue(result.isPresent());
        assertEquals(mockFlashcard, result.get());
    }

    // Test Get All Flashcards
    @Test
    public void testGetAllFlashcards() {
        List<Flashcard> mockFlashcards = List.of(
                new Flashcard(1L, "Question 1", "Answer 1"),
                new Flashcard(2L, "Question 2", "Answer 2"));

        when(flashcardRepository.findAll()).thenReturn(mockFlashcards);

        List<Flashcard> result = flashcardService.getAllFlashcards();

        assertEquals(mockFlashcards, result);
    }

    // Test Update Flashcard
    @Test
    public void testUpdateFlashcard() {
        Long id = 1L;
        Flashcard existingFlashcard = new Flashcard(1L, "John", "Doe");
        Flashcard updatedInfo = new Flashcard(1L, "Jane", "Dock");

        Mockito.when(flashcardRepository.findById(id)).thenReturn(Optional.of(existingFlashcard));
        Mockito.when(flashcardRepository.save(any(Flashcard.class))).thenReturn(updatedInfo);

        Flashcard result = flashcardService.updateFlashcard(id, updatedInfo);
        assertEquals(updatedInfo.getQuestion(), result.getQuestion());
        assertEquals(updatedInfo.getAnswer(), result.getAnswer());

    }

    // Test Delete Flashcard
    @Test
    public void testDeleteFlashcard() {
        Long id = 1L;
        Mockito.doNothing().when(flashcardRepository).deleteById(eq(id));
        flashcardService.deleteFlashcard(id);

        Mockito.verify(flashcardRepository, Mockito.times(1)).deleteById(id);
    }

}