package ua.edu.kibit.credit.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.edu.kibit.credit.constants.HttpMessage;
import ua.edu.kibit.credit.constants.HttpStatus;
import ua.edu.kibit.credit.dto.CardData;
import ua.edu.kibit.credit.dto.ResponseData;
import ua.edu.kibit.credit.service.CardService;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CreditController {

    private final CardService cardService;

    public CreditController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseData> createCard(@RequestBody CardData cardData) {
        cardService.createCard(cardData);
        return ResponseEntity
                .status(org.springframework.http.HttpStatus.CREATED)
                .body(new ResponseData(HttpStatus.CREATED, HttpMessage.CARD_CREATED));
    }
}
