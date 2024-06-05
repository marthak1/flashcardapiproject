package com.cbfacademy.flashcardapiproject.flashcard;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class FlashcardServiceImpl implements FlashcardService {
    private final FlashcardRepository flashcardRepository;

    public FlashcardServiceImpl(FlashcardRepository flashcardRepository) {
        this.flashcardRepository = flashcardRepository;
    }

    @Override
    public Flashcard createFlashcard(Flashcard flashcard) {
        // Implement logic to create a flashcard
        return flashcardRepository.save(flashcard);
    }

    @Override
    public List<Flashcard> getAllFlashcards() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllFlashcards'");
    }

    @Override
    public Flashcard getFlashcardById(Long id) throws NotFoundException {
        return flashcardRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    @Override
    public Flashcard updateFlashcard(Long id, Flashcard updatedFlashcard) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateFlashcard'");
    }

    @Override
    public boolean deleteFlashcard(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteFlashcard'");
    }

    // Other methods (getAllFlashcards, getFlashcardById, updateFlashcard,
    // deleteFlashcard)
}
