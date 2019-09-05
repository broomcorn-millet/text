package beans.cycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("beans/cycle/beans-cycle.xml");
        car car= (beans.cycle.car) ctx.getBean("car");
        System.out.println(car);
        //关闭IOC 容器
        ctx.close();

    }
}
