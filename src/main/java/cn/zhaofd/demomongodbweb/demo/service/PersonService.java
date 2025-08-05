package cn.zhaofd.demomongodbweb.demo.service;

import cn.zhaofd.demomongodbweb.demo.dto.Person;
import cn.zhaofd.demomongodbweb.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 存储常规集合示例
 */
@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(@Autowired PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public Person findByName(String name) {
        return personRepository.findByName(name);
    }

    public List<Person> withQueryFindByAge(Integer age) {
        return personRepository.withQueryFindByAge(age);
    }
}
