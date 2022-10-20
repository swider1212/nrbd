package com.pl.nrdb.idCard;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IdCardRepository extends JpaRepository<IdCard, Integer> {
    Optional<IdCard> findById(Integer id);

    boolean existsByPersonalIdAndNationality(String personalId, String nationality);

    Optional<IdCard> findByPersonalIdAndNationality(String personalId, String nationality);
}
