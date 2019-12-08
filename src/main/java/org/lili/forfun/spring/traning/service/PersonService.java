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

    @Autowired
    private PersonService2 personService2;

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
        person.setAge(String.valueOf(RandomUtils.nextInt()));
        person.setGmtModified(new Date());
        update(person);
        try {
            updatePerson3(person);
        } catch (Exception e) {
            log.error("updatePerson3 error:", e);
        }
        return people;
    }

    public void updatePerson3(Person person) {
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


    /**
     * 事务方法间互相调用：结果都没有插入新数据，
     * 实际因为child抛出异常，parent捕获了，一起回滚，因为child是一个简单的方法，并不是因为child是一个独立的
     * 事务
     */
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


    /**
     * 事务方法间互相调用：按照事务传播特性，理论是parent提交成功，child回滚，但是实际插入2条新数据，
     * 说明child2事务没有生效，因为child2没有事务，只是普通方法，parent2没有捕获异常，所以也成功插入
     */
    @Transactional
    public void parent2() {
        Person person = new Person();
        person.setName("parent2");
        person.setAge("1000");
        person.setLevel("1");
        person.setSex("m");
        person.setStatus("1");
        insert(person);
        try {
            //child2插入成功，说明child2并没有产生新的事务，还是在原有事务中，实际插入两条
            child2();
        } catch (Exception e) {
            log.error("parent2 catch child2 exception:", e);
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void child2() {
        Person person = new Person();
        person.setName("child2");
        person.setAge("1000");
        person.setLevel("1");
        person.setSex("m");
        person.setStatus("1");
        insert(person);
        throw new RuntimeException("child exception....");
    }

    /**
     * 有事务方法调用没有事务方法，没有事务方法不会产生事务，只是一个普通方法，同时插入两条数据
     */
    @Transactional
    public void parent3() {
        Person person = new Person();
        person.setName("parent3");
        person.setAge("1000");
        person.setLevel("1");
        person.setSex("m");
        person.setStatus("1");
        insert(person);
        try {
            //child3();  //插入两条
            // ((PersonService) AopContext.currentProxy()).child3(); // 插入两条，因为是同一个事务，不会回滚，获取到的是同一个事务，这时候获取不获取没有区别
            ((PersonService) AopContext.currentProxy()).child3Transaction(); // child3 插入失败，child3有了事务，parent3插入成功,因为在不同事务
        } catch (Exception e) {
            log.error("parent3 catch child3 exception:", e);
        }
    }

    public void child3() {
        Person person = new Person();
        person.setName("child3");
        person.setAge("1000");
        person.setLevel("1");
        person.setSex("m");
        person.setStatus("1");
        insert(person);
        throw new RuntimeException("child exception....");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void child3Transaction() {
        Person person = new Person();
        person.setName("child3Transaction");
        person.setAge("1000");
        person.setLevel("1");
        person.setSex("m");
        person.setStatus("1");
        insert(person);
        throw new RuntimeException("child exception....");
    }

    /**
     * 没有事务方法调用有事务方法，会使得事务失效
     */
    public void parent4() {
        Person person = new Person();
        person.setName("parent4");
        person.setAge("1000");
        person.setLevel("1");
        person.setSex("m");
        person.setStatus("1");
        insert(person);
        //child4();    //parent插入成功，child插入成功，因为相当于两个普通方法调用
        ((PersonService) AopContext.currentProxy()).child4();  //parent插入成功，child插入失效，因为child4产生事务
    }

    @Transactional
    public void child4() {
        Person person = new Person();
        person.setName("child4");
        person.setAge("1000");
        person.setLevel("1");
        person.setSex("m");
        person.setStatus("1");
        insert(person);
        throw new RuntimeException("child exception....");
    }

    /**
     * 没有事务方法，调用另一个Service有事务的方法child5，parent5插入成功，child5插入失败
     */
    public void parent5() {
        Person person = new Person();
        person.setName("parent5");
        person.setAge("1000");
        person.setLevel("1");
        person.setSex("m");
        person.setStatus("1");
        insert(person);
        personService2.child5();
    }

    /**
     * PersonService1有事务parent6调用PersonService1没有事务方法child6
     */
    @Transactional
    public void parent6() {
        Person person = new Person();
        person.setName("parent6");
        person.setAge("1000");
        person.setLevel("1");
        person.setSex("m");
        person.setStatus("1");
        insert(person);
        personService2.child6();  //不插入数据
        /*try {
            personService2.child6(); //同时插入两条,因为在同一个事务里面，父事务没有回滚
        } catch (Exception e) {
            log.error("child6 error:", e);
        }*/
    }

    /**
     * 有事务parent7调用有事务的child7
     */
    @Transactional
    public void parent7() {
        Person person = new Person();
        person.setName("parent7");
        person.setAge("1000");
        person.setLevel("1");
        person.setSex("m");
        person.setStatus("1");
        insert(person);
        personService2.child7(); // child7回滚，抛出异常，两个不同事务，不插入两条数据
//        try {
//            personService2.child7();  //两个不同的事务，parent7插入数据，child7不插入数据
//        } catch (Exception e) {
//            log.error("child6 error:", e);
//        }
    }

    /**
     * 有事务方法调用没有事务方法，没有事务方法和之前事务是同一个，会一起回滚
     */
    @Transactional
    public void parent8() {
        Person person = new Person();
        person.setName("parent8");
        person.setAge("1000");
        person.setLevel("1");
        person.setSex("m");
        person.setStatus("1");
        insert(person);
        personService2.child8();
        throw new RuntimeException("parent8 error");
    }
}
