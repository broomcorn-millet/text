package AbstactFactory;

public class SingleObject {
    private static SingleObject instance=new SingleObject();
    private SingleObject(){

    }
    public static SingleObject getIstance(){
        return instance;
    }
    public void showMessage(){
        System.out.println("Hello World!");
    }
}
