package equips;

public abstract class Equip {
    private int price;
    private int weight;

    public Equip(int price, int weight) {
        this.price = price;
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Price: " + price + "\nWeight: " + weight + "";
    }
}
