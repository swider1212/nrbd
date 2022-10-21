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

    public IdCard getIdCard(Integer id) {
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
}
