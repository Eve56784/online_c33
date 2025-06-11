package hw.rest_api.controller;

import hw.rest_api.model.Card;
import hw.rest_api.service.CardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class MyCardController {
    private final CardService cardService;

    public MyCardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/{cardNumber}")
    public Card getCard(@PathVariable String cardNumber) {
        return cardService.getCard(cardNumber);
    }
}
