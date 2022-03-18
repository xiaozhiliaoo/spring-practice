# 循环依赖问题

## Case1 (A，B)

字段循环注入不会导致BeanCurrentlyInCreationException异常

## Case2 (A1，B1)

构造器循环注入会导致BeanCurrentlyInCreationException，在其中一个上面加上@Lazy注解可以解决

## Case3 (A2,B2)

构造器循环注入会导致BeanCurrentlyInCreationException，通过javax.inject的对象Supplier去包装可以解决 

## Case3(A3,B3)

构造器循环注入会导致BeanCurrentlyInCreationException，通过Supplier去包装无法解决 
