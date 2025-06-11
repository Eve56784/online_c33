package hw.rest_api.controller;

import hw.rest_api.model.Client;
import hw.rest_api.service.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class MyClientController {
    private final ClientService clientService;


    public MyClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{clientId}")
    public Client getClient(@PathVariable int clientId) {
        return clientService.getClient(clientId);
    }
}
