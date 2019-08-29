import java.lang.reflect.Field;

public class stringReflection {
//通过反射还是可以修改 不可变对象
    public static void main(String[]args) throws NoSuchFieldException, IllegalAccessException {
        String s="Hello World";
        System.out.println("s="+s);
        Field valueField= String.class.getDeclaredField("value");
        valueField.setAccessible(true);
         char[] val= (char[]) valueField.get(s);
         val[5]='_';
        System.out.println("s="+s);
    }
}
