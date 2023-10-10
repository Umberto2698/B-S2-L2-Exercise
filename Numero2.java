import exceptions.NumberLessThanZeroException;
import exceptions.SizeEqualZeroExceptin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Numero2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int quantity = 0;
        try {
            System.out.println("Inserisci un numero intero maggiore di zero e io genererò tanti numeri randomici.");
            quantity = Integer.parseInt(input.nextLine());
            if (quantity == 0) throw new SizeEqualZeroExceptin();
            if (quantity < 0) throw new NumberLessThanZeroException();
        } catch (NumberFormatException ex) {
            System.err.println("Hai inserito un valore non numerico");
        } catch (Exception ex) {
            System.err.println("Problema generico");
        }
        ArrayList<Integer> randomNumberList = firstFunction(quantity);
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
        for (int i = 0; i < list.size(); i++) {
            newList.add(list.get(i));
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size()) {
                newList.add(list.get(i));
            } else {
                newList.add(list.get(list.size() - i - 1));
            }
        }
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
