package org.lili.forfun.spring.traning.service;

import lombok.extern.log4j.Log4j2;
import org.lili.forfun.spring.traning.db.domain.Person;
import org.lili.forfun.spring.traning.db.mapper.BaseMapper;
import org.lili.forfun.spring.traning.db.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Log4j2
public class PersonService2 extends AbstractService<Person> {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public BaseMapper<Person> getMapper() {
        return personMapper;
    }

    @Transactional
    public void child5() {
        Person person = new Person();
        person.setName("child5");
        person.setAge("1000");
        person.setLevel("1");
        person.setSex("m");
        person.setStatus("1");
        insert(person);
        throw new RuntimeException("child exception....");
    }

    public void child6() {
        Person person = new Person();
        person.setName("child6");
        person.setAge("1000");
        person.setLevel("1");
        person.setSex("m");
        person.setStatus("1");
        insert(person);
        throw new RuntimeException("child6 exception....");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void child7() {
        Person person = new Person();
        person.setName("child7");
        person.setAge("1000");
        person.setLevel("1");
        person.setSex("m");
        person.setStatus("1");
        insert(person);
        throw new RuntimeException("child6 exception....");
    }

    /**
     * child8没有抛出异常，如果和parent8在同一事务内，child8不会插入数据，如果child8没有产生事务，child8会插入数据
     */
    public void child8() {
        Person person = new Person();
        person.setName("child8");
        person.setAge("1000");
        person.setLevel("1");
        person.setSex("m");
        person.setStatus("1");
        insert(person);
    }

    public void showErrorStackTrace() {
        personMapper.showErrorStackTrace();
    }
}
