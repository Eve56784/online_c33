package hw.rest_api.service;

import hw.rest_api.model.Card;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CardService {
    private final Map<String, Card> cards = new ConcurrentHashMap<>();

    public CardService(){
        cards.put("1111-5678-9123", new Card("1111-5678-9123", 1L, new BigDecimal("3000.55")));
        cards.put("2222-5678-9123", new Card("2222-5678-9123", 2L, new BigDecimal("1000.95")));
        cards.put("3333-5678-9123", new Card("3333-5678-9123", 2L, new BigDecimal("100.55")));
    }

    public Card getCard(String number){
        return cards.get(number);
    }

    public void updateCard(Card card){
        cards.put(card.getCardNumber(), card);
    }
}
