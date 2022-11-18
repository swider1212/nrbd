package com.pl.nrdb.idCard;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IdCardRepository extends MongoRepository<IdCard, String> {
    Optional<IdCard> findById(String id);

    boolean existsByPersonalIdAndNationality(String personalId, String nationality);

    Optional<IdCard> findByPersonalIdAndNationality(String personalId, String nationality);
}
