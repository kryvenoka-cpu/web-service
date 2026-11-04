package ua.edu.kibit.credit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ua.edu.kibit.credit.dto.CardData;
import ua.edu.kibit.credit.entity.Card;
import ua.edu.kibit.credit.repository.CardRepository;
import ua.edu.kibit.credit.service.CardService;

@SpringBootTest
class CreditApplicationTests {

	@Autowired
	private CardService cardService;

	@Autowired
	private CardRepository cardRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void createCardSavesCardToDatabase() {
		cardService.createCard(new CardData("artem.kryvenok@kibit.edu.ua", 100));

		List<Card> cards = cardRepository.findAll();
		Card card = cards.get(cards.size() - 1);
		assertEquals("artem.kryvenok@kibit.edu.ua", card.getEmail());
		assertEquals(100, card.getAmount());
		assertEquals("CREDIT_MS", card.getCreatedBy());
		assertNotNull(card.getCreatedAt());
	}

}
