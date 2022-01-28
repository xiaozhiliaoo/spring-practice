package org.lili.forfun.spring.training.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author lili
 * @date 2020/1/9 23:22
 * @description 事务细节debug入口
 */
@Service
@Log4j2
public class TranscationInspectService {


    private DataSourceTransactionManager mysqlTransactionManager;

    @Autowired
    public void setMysqlTransactionManager(DataSourceTransactionManager mysqlTransactionManager) {
        this.mysqlTransactionManager = mysqlTransactionManager;
    }

    public void doIt() {
        System.out.println("do it");
    }


    public void programatic() {
        TransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus status = mysqlTransactionManager.getTransaction(definition);
        try {
            doIt();
        } catch (Exception e) {
            mysqlTransactionManager.rollback(status);
            throw e;
        }
        mysqlTransactionManager.commit(status);
    }

    public void template() {
        TransactionTemplate transactionTemplate = new TransactionTemplate(mysqlTransactionManager);
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                doIt();
                return null;
            }
        });
    }

    @Transactional
    public void annotation() {
        TransactionStatus transactionStatus = TransactionInterceptor.currentTransactionStatus();
        transactionStatus.setRollbackOnly();
    }
}
