package AbstactFactory;

public class SingleFastObject {
    //在调用方法前就已经被创建　立即加载方式＝＝恶汉模式
    private static SingleFastObject instance=new SingleFastObject();
    private SingleFastObject(){

    }
    public static SingleFastObject getIstance()
    {
        // 此代码版本为立即加载
        // 此版本代码的缺点是不能有其他实例变量
        // 因为getInstance()方法没有同步
        // 所以有可能出现非线程安全的问题

        return instance;
    }
    public void showMessage(){
        System.out.println("Hello World!");
    }
    public static void main(String[]args){
        SingleFastObject object= SingleFastObject.getIstance();
        object.showMessage();
    }
}
