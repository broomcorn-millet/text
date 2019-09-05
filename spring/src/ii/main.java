package ii;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String[]args){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("depend-on.xml");//创建容器
//        car car= (ii.car) applicationContext.getBean("car");
//        System.out.println(car);
//        person person= (ii.person) applicationContext.getBean("person");
//        System.out.println(person);

    }
}
