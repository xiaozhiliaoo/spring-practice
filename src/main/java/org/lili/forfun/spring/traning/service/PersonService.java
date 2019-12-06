package org.lili.forfun.spring.traning.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.lili.forfun.spring.traning.db.domain.Person;
import org.lili.forfun.spring.traning.db.mapper.BaseMapper;
import org.lili.forfun.spring.traning.db.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PersonService extends AbstractService<Person> {

    @Autowired
    private PersonMapper mapper;

    @Override
    public BaseMapper<Person> getMapper() {
        return mapper;
    }

    public List<Person> selectPersonByName(@Param("name") String name){
        return mapper.selectPersonByName(name);
    }
}
