import exceptions.NumberLessThanZeroException;
import exceptions.SizeEqualZeroException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Numero2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = 0;
        try {
            System.out.println("Inserisci un numero intero maggiore di zero e io genererò tanti numeri randomici.");
            size = Integer.parseInt(input.nextLine());
            if (size == 0) throw new SizeEqualZeroException();
            if (size < 0) throw new NumberLessThanZeroException();
        } catch (NumberFormatException ex) {
            System.err.println("Hai inserito un valore non numerico");
        } catch (Exception ex) {
            System.err.println("Problema generico");
        }
        ArrayList<Integer> randomNumberList = firstFunction(size);
        System.out.println(randomNumberList);

        System.out.println(secondFunction(randomNumberList));

        thirdFunction(randomNumberList, true);
    }

    public static ArrayList<Integer> firstFunction(int n) {
        ArrayList<Integer> randomNumberList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int randNumber = (int) Math.floor(Math.random() * 100);
            randomNumberList.add(randNumber);
        }
        Collections.sort(randomNumberList);
        return randomNumberList;
    }

    public static ArrayList secondFunction(ArrayList list) {
        ArrayList newList = new ArrayList();
        ArrayList reversedList = new ArrayList(list);
        Collections.reverse(reversedList);
        newList.addAll(list);
        newList.addAll(reversedList);
        return newList;
    }

    public static void thirdFunction(ArrayList list, boolean b) {
        for (int i = 0; i < list.size(); i++) {
            if (b && i % 2 == 0) {
                System.out.println(list.get(i));
            } else if (!b && i % 2 != 0) {
                System.out.println(list.get(i));
            }
        }
    }
}
