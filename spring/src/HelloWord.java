public class HelloWord {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name;

    public void sayHello() {
        System.out.println("hello" + name);
    }

    public static void main(String[] args) {
        System.out.println("xxxx");

    }
}
