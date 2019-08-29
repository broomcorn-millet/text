import java.util.HashMap;

public   class Variables {
    int a=1;//成员变量 静态常量池放在硬盘上　加载到jvm完后就变　运行时常量池放在方法区内　
public static void main(String[]args){
    int a=1;//局部变量　放在栈的局部变量中
          String a1="ab";//后来在jdk1.7以后字符串常量池放在了堆中
          String e=new String("ab");
          String e1=new String("ab").intern();
          System.out.println(a1==e1);//true
        /*jdk1.6中只能查询或创建在字符串常量池；
        　当使用intern()方法时，先查询字符串常量池是否存在当前字符串，若字符串常量池中不存在则再从堆中查询，然后存储并返回相关引用；
　　　　   若都不存在则将当前字符串复制到字符串常量池中，并返回字符串常量池中的引用。*/
          String b="a";
          String c="b";
          String d="a"+c;//运行时进行的　会产生新的对象　实际是string b=new stringbuilder().append("a").append(b).tostring(); //返回的是一个对象
          System.out.println(a1==d);//false
//==比较的是内存地址　equal是重写的方法　string而言比较的是字符串的值


//    }

}}
//在声明的范围内，所有浮点数的计算都是精确的，当类被strictfp修饰是，所有方法默认也被strictfp修饰
strictfp class MyClass {
public static void main(String[] args)
{
float aFloat = 0.6710339f;
double aDouble = 0.04150553411984792d;
double sum = aFloat + aDouble;
float quotient = (float)(aFloat / aDouble);
System.out.println("float: " + aFloat);
System.out.println("double: " + aDouble);
System.out.println("sum: " + sum);
System.out.println("quotient: " + quotient);
}
}
//float: 0.6710339
//double: 0.04150553411984792
//sum: 0.7125394529774224
//quotient: 16.167336
