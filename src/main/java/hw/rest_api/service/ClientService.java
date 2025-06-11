package hw.rest_api.service;

import hw.rest_api.model.Client;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ClientService {
    private final Map<Long, Client> clients = new HashMap<>();
    private final AtomicLong counter = new AtomicLong(1);

    public ClientService (){
        addClient("Eva", "S.", "eva.s@mail.ru");
        addClient("Harvey", "D.", "harvey.d@mail.ru");
        addClient("Maru", "V.", "maru.v@mail.ru");
    }

    public Client getClient(long id) {
        return clients.get(id);
    }

    public void addClient(String firstName, String lastName, String email) {
        Long id = counter.getAndIncrement();
        Client client = new Client(id, firstName, lastName, email);
        clients.put(id, client);
    }
}
