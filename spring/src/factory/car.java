package factory;

public class car {
    private String brrand;
    private int price;

    public car(String brrand, int price) {
        this.brrand = brrand;
        this.price = price;
    }

    @Override
    public String toString() {
        return "car{" +
                "brrand='" + brrand + '\'' +
                ", price=" + price +
                '}';
    }

    public String getBrrand() {
        return brrand;
    }

    public void setBrrand(String brrand) {
        this.brrand = brrand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
