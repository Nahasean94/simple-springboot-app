package com.example.demo.service;

import com.example.demo.dao.FakePersonDataAccessService;
import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final FakePersonDataAccessService personDao;

    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = (FakePersonDataAccessService) personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }

    public Optional<Person> selectPersonById(UUID id) {
        return personDao.selectPersonById(id);
    }

    public int deletePerson(UUID id) {
        return personDao.deletePersonById(id);
    }
    public int updatePersonById(UUID id,Person person){
        return personDao.updatePersonById(id,person);
    }
}
