package com.pl.nrdb

import com.pl.nrdb.client.ClientRepository
import com.pl.nrdb.client.ClientService
import com.pl.nrdb.client.exceptions.ClientNotFoundException
import com.pl.nrdb.idCard.IdCardRepository
import spock.lang.Specification
import spock.lang.Subject

class ClientTestSpec extends Specification{
    def clientRepository = Mock(ClientRepository)
    def idCardRepository = Mock(IdCardRepository)
    def IdCardService = Mock(com.pl.nrdb.idCard.IdCardService)

    @Subject
    def clientService = new ClientService(clientRepository, IdCardService)

    def "Should return ClientNotFoundException for Client which does not exist"() {
        given: "clientId"
        def clientId = "1"

        when: "fetchClient method returns optional.empty"
        clientRepository.findById(clientId) >> Optional.empty()
        clientService.fetchClient(clientId)

        then: "ClientNotFoundException is thrown"
        thrown(ClientNotFoundException)
    }
}
