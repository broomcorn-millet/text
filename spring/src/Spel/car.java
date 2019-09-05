package Spel;

public class car {
    private String brand;
    private int price;
    private double typePerimeter;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", typePerimeter=" + typePerimeter +
                '}';
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public car() {
        System.out.println("car construct");
    }

    public double getTypePerimeter() {
        return typePerimeter;
    }

    public void setTypePerimeter(double typePerimeter) {
        this.typePerimeter = typePerimeter;
    }
}
