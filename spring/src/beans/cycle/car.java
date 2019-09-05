package beans.cycle;

public class car {
    public car() {
        System.out.println("cars construct..");
    }

    private String brand;

    public void setBrand(String brand) {
        System.out.println("setbrand");
        this.brand = brand;
    }
    public void init(){
        System.out.println("init..");
    }

    @Override
    public String toString() {
        return "car{" +
                "brand='" + brand + '\'' +
                '}';
    }

    public void detory(){
        System.out.println("destory...");
    }
}
