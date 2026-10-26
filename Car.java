package myproject1;

//public class Car {

//}
public class Car {
    private String carId;
    private String brand;
    private String model;
    private double price;
    private boolean available;

    public Car(String carId, String brand, String model, double price, boolean available) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.available = available;
    }

    public String getCarId() { return carId; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getPrice() { return price; }
    public boolean isAvailable() { return available; }
}

