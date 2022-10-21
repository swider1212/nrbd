package com.pl.nrdb

import com.pl.nrdb.client.Client
import com.pl.nrdb.client.ClientNotFoundException
import com.pl.nrdb.client.ClientRepository
import com.pl.nrdb.client.ClientService
import com.pl.nrdb.idCard.IdCardService
import spock.lang.Specification
import spock.lang.Subject

class ClientServiceSpec extends Specification {
    def clientRepository = Mock(ClientRepository)
    def idCardService = Mock(IdCardService)

    @Subject
    def clientService = new ClientService(clientRepository, idCardService)

    def "Should return ClientNotFoundException for Client which does not exist"() {
        given: "clientId"
        def clientId = 2

        when: "fetchClient method returns optional.empty"
        clientRepository.findById(clientId) >> Optional.empty()
        clientService.fetchClient(clientId)

        then: "ClientNotFoundException is thrown"
        thrown(ClientNotFoundException)
    }

    def "Should return client"() {
        given: "clientId"
        def clientId = 1

        and: "Client"
        Client client = new Client(clientId, "Marian", "Pazdzioch", "69", null)

        and: "fetchClient method returns user with given id"
        clientService.fetchClient(clientId) >> client
        clientRepository.findById(clientId) >> Optional.of(client)

        when: "fetchClient method is called on existing client"
        def result = clientService.fetchClient(clientId)

        then: "fetchClient method returns client"
        result == client

    }

    def "Should return correct Client"() {
        given: "client"
        Client client = new Client(1, "Ferdynand", "Kiepski", "2137", null)

        and: "necessary mock"
        clientRepository.save(_) >> client

        when: "addClient method is called"
        def result = clientService.addClient("Ferdynand", "Kiepski", "2137", null)

        then: "result is returned correctly"
        noExceptionThrown()
        result == client
    }
}
