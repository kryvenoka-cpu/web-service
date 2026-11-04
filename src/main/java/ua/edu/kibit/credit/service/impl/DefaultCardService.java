package ua.edu.kibit.credit.service.impl;

import org.springframework.stereotype.Service;

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
}
