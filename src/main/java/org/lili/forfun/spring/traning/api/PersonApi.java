package org.lili.forfun.spring.traning.api;

import lombok.extern.log4j.Log4j2;
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
@Log4j2
@RestController
@RequestMapping("/personApi")
public class PersonApi extends BaseApi {
    @Autowired
    private PersonService personService;

    @GetMapping("/name")
    public RequestResult<List<Person>> getPersonByName(@RequestParam(name = "name") String name) {
        log.info("GET person name:{}", name);
        try {
            return process(personService.selectPersonByName(name));
        } catch (Exception e) {
            log.error("getPersonByName error:", e);
            return error(e.getMessage());
        }
    }

    @GetMapping("/name2")
    public RequestResult<List<Person>> getPersonByName2(@RequestParam(name = "name") String name) {
        log.info("GET person name:{}", name);
        try {
            return process(personService.selectPersonByName2(name));
        } catch (Exception e) {
            log.error("getPersonByName error:", e);
            return error(e.getMessage());
        }
    }

    @GetMapping("/name3")
    public RequestResult<List<Person>> getPersonByName3(@RequestParam(name = "name") String name) {
        log.info("GET person name:{}", name);
        try {
            return process(personService.selectPersonByName3(name));
        } catch (Exception e) {
            log.error("getPersonByName error:", e);
            return error(e.getMessage());
        }
    }

    @GetMapping("/name4")
    public RequestResult<List<Person>> getPersonByName4(@RequestParam(name = "name") String name) {
        log.info("GET person name:{}", name);
        try {
            return process(personService.selectPersonByName4(name));
        } catch (Exception e) {
            log.error("getPersonByName error:", e);
            return error(e.getMessage());
        }
    }

    /**
     * https://blog.csdn.net/bntx2jsqfehy7/article/details/79040349
     * @return
     */
    @GetMapping("/parent1-child1")
    public RequestResult<Void> parent1() {
        try {
            personService.parent();
        } catch (Exception e) {
            log.error("parent1-child1 error:", e);
            return error(e.getMessage());
        }
        return succ();
    }

    @GetMapping("/parent2-child2")
    public RequestResult<Void> name6() {
        try {
            personService.parent2();
        } catch (Exception e) {
            log.error("parent2-child2 error:", e);
            return error(e.getMessage());
        }
        return succ();
    }
}
