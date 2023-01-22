package CRUD;

public class Laptop {
    private int id;
    private String lapName;
    private int lapPrice;

    public Laptop(int id, String lapName, int lapPrice) {
        this.id = id;
        this.lapName = lapName;
        this.lapPrice = lapPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLapName() {
        return lapName;
    }

    public void setLapName(String lapName) {
        this.lapName = lapName;
    }

    public int getLapPrice() {
        return lapPrice;
    }

    public void setLapPrice(int lapPrice) {
        this.lapPrice = lapPrice;
    }

    public Laptop() {
    }

    public Laptop(int id) {
        this.id = id;
    }

    public Laptop(String lapName, int lapPrice) {
        this.lapName = lapName;
        this.lapPrice = lapPrice;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", lapName='" + lapName + '\'' +
                ", lapPrice=" + lapPrice +
                '}';
    }
}
