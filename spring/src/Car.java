public class Car {

  private String brand;
  private String corp;
  private double price;
  private int maxspeed;

    public Car(String brand, String corp, double price) {
        this.brand = brand;
        this.corp = corp;
        this.price = price;
    }

    public Car(String brand, String corp, int maxspeed) {
        this.brand = brand;
        this.corp = corp;
        this.maxspeed = maxspeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", corp='" + corp + '\'' +
                ", price=" + price +
                ", maxspeed=" + maxspeed +
                '}';
    }
}
