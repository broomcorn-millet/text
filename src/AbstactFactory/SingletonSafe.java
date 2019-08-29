package AbstactFactory;
//实现方式一:
public class SingletonSafe {
    // 编写线程安全的的单例模式
    private static class T{
        private static SingletonSafe singletonSafe=new SingletonSafe();
        //静态内部类在使用时才加载，且只加载一次
    }
    public static SingletonSafe getInstance(){
        return T.singletonSafe;
    }

}
