package Spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String[]args){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Spel/bean-spel.xml");//创建容器
//        address address= (address) applicationContext.getBean("address");
//        System.out.println(address);
//        car car=(Spel.car)applicationContext.getBean("car");
//        System.out.println(car);
    person person= (person)applicationContext.getBean("person");
        System.out.println(person);
    }
}
