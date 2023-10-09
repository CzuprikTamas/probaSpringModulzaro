package hu.progmatic.probaspringmodulzaro.service;

import hu.progmatic.probaspringmodulzaro.model.Person;
import hu.progmatic.probaspringmodulzaro.model.Spending;
import hu.progmatic.probaspringmodulzaro.repository.PersonRepository;
import hu.progmatic.probaspringmodulzaro.repository.SpendingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EntityService {

    private PersonRepository personRepository;
    private SpendingRepository spendingRepository;

    public Person createNewPerson(Person person) {
        return personRepository.save(person);
    }

    public Spending createNewSpending(Spending spending) {
        return spendingRepository.save(spending);
    }

    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    public List<Spending> getAllSpending() {
        return spendingRepository.findAll();
    }

    public void deletePerson(Integer id) {
        if (!personRepository.existsById(id)) {
            throw new RuntimeException("Vendég nem található ezen az azonosítón: " + id);
        }
        personRepository.deleteById(id);
    }
}
