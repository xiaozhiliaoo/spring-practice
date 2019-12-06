package org.lili.forfun.spring.traning.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lili.forfun.spring.traning.TestApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    public void selectPersonByName() {
//        personService.selectPersonByName("lili");
        personService.count();
    }
}
