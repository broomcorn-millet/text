package AbstactFactory;
//双重校验锁DCL--使用volatile的场景之一
public class SingletonSafe2 {
    private static volatile SingletonSafe2 instance=null;
    private SingletonSafe2(){

    }
    //双重检查加锁，只有在第一次实例化时，才启用同步机制，提交了性能

    public static SingletonSafe2 getInstance() {
        if(instance==null){
            synchronized (SingletonSafe2.class){
                if (instance==null){
                    instance=new SingletonSafe2();
                }
            }

        }
        return instance;

    }
}
