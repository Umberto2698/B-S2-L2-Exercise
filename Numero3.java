import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Numero3 {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        Map<String, String> Rubrica = new HashMap<>();
        int n = 0;
        do {
            System.out.println("Scegli quale azione svolgere:");
            System.out.println("1 - Aggiungi un contatto alla rubrica; 2 - Rimuovi un contatto; 3 - Cerca contatto; 4 - Stampa rubrica; 0 - Per chiudere l'applicazione.");
            try {
                n = Integer.parseInt(input.nextLine());
                if (n < 0 || n > 4) System.err.println("Inserisci un valore consentito.");
            } catch (NumberFormatException ex) {
                System.err.println("Hai inserito un valore non numerico");
            } catch (Exception ex) {
                System.err.println("Problema generico");
            }
            switch (n) {
                case 1 -> {
                    System.out.println("Inserisci un nome.");
                    String name = input.nextLine().trim().replaceAll(" ", "");
                    String number;
                    System.out.println("Inserisci il numero di telefono");
                    number = input.nextLine().trim().replaceAll(" ", "");
                    aggiungAllaRubrica(Rubrica, name, number);
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.println("Aggiunto con successo.");
                    TimeUnit.MILLISECONDS.sleep(500);
                }
                case 2 -> {
                    System.out.println("Inserisci il nome del contatto da rimuovere.");
                    String name = input.nextLine().trim().replaceAll(" ", "");
                    if (rimuoviDallaRubrca(Rubrica, name)) {
                        TimeUnit.MILLISECONDS.sleep(500);
                        System.out.println("Rimosso con successo.");
                        TimeUnit.MILLISECONDS.sleep(500);
                    }
                }
                case 3 -> {
                    int m = 0;
                    do {
                        System.out.println("Scegli quale azione svolgere:");
                        System.out.println("1 - Cerca contatto tramite il nuemero; 2 - Cerca contatto tramite nome; 0 - Per tornare indietro.");
                        try {
                            m = Integer.parseInt(input.nextLine());
                            if (m < 0 || m > 2) System.err.println("Inserisci un valore consentito.");
                        } catch (NumberFormatException ex) {
                            System.err.println("Hai inserito un valore non numerico");
                        } catch (Exception ex) {
                            System.err.println("Problema generico");
                        }
                        switch (m) {
                            case 1 -> {
                                System.out.println("Inserisci il numero di telefono che vuoi cercare.");
                                String number;
                                number = input.nextLine().trim().replaceAll(" ", "");
                                cercaConNumero(Rubrica, number);
                            }
                            case 2 -> {
                                System.out.println("Inserisci il nome del contatto che vuoi cercare.");
                                String name = input.nextLine().trim().replaceAll(" ", "");
                                cercaConNome(Rubrica, name);
                            }
                        }
                    } while (m != 0);
                }
                case 4 -> {
                    stampaRubrica(Rubrica);
                }
            }
        } while (n != 0);
    }

    public static void aggiungAllaRubrica(Map<String, String> mappa, String name, String number) {
        mappa.put(name, number);
    }

    public static boolean rimuoviDallaRubrca(Map<String, String> mappa, String name) {
        if (mappa.containsKey(name)) {
            mappa.remove(name);
            return true;
        } else {
            System.out.println("Nessun contatto salvato con questo nome");
            return false;
        }
    }

    public static void cercaConNumero(Map<String, String> mappa, String number) {
        if (mappa.containsValue(number)) {
            for (String name : mappa.keySet()) {
                if (mappa.get(name).equals(number)) System.out.println(name);
            }
        } else {
            System.out.println("Nessun contatto salvato con questo numero.");
        }
    }

    public static void cercaConNome(Map<String, String> mappa, String name) {
        System.out.println(mappa.getOrDefault(name, "Nessun contatto salvato con questo nome."));
    }

    public static void stampaRubrica(Map<String, String> mappa) {
        System.out.println("Lista contatti:");
        if (mappa.isEmpty()) System.out.println("La rubrica è vuota, aggiungi un contatto prima.");
        else {
            for (String name : mappa.keySet()) {
                System.out.println(name + " --- " + mappa.get(name));
            }
        }
    }
}
