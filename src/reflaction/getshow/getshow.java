package reflaction.getshow;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class getshow {
    public static void main(String[] args) {
        try {
            Class className = Class.forName("reflaction.getshow.student");
            showFileds(className);
            showConstructor(className);
            showMethod(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
//方法
    private static void showMethod(Class className) {
        Method[] method = className.getMethods();
        for (Method method1 : method) {
            String m = Modifier.toString(method1.getModifiers());//数据字段修饰符 public /private /protected
            Class rt = method1.getReturnType();
            String name=method1.getName();
            System.out.print(m+" "+rt.getName()+" "+name+"(");
            Class[] params = method1.getParameterTypes();//类型参数
            for (int j = 0; j < params.length; j++) {
                if (j == params.length - 1) {
                    System.out.print(params[j].getSimpleName());
                } else {
                    System.out.print(params[j].getSimpleName() + ",");
                }
            }
            System.out.println(")");

        }
    }
//构造器
    private static void showConstructor(Class c) {
        Constructor con[] = c.getConstructors();
        for (Constructor cons : con) {
            String m = Modifier.toString(cons.getModifiers());
            String n = cons.getName();
            System.out.print(m + " " + n + " (");
            Class[] params = cons.getParameterTypes();//类型参数
            for (int j = 0; j < params.length; j++) {
                if (j == params.length - 1) {
                    System.out.print(params[j].getSimpleName());
                } else {
                    System.out.print(params[j].getSimpleName() + ",");
                }
            }
            System.out.println(")");
        }

    }
//属性
    public static void showFileds(Class c) {
        Field fileds[] = c.getDeclaredFields();
        for (Field f : fileds
                ) {
            String s = Modifier.toString(f.getModifiers());
            Class type = f.getType();
            String t = type.getName();
            String name = f.getName();
            System.out.println(s + " " + t + " " + name);
        }
    }
}
