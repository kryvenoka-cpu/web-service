package ua.edu.kibit.credit.service;

import ua.edu.kibit.credit.dto.CardData;

public interface CardService {

    void createCard(CardData cardData);

    CardData retrieveCard(String email);

    boolean updateCard(CardData cardData);

    boolean deleteCard(String email);
}
