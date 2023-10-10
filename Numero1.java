import exceptions.NumberLessThanZeroException;
import exceptions.SizeEqualZeroException;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Numero1 {
    public static void main(String[] args) {
        Set<String> wordSet = new HashSet<>();
        Set<String> doubleWordSet = new HashSet<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Questo programma permette di creare una lista di parola:");
        int size = 0;
        try {
            size = Integer.parseInt(input.nextLine());
            if (size < 0) throw new NumberLessThanZeroException();
            if (size == 0) throw new SizeEqualZeroException();
        } catch (NumberFormatException ex) {
            System.err.println("Hai inserito un valore non numerico");
        } catch (Exception ex) {
            System.err.println("Problema generico");
        }

        for (int i = 0; i < size; i++) {
            System.out.println("Inserisci una parola:");
            String word = input.nextLine();
            boolean b = doubleWordSet.add(word);
            if (!b) wordSet.add(word);
        System.out.println("Parole ripetute:");
        if (doubleWordSet.isEmpty()) System.out.println("Nessuna parola  ripetuta.");
        for (String str : doubleWordSet) {
            System.out.println(str);
        }
        System.out.println("Il numero di parole distinte è " + wordSet.size());
        System.out.println("L'elenco di parole distinte è il seguente: " + wordSet);
    }
}
