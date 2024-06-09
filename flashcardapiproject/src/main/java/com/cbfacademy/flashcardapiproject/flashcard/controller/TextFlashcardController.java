package com.cbfacademy.flashcardapiproject.flashcard.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cbfacademy.flashcardapiproject.flashcard.model.TextFlashcard;
import com.cbfacademy.flashcardapiproject.flashcard.service.FlashcardService;

@RestController
@RequestMapping(path = "/api/text_flashcard")
public class TextFlashcardController {

    private final FlashcardService textflashcardService;

    public TextFlashcardController(FlashcardService textflashcardService) {
        this.textflashcardService = textflashcardService;
    }

    @PostMapping
    public ResponseEntity<TextFlashcard> createTextFlashcard(@RequestBody TextFlashcard createdTextFlashcard) {
        try {
            TextFlashcard newTextFlashcard = textflashcardService.createTextFlashcard(createdTextFlashcard);
            return ResponseEntity.status(HttpStatus.CREATED).body(newTextFlashcard);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }

    @GetMapping
    public List<TextFlashcard> getAllTextFlashcards() {
        try {
            return textflashcardService.getAllTextFlashcards();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.OK, e.getMessage(), e);
        }
    }

    @GetMapping("/{id}")
    public TextFlashcard getTextFlashcardByid(@PathVariable Long id) {
        try {
            return textflashcardService.getTextFlashcardByid(id);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "FlashCard Not Found", e);
        }

    }

    @PutMapping("/{id}")
    public TextFlashcard updateFlashcard(@PathVariable Long id, @RequestBody TextFlashcard updatedTextFlashcard) {
        try {
            return textflashcardService.updateTextFlashcard(id, updatedTextFlashcard);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flashcard Not Found", e);
        }

    }

    @DeleteMapping("/{id}")
    public void deleteFlashcard(@PathVariable Long id) {
        try {
            textflashcardService.deleteTextFlashcard(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}
