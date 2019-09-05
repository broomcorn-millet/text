import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[]args){
//        HelloWord helloWord = new HelloWord();
//        helloWord.setName("spring");
//        helloWord.sayHello();
    //创建一个spring的ioc容器
        ApplicationContext application = new ClassPathXmlApplicationContext("spring-config.xml");
        HelloWord helloWord = (HelloWord) application.getBean("HelloWord");
        helloWord.sayHello();
        Car car1=(Car)application.getBean("car1");
        System.out.println(car1);
        Car car2=(Car)application.getBean("car2");
        System.out.println(car2);
        Person p= (Person) application.getBean("person");
        System.out.println(p);
        datasource datasource= (datasource) application.getBean("datasource");
        System.out.println(datasource);


    }
}
