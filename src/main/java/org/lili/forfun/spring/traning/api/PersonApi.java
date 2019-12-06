package org.lili.forfun.spring.traning.api;

import lombok.extern.slf4j.Slf4j;
import org.lili.forfun.spring.traning.db.domain.Person;
import org.lili.forfun.spring.traning.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@Slf4j
@RestController
@RequestMapping("/personApi")
public class PersonApi extends BaseApi {
    @Autowired
    private PersonService personService;

    @GetMapping("/name")
    public RequestResult<List<Person>> listPerson(@RequestParam(name = "name") String name) {
        log.info("GET person name:{}", name);
        try {
            return process(personService.selectPersonByName(name));
        } catch (Exception e) {
            log.warn("", e);
            return error(e.getMessage());
        }
    }
}
