package com.pl.nrdb.idCard;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IdCardRepository extends CassandraRepository<IdCard, String> {
    Optional<IdCard> findById(String id);

    boolean existsByPersonalIdAndNationality(String personalId, String nationality);

    Optional<IdCard> findByPersonalIdAndNationality(String personalId, String nationality);
}
