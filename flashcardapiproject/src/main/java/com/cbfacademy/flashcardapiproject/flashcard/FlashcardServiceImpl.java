package com.cbfacademy.flashcardapiproject.flashcard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class FlashcardServiceImpl implements IFlashcardService {

    private FlashcardRepository flashcardRepository; // Inject flashcard repository

    public FlashcardServiceImpl(FlashcardRepository flashcardRepository) {

        this.flashcardRepository = flashcardRepository;
    }

    @Override
    public Flashcard createFlashcard(Flashcard createdFlashcard)
            throws IllegalArgumentException, OptimisticLockingFailureException {
        try {
            return flashcardRepository.save(createdFlashcard);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public List<Flashcard> getAllFlashcards() {
        List<Flashcard> flashcards = new ArrayList<>(flashcardRepository.findAll());
        shuffleFlashcards(flashcards);
        return flashcards;
    }

    private void shuffleFlashcards(List<Flashcard> flashcards) {
        int n = flashcards.size();
        for (int i = n - 1; i > 0; i--) {

            int j = (int) (Math.random() * (i + 1));
            Collections.swap(flashcards, i, j);
        }
    }

    @Override
    public Flashcard getFlashcardById(Long id) throws NotFoundException {
        return flashcardRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    @Override
    public void deleteFlashcard(Long id) {
        flashcardRepository.deleteById(id);
    }

    @Override
    public Flashcard updateFlashcard(Long id, Flashcard updatedFlashcard) throws NoSuchElementException {
        try {
            Flashcard flashcard = flashcardRepository.findById(id).orElseThrow();
            flashcard.setQuestion(updatedFlashcard.getQuestion());
            flashcard.setAnswer(updatedFlashcard.getAnswer());
            return flashcardRepository.save(flashcard);

        } catch (NoSuchElementException e) {

            throw new NoSuchElementException();
        }
    }
}