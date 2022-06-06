//Каждый класс должен иметь отражающее смысл название и информативный состав.
//Использовать возможности ООП: классы, наследование, полиморфизм, инкапсуляция.
//Наследование должно применяться только тогда, когда это имеет смысл.
//При кодировании должны быть использованы соглашения об оформлении кода java code convention.
//Классы должны быть грамотно разложены по пакетам
//Консольное меню должно быть минимальным.
//Для хранения параметров инициализации можно использовать файлы.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Train[] trains_list = trains_list();
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Trains to the station");
        System.out.print("Name of the station: ");
        String name = scanner.next();
        train_station(trains_list, name);

        System.out.println("2. Trains to the station that departure at time");
        System.out.print("Name of the station: ");
        name = scanner.next();
        System.out.print("Time of departure: ");
        train_time(trains_list, name, scanner.nextDouble());

    }

    static Train[] trains_list() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("How many trains exist: ");
        Train[] trains = new Train[scanner1.nextInt()];
        for (int i = 0; i < trains.length; i++) {
            trains[i] = new Train();
            System.out.print("Final station of train is: ");
            trains[i].setStation(scanner1.next());
            System.out.print("Number of train: ");
            trains[i].setNumber(scanner1.next());
            System.out.print("Departure time: ");
            trains[i].setTime(scanner1.nextDouble());
            System.out.print("How many free coupes: ");
            trains[i].setCoupes(scanner1.nextInt());
            System.out.print("How many free bench: ");
            trains[i].setBench(scanner1.nextInt());
            System.out.print("How many free VIP seats: ");
            trains[i].setVips(scanner1.nextInt());
        }
        return trains;
    }

    static void train_station(Train[] trains, String station) {
        for (Train train : trains) {
            if (train.getStation().equals(station))
                System.out.println(train);
        }
    }

    static void train_time(Train[] trains, String station, double time) {
        for (Train train : trains) {
            if (train.getStation().equals(station) && train.getTime() > time)
                System.out.println(train);
        }
    }
}