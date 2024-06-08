package com.cbfacademy.flashcardapiproject.flashcard;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/api/flashcards")
public class FlashcardController {

    private final FlashcardService flashcardService;

    public FlashcardController(FlashcardService flashcardService) {
        this.flashcardService = flashcardService;
    }

    @PostMapping
    public ResponseEntity<Flashcard> createFlashcard(@RequestBody Flashcard flashcard) {
        try {
            Flashcard createdFlashcard = flashcardService.createFlashcard(flashcard);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdFlashcard);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }

    }

    @GetMapping
    public List<Flashcard> getAllFlashcards() {
        try {
            return flashcardService.getAllFlashcards();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.OK, e.getMessage(), e);
        }
    }

    @GetMapping("/{id}")
    public Flashcard getFlashcardById(@PathVariable Long id) {
        try {
            return flashcardService.getFlashcardById(id);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "FlashCard Not Found", e);
        }

    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT, produces = "application/json")
    public Flashcard updateFlashcard(@PathVariable Long id, @RequestBody Flashcard updatedFlashcard) {
        try {
            return flashcardService.updateFlashcard(id, updatedFlashcard);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flashcard Not Found", e);
        }

    }

    @DeleteMapping("/{id}")
    public void deleteFlashcard(@PathVariable Long id) {
        try {
            flashcardService.deleteFlashcard(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}
