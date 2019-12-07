## spring-transaction-traning
====================

### 准备:
安装mysql8(我的环境是windows)，建立person和course表，初始化数据，详见[install-mysql-and-load-data](/src/main/resources/windows-install-mysql.md)

### 结论:
两个ServiceA，ServiceB
- 在一个ServiceA内，有@Transactinal注解的方法调用没有注解的方法会产生事务传播，但是
没有注解的调用有@Transactinal注解的会使得事务失效，需要通过AopContext.currentProxy()
获取当前代理对象，然后调用。
- 不同的Service内，有ServiceA的@Transactinal注解方法调用没有注解ServiceB的方法会产生事务传播，ServiceA没有
注解方法的调用有ServiceB的@Transactinal注解也会保存ServiceB的事务完整。


### 测试用例:
- `curl localhost:9888/helloApi/first 同一个service里面切入不同方法`
- `curl localhost:9888/helloApi/second 同一个service里面一个方法调用`
- `curl localhost:9888/personApi/name?name=lili  同一Service，没有事务方法调用代理事务方法`
- `curl localhost:9888/personApi/name2?name=lili 不同Service，没有事务方法调用另一个service有事务方法`
- `curl localhost:9888/personApi/name3?name=lili 同一Service，有事务方法调用没有事务方法`
- `curl localhost:9888/personApi/name4?name=lili  同一Service，没有事务方法调用有注解的事务方法(事务不生效，插入新数据)`

