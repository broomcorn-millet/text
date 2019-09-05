package factory;



import java.util.HashMap;
public  class factory {
    /*
    静态工厂方法：直接调用某一个类的的静态方法就可以返回ｂｅａｎ的实例
     */
    private static HashMap<String,car> cars=new HashMap<String, car>();
    static {
        cars.put("audi",new car("audi",30000));
        cars.put("ford",new car("ford",40000));
    }
    //静态工厂方法
    public static car getcar(String name){
        return cars.get(name);

    }
}
