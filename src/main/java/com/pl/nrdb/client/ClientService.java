package com.pl.nrdb.client;

import com.pl.nrdb.idCard.IdCardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final IdCardService idCardService;

    public Client fetchClient(Integer clientId) {
        return clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundException(clientId));
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    private void deleteClient(Integer id) {
        clientRepository.delete(fetchClient(id));
    }

    private void checkDuplicate(String firstName, String lastName, String phoneNumber) {
        if (clientRepository.existsByFirstNameAndAndLastNameAndPhoneNumber(firstName, lastName, phoneNumber)) {
            throw new ClientWithCreditsNotFoundExceptions(firstName, lastName, phoneNumber);
        }
    }

    private Client addClient(String firstName, String lastName, String phoneNumber, Integer idCardId) {
        checkDuplicate(firstName, lastName, phoneNumber);
        return clientRepository.save(Client.builder()
                .idCard(idCardService.getIdCard(idCardId))
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .build());
    }
}