package equips;

public class Boots extends Equip {
    private String brand = "No Name";
    private String color = "Black";
    private int size;

    public Boots(String brand, String color, int size, int price, int weight) {
        super(price, weight);
        this.size = size;
        this.brand = brand;
        this.color = color;
    }

//    public String getBrand() {
//        return brand;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public int getSize() {
//        return size;
//    }
//
//    public void setBrand(String brand) {
//        this.brand = brand;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    public void setSize(int size) {
//        this.size = size;
//    }

    @Override
    public String toString() {
        return "\nBoots from " + brand + ". Size of boots " + size + " and it color is " + color;
    }
}
