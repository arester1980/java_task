import biker.Biker;
import equips.Equip;
import equips.Shop;
import java.util.ArrayList;

public class BikerEquip {
    public static void main(String[] args) {
        Biker biker = new Biker("Sato", new ArrayList<Equip>(), "Mushito", 29);
        Shop shop = new Shop();
        shop.buy(biker.getEquips(), "Helm", "Gloves", "Jacket", "Boots");
        System.out.println(biker);
        biker.sortEquipWeight();
        System.out.println(biker);
        ArrayList<Equip> f = biker.findEquipCost(100, 201);
        StringBuilder k = new StringBuilder();
        if (!f.isEmpty()) {
            for (Equip equip : f) {
                k.append(new StringBuilder(equip.toString()));
            }
        }
        System.out.println(k);
    }
}
