package hw.rest_api.controller;

import hw.rest_api.service.TransactionalService;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/transaction")
public class MyTransactionController {
    private final TransactionalService transactionalService;

    public MyTransactionController(TransactionalService transactionalService) {
        this.transactionalService = transactionalService;
    }

    @Data
    public static class TransactionRequest{
        private String senderCardNumber;
        private String receiverCardNumber;
        private BigDecimal amount;
    }

    @PostMapping
    public String transaction(@RequestBody TransactionRequest request){
        return transactionalService.transaction(request.senderCardNumber, request.receiverCardNumber, request.amount);
    }
}
