class A {
    //方法静态分派演示
    public  abstract class human{
        protected void sayhello(){
            System.out.println("humna");
        }

    }
    public  class man extends human{
        protected void sayhello(){
            System.out.println("man");
        }

    }
    public  class women extends human{
        protected void sayhello(){
            System.out.println("women");
        }

    }
    protected void x(human human){
        System.out.println("1");
    }
    protected void x(man  man){
        System.out.println("2");
    }
    protected void x(women women){
        System.out.println("3");
    }
    public void xx(){
        human man=new man();
        human woman=new women();
        A a=new A();
        a.x(man);
        a.x(woman);




    }

public static void main(String[]args){

       A a=new A();
       a.xx();

}
}