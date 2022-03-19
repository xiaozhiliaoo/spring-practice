package org.lili.forfun.spring.reading.beans;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
 * @author lili
 * @date 2020/11/21 19:31
 * @see
 * @since
 */
interface ITestBean {
    int getAge();

    void setAge(int age);

    String getName();

    void setName(String name);
}

class TestBean implements ITestBean {


    private int age;

    @Override
    public int getAge() {
        return age + 1;
    }

    @Override
    public void setAge(int age) {
        this.age =  age + 5;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }
}


public class BeanWrapperTest {
    public static void main(String[] args) {
        TestBean testBean = new TestBean();
        BeanWrapper b = new BeanWrapperImpl(testBean);
        b.setPropertyValue("age", 3);
        System.out.println(b.getPropertyValue("age"));
    }
}
