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
                    instance=new SingletonSafe2();//此条语句非原子操作
                }
            }

        }
        return instance;

    }

}
/* ＊instance=new SingletonSafe2();他并不是一个原子操作，其实际可以抽象为下列几条JVM指令
*   memory =allocate();//1.分配对象的内存空间
*   ctorlInstance(memory);//2.初始化对象
* 　instance=memory;//设置instance指向刚分配的内存地址
*  上面操作2依赖于操作1，但是操作3并不依赖于操作２所以Jvm是可以针对他们进行指令的优化重排序的，经过重排序后如下：１，３，２
*  可以看到指令重排之后,instance指向分配好的内存放在了前面，而这段内存初始化被安排到了后面
*  在线程Ａ在执行这段赋值语句，在初始化分配对象之前就已经将其赋值给instance引用,恰好另一个线程进入方法判断instance引用不为null，然后就将其返回使用，导致出错.
*
*
*
* */