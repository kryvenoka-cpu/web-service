package ua.edu.kibit.credit.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/retrieve")
    public ResponseEntity<CardData> retrieveCard(@RequestParam String email) {
        CardData cardData = cardService.retrieveCard(email);
        return ResponseEntity
                .status(org.springframework.http.HttpStatus.OK)
                .body(cardData);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseData> updateCard(@RequestBody CardData cardData) {
        return cardService.updateCard(cardData)
                ? ResponseEntity
                .status(org.springframework.http.HttpStatus.OK)
                .body(new ResponseData(HttpStatus.OK, HttpMessage.REQUEST_PROCESSED))
                : ResponseEntity
                .status(org.springframework.http.HttpStatus.UNPROCESSABLE_CONTENT)
                .body(new ResponseData(HttpStatus.UNPROCESSABLE_CONTENT, HttpMessage.UPDATE_FAILED));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseData> deleteCard(@RequestParam String email) {
        return cardService.deleteCard(email)
                ? ResponseEntity
                .status(org.springframework.http.HttpStatus.OK)
                .body(new ResponseData(HttpStatus.NO_CONTENT, HttpMessage.CARD_DELETED))
                : ResponseEntity
                .status(org.springframework.http.HttpStatus.UNPROCESSABLE_CONTENT)
                .body(new ResponseData(HttpStatus.UNPROCESSABLE_CONTENT, HttpMessage.DELETE_FAILED));
    }
}
