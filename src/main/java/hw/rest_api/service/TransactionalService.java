package hw.rest_api.service;

import hw.rest_api.model.Card;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionalService {
    private final CardService cardService;

    public TransactionalService(CardService cardService) {
        this.cardService = cardService;
    }

    public String transaction(String senderCardNumber, String receiverCardNumber, BigDecimal amount) {
        Card senderCard = cardService.getCard(senderCardNumber);
        Card receiverCard = cardService.getCard(receiverCardNumber);

        if(senderCard == null || receiverCard == null)
            return "Card not found";

        if(senderCard.getAmount().compareTo(amount) < 0)
            return "Insufficient amount";

        senderCard.setAmount(senderCard.getAmount().subtract(amount));
        receiverCard.setAmount(receiverCard.getAmount().add(amount));

        cardService.updateCard(senderCard);
        cardService.updateCard(receiverCard);
        return "Transaction successful";
    }
}
