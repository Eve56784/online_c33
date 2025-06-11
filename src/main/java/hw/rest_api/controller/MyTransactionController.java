package hw.rest_api.controller;

import hw.rest_api.service.TransactionalService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
        @NotBlank(message="Sender cant be blank")
        private String senderCardNumber;
        @NotBlank(message="Receiver cant be blank")
        private String receiverCardNumber;
        @NotNull(message="Amount cant be null")
        @DecimalMin(value = "0.5", message = "Minimum transactional amount is 0.5$")
        private BigDecimal amount;
    }

    @PostMapping
    public String transaction(@Valid @RequestBody TransactionRequest request){
        return transactionalService.transaction(request.senderCardNumber, request.receiverCardNumber, request.amount);
    }
}
