package equips;
import java.util.ArrayList;

public class Shop {
    public void buy(ArrayList<Equip> inventory, String... equip) {
        Equip temp;
        for (int i = 0; i < equip.length; i++) {
            temp = currentEquip(equip[i]);
            if (temp != null) {
                inventory.add(temp);
            }
        }
    }

    private Equip currentEquip(String type) {
        switch (type) {
            case "Helm":
                return new Helm("Moto", "White", 42, 90, 1200);
            case "Gloves":
                return new Gloves("Trulli", "Black", 8, 50, 200);
            case "Jacket":
                return new Jacket("Turtle", "Blue-White", 46, 170, 2200);
            case "Boots":
                return new Boots("Gravity", "Red", 44, 150, 1800);
            default:
                System.out.println("My equip " + type + ".");
                return null;
        }
    }
}
