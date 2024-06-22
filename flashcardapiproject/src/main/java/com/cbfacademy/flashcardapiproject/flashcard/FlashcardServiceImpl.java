package com.cbfacademy.flashcardapiproject.flashcard;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class FlashcardServiceImpl implements FlashcardService {

    private FlashcardRepository flashcardRepository;

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
        return flashcardRepository.findAll();
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
            Flashcard newFlashcard = flashcardRepository.findById(id).orElseThrow();
            newFlashcard.setQuestion(updatedFlashcard.getQuestion());
            newFlashcard.setAnswer(updatedFlashcard.getAnswer());
            return flashcardRepository.save(newFlashcard);

        } catch (NoSuchElementException e) {

            throw new NoSuchElementException();
        }
    }
}