package ua.edu.kibit.credit.mapper;

import ua.edu.kibit.credit.dto.CardData;
import ua.edu.kibit.credit.entity.Card;

public class CardMapper {

    private CardMapper() {
    }

    public static CardData mapToCardData(Card card, CardData cardData) {
        cardData.setEmail(card.getEmail());
        cardData.setAmount(card.getAmount());
        return cardData;
    }

    public static Card mapToCard(CardData cardData, Card card) {
        card.setEmail(cardData.getEmail());
        card.setAmount(cardData.getAmount());
        return card;
    }
}
