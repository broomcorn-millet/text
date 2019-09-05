package ii;

public class person {
    private String name;
    private car car;
    private address address;

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", car=" + car +
                ", address=" + address +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ii.car getCar() {
        return car;
    }

    public void setCar(ii.car car) {
        this.car = car;
    }

    public ii.address getAddress() {
        return address;
    }

    public void setAddress(ii.address address) {
        this.address = address;
    }
}
