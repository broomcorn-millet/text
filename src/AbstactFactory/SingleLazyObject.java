package AbstactFactory;

public class SingleLazyObject {
    private static SingleLazyObject slo;
//延迟加载/懒汉式
//
//【建对象的实例】
    public SingleLazyObject() {
    }

    public static SingleLazyObject getInstance() {
        if(slo!=null){

        }else {
            slo=new SingleLazyObject();
        }return slo;
    }
    public void showMessage(){
        System.out.println("Hello World!");
    }

    public static void main(String[]args){
        SingleLazyObject object=new SingleLazyObject();
        object.showMessage();
    }
}
