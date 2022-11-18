package com.pl.nrdb.idCard;

import com.pl.nrdb.idCard.exceptions.IdCardAlreadyExistException;
import com.pl.nrdb.idCard.exceptions.IdCardNotFoundException;
import com.pl.nrdb.idCard.exceptions.IdCardWithIdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IdCardService {

    private final IdCardRepository idCardRepository;

    public IdCard addIdCard(String personalId, String nationality) {
        checkDuplicate(personalId, nationality);
        return idCardRepository.save(IdCard.builder()
                .nationality(nationality)
                .personalId(personalId)
                .build());
    }

    private void deleteIdCard(String personalId, String nationality) {
        isIdCardAlreadyExist(personalId, nationality);
        idCardRepository.delete(idCardRepository.findByPersonalIdAndNationality(personalId, nationality).orElseThrow(() -> new IdCardNotFoundException(personalId, nationality)));
    }

    public IdCard getIdCardWithPersonalIdAndNationality(String personalId, String nationality) {
        return idCardRepository.findByPersonalIdAndNationality(personalId, nationality).orElseThrow(() -> new IdCardNotFoundException(personalId, nationality));
    }

    public IdCard getIdCard(String id) {
        return idCardRepository.findById(id).orElseThrow(() -> new IdCardWithIdNotFoundException(id));
    }

    private void checkDuplicate(String personalId, String nationality) {
        if (idCardRepository.existsByPersonalIdAndNationality(personalId, nationality)) {
            throw new IdCardAlreadyExistException(personalId, nationality);
        }
    }

    private void isIdCardAlreadyExist(String personalId, String nationality) {
        if (!idCardRepository.existsByPersonalIdAndNationality(personalId, nationality)) {
            throw new IdCardNotFoundException(personalId, nationality);
        }
    }

    public IdCard modifyIdCard(String personalId, String nationality, String idCardId) {
        IdCard idCard = idCardRepository.findById(idCardId).orElseThrow(() -> new IdCardNotFoundException(personalId, nationality));
        if(!idCard.getNationality().equals(nationality) || !idCard.getPersonalId().equals(personalId)) {
            idCard.setNationality(nationality);
            idCard.setPersonalId(personalId);
            idCardRepository.save(idCard);
        }
        return idCard;
    }
}
