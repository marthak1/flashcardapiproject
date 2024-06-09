package com.cbfacademy.flashcardapiproject.flashcard.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.cbfacademy.flashcardapiproject.flashcard.model.Flashcard;
import com.cbfacademy.flashcardapiproject.flashcard.model.TextFlashcard;
import com.cbfacademy.flashcardapiproject.flashcard.repository.ImageFlashcardRepository;
import com.cbfacademy.flashcardapiproject.flashcard.repository.TextFlashcardRepository;

@Service
public class FlashcardServiceImpl implements FlashcardService {
    // private final ImageFlashcardRepository imageFlashcardRepository;
    private final TextFlashcardRepository textFlashcardRepository;

    public FlashcardServiceImpl(ImageFlashcardRepository imageflashcardRepository,
            TextFlashcardRepository textFlashcardRepository) {
        // this.imageFlashcardRepository = imageflashcardRepository;
        this.textFlashcardRepository = textFlashcardRepository;
    }

    @Override
    public TextFlashcard createTextFlashcard(String question, String answer)
            throws IllegalArgumentException, OptimisticLockingFailureException {
        try {
            TextFlashcard textFlashcard = new TextFlashcard(null, question, answer);
            textFlashcard.setQuestion(question);
            textFlashcard.setAnswer(answer);
            return textFlashcardRepository.save(textFlashcard);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public List<TextFlashcard> getAllTextFlashcards() {
        return textFlashcardRepository.findAll();
    }

    @Override
    public TextFlashcard getTextFlashcardByid(Long id) throws NotFoundException {
        return textFlashcardRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    @Override
    public void deleteTextFlashcard(Long id) {
        textFlashcardRepository.deleteById(id);
    }

    @Override
    public TextFlashcard updateTextFlashcard(Long id, Flashcard updatedTextFlashcard) {
        try {
            TextFlashcard newTextFlashcard = textFlashcardRepository.findById(id).orElseThrow();
            newTextFlashcard.setQuestion(updatedTextFlashcard.getQuestion());
            newTextFlashcard.setAnswer(updatedTextFlashcard.getAnswer());
            return textFlashcardRepository.save(updatedTextFlashcard);

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
 * // TODO Auto-generated method stub
 * throw new
 * UnsupportedOperationException("Unimplemented method 'getAllImageFlashcards'"
 * );
 * }
 * 
 * @Override
 * public ImageFlashcard getImageFlashcardById(Long id) throws NotFoundException
 * {
 * // TODO Auto-generated method stub
 * throw new
 * UnsupportedOperationException("Unimplemented method 'getImageFlashcardById'"
 * );
 * }
 * 
 * @Override
 * public ImageFlashcard updateImageFlashcard(Long id, ImageFlashcard
 * updatedImageFlashcard) {
 * // TODO Auto-generated method stub
 * throw new
 * UnsupportedOperationException("Unimplemented method 'updateImageFlashcard'");
 * }
 * 
 * @Override
 * public void deleteImageFlashcard(Long id) {
 * // TODO Auto-generated method stub
 * throw new
 * UnsupportedOperationException("Unimplemented method 'deleteImageFlashcard'");
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
