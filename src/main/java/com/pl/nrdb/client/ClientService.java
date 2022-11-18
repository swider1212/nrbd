package com.pl.nrdb.client;

import com.pl.nrdb.client.exceptions.ClientNotFoundException;
import com.pl.nrdb.client.exceptions.ClientWithCreditsNotFoundExceptions;
import com.pl.nrdb.idCard.IdCardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final IdCardService idCardService;

    public Client fetchClient(String clientId) {
        return clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundException(clientId));
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    private void deleteClient(String id) {
        clientRepository.delete(fetchClient(id));
    }

    public void checkDuplicate(String firstName, String lastName, String phoneNumber) {
        if (clientRepository.existsByFirstNameAndAndLastNameAndPhoneNumber(firstName, lastName, phoneNumber)) {
            throw new ClientWithCreditsNotFoundExceptions(firstName, lastName, phoneNumber);
        }
    }

    public Client addClient(String firstName, String lastName, String phoneNumber, String idCardId) {
        checkDuplicate(firstName, lastName, phoneNumber);
        return clientRepository.save(Client.builder()
                .idCard(idCardService.getIdCard(idCardId))
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .build());
    }

    public Client modifyClient(String clientId, String firstName, String lastName, String phoneNumber, String idCardId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundException(clientId));
        if (!client.getFirstName().equals(firstName) || !client.getLastName().equals(lastName) || !client.getIdCard().equals(idCardService.getIdCard(idCardId)) || !client.getPhoneNumber().equals(phoneNumber)) {
            client.setFirstName(firstName);
            client.setLastName(lastName);
            client.setIdCard(idCardService.getIdCard(idCardId));
            client.setPhoneNumber(phoneNumber);
            clientRepository.save(client);
        }
        return client;
    }
}