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
    public Flashcard getFlashcardByid(Long id) throws NotFoundException {
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

/*
 * ImageFlashCard
 * 
 * @Override
 * public ImageFlashcard createImageFlashcard(String question, String answer,
 * String imageUrl) {
 * ImageFlashcard imageFlashcard = new ImageFlashcard();
 * imageFlashcard.setQuestion(question);
 * imageFlashcard.setAnswer(answer);
 * imageFlashcard.setImageUrl(imageUrl);
 * return imageFlashcardRepository.save(imageFlashcard);
 * }
 * 
 * @Override
 * public List<ImageFlashcard> getAllImageFlashcards() {
 * 
 * );
 * }
 * 
 * @Override
 * public ImageFlashcard getImageFlashcardById(Long id) throws NotFoundException
 * {
 * 
 * );
 * }
 * 
 * @Override
 * public ImageFlashcard updateImageFlashcard(Long id, ImageFlashcard
 * updatedImageFlashcard) {
 *
 * }
 * 
 * @Override
 * public void deleteImageFlashcard(Long id) {
 * 
 * }
 * 
 * // Other methods (getAllFlashcards, getFlashcardById, updateFlashcard,
 * // deleteFlashcard)
 * }
 * /*
 * /*@Override
 * public Flashcard createFlashcard(Flashcard flashcard) {
 * // Implement logic to create a flashcard
 * return imageFlashcardRepository.save(flashcard);
 * }
 * 
 * @Override
 * public List<Flashcard> getAllFlashcards() {
 * return imageFlashcardRepository.findAll();
 * }
 * 
 * @Override
 * public Flashcard getFlashcardById(Long id) throws NotFoundException {
 * return imageFlashcardRepository.findById(id)
 * .orElseThrow(() -> new NotFoundException());
 * }
 * 
 * @Override
 * public Flashcard updateFlashcard(Long id, Flashcard updatedFlashcard) throws
 * NoSuchElementException {
 * try {
 * Flashcard newFlashcard = imageFlashcardRepository.findById(id).orElseThrow();
 * newFlashcard.setQuestion(updatedFlashcard.getQuestion());
 * newFlashcard.setAnswer(updatedFlashcard.getAnswer());
 * return imageFlashcardRepository.save(newFlashcard);
 * 
 * } catch (NoSuchElementException e) {
 * throw new NoSuchElementException();
 * }
 * 
 * }
 * 
 * @Override
 * public void deleteFlashcard(Long id) {
 * imageFlashcardRepository.deleteById(id);
 * }
 * 
 */
