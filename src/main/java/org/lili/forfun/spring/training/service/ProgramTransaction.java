package org.lili.forfun.spring.training.service;

import org.lili.forfun.spring.training.db.domain.Person;
import org.lili.forfun.spring.training.db.mapper.BaseMapper;
import org.lili.forfun.spring.training.db.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author lili
 * @date 2019/12/23 0:38
 * @description
 */
@Service
public class ProgramTransaction extends AbstractService<Person> {

    @Autowired
    private PersonMapper personMapper;

    public TransactionTemplate transactionTemplate;

    @Autowired
    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void addPerson() {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                Person person = new Person();
                personMapper.insert(person);
            }
        });
    }

    @Override
    protected BaseMapper<Person> getMapper() {
        return personMapper;
    }
}
