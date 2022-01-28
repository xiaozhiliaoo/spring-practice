package org.lili.forfun.spring.training.service;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lili.forfun.spring.training.service.PersonService;
import org.lili.forfun.spring.training.TestApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    public void selectPersonByName() {
//        personService.selectPersonByName("lili");
        int count = personService.count();
        log.info("count is:{}",count);
    }
}
