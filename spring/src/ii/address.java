package ii;

public class address {
    private String diqu;
    private String street;

    @Override
    public String toString() {
        return "address{" +
                "diqu='" + diqu + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

    public String getDiqu() {
        return diqu;
    }

    public void setDiqu(String diqu) {
        this.diqu = diqu;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
