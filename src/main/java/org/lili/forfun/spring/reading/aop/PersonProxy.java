package org.lili.forfun.spring.reading.aop;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lili
 * @date 2020/11/21 17:19
 * @notes
 */
public class PersonProxy {
    public static void main(String[] args) {
        Person p = new PersonImpl();
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(p);
        pf.addInterface(Person.class);
        pf.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println(method.getName());
            }
        });
        Person proxy = (Person) pf.getProxy();
        System.out.println(proxy.getName());


        Person proxyPerson = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                method.invoke();
                return "pppppppppppp";
            }
        });

        System.out.println(proxyPerson.getName());
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(proxyPerson);
        System.out.println(Proxy.isProxyClass(Person.class));
        System.out.println(Proxy.isProxyClass(proxyPerson.getClass()));
        Class<?> proxyClass = Proxy.getProxyClass(proxyPerson.getClass().getClassLoader(), Person.class);
        System.out.println(proxyClass);
        Class<?> proxyClass1 = Proxy.getProxyClass(p.getClass().getClassLoader(), Person.class);
        System.out.println(proxyClass1);

    }
}
