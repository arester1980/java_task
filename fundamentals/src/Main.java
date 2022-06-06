import java.util.*;

public class Main {
    public static void main(String[] args) {
        //1. Приветствовать любого пользователя при вводе его имени через командную строку.
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scan.next();
        System.out.println("your name is " + name);
//
//        //2. Отобразить в окне консоли аргументы командной строки в обратном порядке.
        System.out.println("Enter numbers for reverse: ");
        Scanner numRev = new Scanner(System.in);
        String numRev1 = numRev.nextLine();
        StringBuilder numRev2 = new StringBuilder(numRev1);
        System.out.println("Reverse: " + numRev2.reverse());
//
//        //3. Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
        System.out.println("How many random number do you want: ");
        Integer number = scan.nextInt();
        Integer[] nums = new Integer[number];
        String row = new String();
        for (int i = 0; i < number; i++) {
            Random rnd1 = new Random();
            nums[i] = rnd1.nextInt(101);
        }
        //вывод с переходом
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Output with new line: " + nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            String let = String.valueOf(nums[i]);
            row = row.concat(let + " ");
        }
        System.out.println("Output in a row: " + row);
//
//        //4. Ввести целые числа как аргументы командной строки,
//        //   подсчитать их сумму (произведение) и вывести результат на консоль.
        System.out.println("Enter numbers to get sum: ");
        Integer numSum1 = scan.nextInt();
        Integer numSum2 = scan.nextInt();
        System.out.println("Result of sum is equal: " + (numSum1+numSum2));

        //5. Ввести число от 1 до 12.
        //   Вывести на консоль название месяца, соответствующего данному числу.
        //   Осуществить проверку корректности ввода чисел.
        System.out.println("Enter numbers of Month: ");
        String[] months = {"", "January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December"};
        Integer numMonth = scan.nextInt();
        if (numMonth <= 12) {
            System.out.println("Month with number " + numMonth + " is: " + months[numMonth]);
        } else {
            System.out.println("Please, enter only number that <= 12");
            }
        }
    }


