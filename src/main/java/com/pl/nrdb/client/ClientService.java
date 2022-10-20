package com.pl.nrdb.client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Client fetchClient(Integer clientId) {
        return clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundException(clientId));
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    private void deleteClient(Integer id) {
        isClientExist(id);
        clientRepository.delete(fetchClient(id));
    }

    private void isClientExist(Integer id) {
        if (!clientRepository.existsById(id)) {
            throw new ClientNotFoundException(id);
        }
    }
}
