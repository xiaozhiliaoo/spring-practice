## spring-transaction-traning
spring事务特性验证
====================

### 准备:
安装mysql8(我的环境是windows)，建立person和course表，初始化数据，详见[install-mysql-and-load-data](/src/main/resources/windows-install-mysql.md)

### 结论:
两个不同的Service
- 在一个Service内，事务方法之间的嵌套调用，普通方法和事务方法之间的嵌套调用，被嵌套的方法都不会产生事务，只是一个普通方法。可以通过AopContext.currentProxy()获取被嵌套方法的代理对象，从而产生事务。
- 不同的Service内，事务方法之间的嵌套调用，普通方法和事务方法之间的嵌套调用，被嵌套的方法都会产生事务。


### 测试用例:
- `curl localhost:9888/helloApi/first 同一个service里面切入不同方法`
- `curl localhost:9888/helloApi/second 同一个service里面一个方法调用`
- `curl localhost:9888/personApi/parent1-child1  同一Service，事务方法parent调用事务方法child，child事务不生效`
- `curl localhost:9888/personApi/parent2-child2 同一Service，事务方法parent调用事务方法child，child事务不生效`
- `curl localhost:9888/personApi/parent3-child3 同一Service，事务方法parent调用普通方法child，child不产生事务`
- `curl localhost:9888/personApi/parent4-child4 同一Service，普通方法parent调用事务方法child，事务方法child事务不生效`
- `curl localhost:9888/personApi/parent5-child5 不同Service，普通方法parent调用事务方法child，事务方法child事务生效`
- `curl localhost:9888/personApi/parent6-child6 不同Service，事务方法parent调用普通方法child，事务方法child事务生效，并和parent在同一事务`
- `curl localhost:9888/personApi/parent7-child7 不同Service，事务方法parent调用新事务法child，事务方法child生效，和parent在不同事务中`
- `curl localhost:9888/proxyApi/proxy Java动态代理测试，代理方法内调用普通方法，普通方法不会产生代理行为`

### 参考:
[JDK动态代理给Spring事务埋下的坑！](https://blog.csdn.net/bntx2jsqfehy7/article/details/79040349)

[Spring事务管理嵌套事务详解](https://blog.csdn.net/levae1024/article/details/82998386)

