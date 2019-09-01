package org.annotation.i;
@Deprecated
 class Apple1 {
 @Deprecated
    public void info(){
     System.out.println("Aaa");
 }
 @Deprecated
    private String str;
 }
 public class DepreatedTest{
     public static void main(String[]args){
         new Apple1().info();

     }
}
/*@Deprecated注解功能
简单来讲就是，若某类或某方法加上该注解之后，表示此方法或类不再建议使用，调用时也会出现删除线，但并不代表不能用，只是说，不推荐使用，因为还有更好的方法可以调用。

            或许有人会问 为什么会出现加这个注解呢，直接在写方法的时候定义一个新的不就好了吗？

            因为在一个项目中，工程比较大，代码比较多，而在后续开发过程中，可能之前的某个方法实现的并不是很合理，这个时候就要新加一个方法，而之前的方法又不能随便删除，因为可能在别的地方有调用它，所以加上这个注解，就方便以后开发人员的方法调用了。
*/