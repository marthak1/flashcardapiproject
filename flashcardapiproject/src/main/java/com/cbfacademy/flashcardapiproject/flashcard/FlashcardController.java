package com.cbfacademy.flashcardapiproject.flashcard;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/api/flashcards")
public class FlashcardController {

    private final IFlashcardService flashcardService;

    public FlashcardController(IFlashcardService flashcardService) {
        this.flashcardService = flashcardService;
    }

    @PostMapping
    public ResponseEntity<Flashcard> createFlashcard(@RequestBody Flashcard createdFlashcard) {
        try {
            Flashcard newFlashcard = flashcardService.createFlashcard(createdFlashcard);
            return ResponseEntity.status(HttpStatus.CREATED).body(newFlashcard);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }

    @GetMapping
    public ResponseEntity<List<Flashcard>> getAllFlashcards() {
        try {
            List<Flashcard> flashcards = flashcardService.getAllFlashcards();
            return ResponseEntity.status(HttpStatus.OK).body((flashcards));
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flashcard> getFlashcardByid(@PathVariable Long id) {
        try {
            // return flashcardService.getFlashcardById(id);
            Flashcard flashcard = flashcardService.getFlashcardById(id);
            return ResponseEntity.status(HttpStatus.OK).body(flashcard);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "FlashCard Not Found", e);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Flashcard> updateFlashcard(@PathVariable Long id, @RequestBody Flashcard updatedFlashcard) {
        try {
            // return flashcardService.updateFlashcard(id, updatedFlashcard);
            flashcardService.updateFlashcard(id, updatedFlashcard);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flashcard Not Found", e);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlashcard(@PathVariable Long id) {
        try {
            flashcardService.deleteFlashcard(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}
