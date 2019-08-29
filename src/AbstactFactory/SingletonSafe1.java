package AbstactFactory;
//实现方法3
public class SingletonSafe1 {
    private static SingletonSafe1 instance;
    public static synchronized SingletonSafe1 getInstance()
    {
        if (instance == null)          //1
            instance = new SingletonSafe1();  //2
        return instance;               //3
    }

}
