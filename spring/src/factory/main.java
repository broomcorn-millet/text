package factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String[] args) {
        ApplicationContext ctx= new ClassPathXmlApplicationContext("factory/factory.xml");
        car car= (car) ctx.getBean("car");
        System.out.println(car);
        car car2= (car) ctx.getBean("car2");
        System.out.println(car2);
    }
}
