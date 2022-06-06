package biker;

import equips.Equip;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Biker extends Person {
    private String nickname;
    private ArrayList<Equip> equips;

    public Biker(String nickname, ArrayList<Equip> equips, String name, int age) {
        super(name, age);
        this.nickname = nickname;
        this.equips = equips;
        }

//        public String getNickname() {
//            return nickname;
//        }

        public ArrayList<Equip> getEquips() {
            return equips;
        }

//        public void setNickname(String nickname) {
//            this.nickname = nickname;
//        }
//
//        public void setEquips(ArrayList<Equip> equips) {
//            this.equips = equips;
//        }

        public void sortEquipCost() {
            Collections.sort(equips, new Comparator() {
                public int compare(Object o1, Object o2) {
                    Equip a1 = (Equip) o1;
                    Equip a2 = (Equip) o2;
                    if (a1.getPrice() > a2.getPrice()) {
                        return 1;
                    }
                    if (a2.getPrice() > a1.getPrice()) {
                        return -1;
                    }
                    return 0;
                }
            });
        }

        public void sortEquipWeight() {
            Collections.sort(equips, new Comparator() {
                public int compare(Object o1, Object o2) {
                    Equip a1 = (Equip) o1;
                    Equip a2 = (Equip) o2;
                    if (a1.getWeight() > a2.getWeight()) {
                        return 1;
                    }
                    if (a2.getWeight() > a1.getWeight()) {
                        return -1;
                    }
                    return 0;
                }
            });
        }

        public ArrayList<Equip> findEquipCost(int lLim, int rLim) {
            ArrayList<Equip> needed = new ArrayList<>();
            sortEquipCost();
            int lIndex = bSearch(equips, lLim, 0, equips.size());
            int rIndex = bSearch(equips, rLim, 0, equips.size());
            if (lIndex < 0) {
                lIndex = -1 * (lIndex + 1);
            }
            if (rIndex < 0) {
                rIndex = -1 * (rIndex + 1);
            }
            for (int i = 0; i < equips.size(); i++) {
                if (i >= lIndex && i < rIndex) {
                    needed.add(equips.get(i));
                }
            }
            return needed;
        }

        private static int bSearch(ArrayList<Equip> list, Integer key,
                                   int left, int right) {

            if (left >= right) {
                return -(left + 1);
            } else {
                int mid = (left + right) / 2;
                if (list.get(mid).getPrice() == key) {
                    int i = 1;
                    while (true) {
                        if (mid - i >= 0) {
                            if (list.get(mid - i).getPrice() == key) {
                                mid--;
                            } else {
                                return mid;
                            }
                        } else {
                            return mid;
                        }
                    }
                }
                if (list.get(mid).getPrice() > key) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
                return bSearch(list, key, left, right);
            }
        }

        @Override
        public String toString() {
            StringBuilder bikerPerson = new StringBuilder(super.toString() + " Nickname: " + nickname + ". Biker has: ");
            for (Equip ammunition : equips) {
                bikerPerson.append(new StringBuilder(ammunition.toString()));
            }
            return new String(bikerPerson);
        }
    }