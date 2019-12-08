package org.lili.forfun.spring.traning.service;

import lombok.extern.log4j.Log4j2;

import org.apache.commons.lang3.RandomUtils;
import org.lili.forfun.spring.traning.db.domain.Person;
import org.lili.forfun.spring.traning.db.mapper.BaseMapper;
import org.lili.forfun.spring.traning.db.mapper.PersonMapper;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Log4j2
public class PersonService extends AbstractService<Person> {

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private CourseService courseService;

    @Override
    public BaseMapper<Person> getMapper() {
        return personMapper;
    }

    /**
     * 该事务要做的事情是，查找学生，并且修改学生名字和学生所对应的课程
     * AbstractPlatformTransactionManager
     *
     * @param name
     * @return
     */
    public List<Person> selectPersonByName(String name) {
        List<Person> people = personMapper.selectPersonByName(name);
        Person person = people.get(0);
        ((PersonService) AopContext.currentProxy()).updatePerson(person);
        return people;
    }

    public List<Person> selectPersonByName2(String name) {
        List<Person> people = personMapper.selectPersonByName(name);
        Person person = people.get(0);
        courseService.updatePerson(person);
        return people;
    }

    @Transactional
    public List<Person> selectPersonByName3(String name) {
        List<Person> people = personMapper.selectPersonByName(name);
        Person person = people.get(0);
        updatePerson3(person);
        return people;
    }

    public void updatePerson3(Person person) {
        person.setAge(String.valueOf(RandomUtils.nextInt()));
        person.setGmtModified(new Date());
        update(person);
        courseService.updateCource(person);
        throw new RuntimeException("error");
    }

    /**
     * 同一个类中的方法
     *
     * @param person
     */
    @Transactional(rollbackFor = Exception.class)
    public void updatePerson(Person person) {
        person.setAge(String.valueOf(RandomUtils.nextInt()));
        person.setGmtModified(new Date());
        update(person);
        courseService.updateCource(person);
        throw new RuntimeException("error");
    }

    /**
     * updatePerson4事务不生效，数据库插入新数据
     *
     * @param name
     * @return
     */
    public List<Person> selectPersonByName4(String name) {
        List<Person> people = personMapper.selectPersonByName(name);
        Person person = people.get(0);
        updatePerson4(person);
        return people;
    }

    @Transactional
    public void updatePerson4(Person person) {
        person.setAge(String.valueOf(RandomUtils.nextInt()));
        person.setGmtModified(new Date());
        update(person);
        courseService.updateCource(person);
        throw new RuntimeException("error");
    }


    @Transactional
    public void parent() {
        Person person = new Person();
        person.setName("parent");
        person.setAge("1000");
        person.setLevel("1");
        person.setSex("m");
        person.setStatus("1");
        insert(person);
        child();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void child() {
        Person person = new Person();
        person.setName("child");
        person.setAge("1000");
        person.setLevel("1");
        person.setSex("m");
        person.setStatus("1");
        insert(person);
        throw new RuntimeException("child exception....");
    }


    @Transactional
    public void parent2() {
        Person person = new Person();
        person.setName("parent");
        person.setAge("1000");
        person.setLevel("1");
        person.setSex("m");
        person.setStatus("1");
        insert(person);
        try {
            child2();
        } catch (Exception e) {
            log.error("parent2 catch child2 exception:", e);
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void child2() {
        Person person = new Person();
        person.setName("child");
        person.setAge("1000");
        person.setLevel("1");
        person.setSex("m");
        person.setStatus("1");
        insert(person);
        throw new RuntimeException("child exception....");
    }
}
