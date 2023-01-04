package com.pl.nrdb

import com.pl.nrdb.idCard.IdCard
import com.pl.nrdb.idCard.IdCardRepository
import com.pl.nrdb.idCard.IdCardService
import spock.lang.Specification
import spock.lang.Subject

class IdCardSpec extends Specification{
    def idCardRepository = Mock(IdCardRepository)

    @Subject
    def idCardService = new IdCardService(idCardRepository)

    def "should correctly return info about created idCard"() {
        given: "expected idCard"
        def expectedIdCard = buildExpectedIdCard()

        and: "repository being mocked"
        1 * idCardRepository.save(_) >> expectedIdCard

        when: "created idCard method is called with params"
        def result = idCardService.addIdCard("xyz", "69")

        then: "result is returned correctly"
        noExceptionThrown()
        result == expectedIdCard
    }

    def buildExpectedIdCard() {
        IdCard.builder()
        .id("1")
        .nationality("xyz")
        .personalId("69")
        .build()
    }
}
