package ua.edu.kibit.credit.service.impl;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import ua.edu.kibit.credit.dto.CardData;
import ua.edu.kibit.credit.entity.Card;
import ua.edu.kibit.credit.mapper.CardMapper;
import ua.edu.kibit.credit.repository.CardRepository;
import ua.edu.kibit.credit.service.CardService;

@Service
public class DefaultCardService implements CardService {

    private final CardRepository cardRepository;

    public DefaultCardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void createCard(CardData cardData) {
        Card card = CardMapper.mapToCard(cardData, new Card());
        cardRepository.save(card);
    }

    @Override
    public CardData retrieveCard(String email) {
        Card card = findCardByEmail(email);
        return CardMapper.mapToCardData(card, new CardData());
    }

    @Override
    public boolean updateCard(CardData cardData) {
        String email = cardData.getEmail();
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        Card card = findCardByEmail(email);
        cardRepository.save(CardMapper.mapToCard(cardData, card));
        return true;
    }

    @Override
    public boolean deleteCard(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        Card card = findCardByEmail(email);
        cardRepository.deleteById(card.getCardId());
        return true;
    }

    private Card findCardByEmail(String email) {
        return cardRepository.findByEmail(email).orElseThrow(
                () -> new EntityNotFoundException("Card with email " + email + " not found"));
    }
}
