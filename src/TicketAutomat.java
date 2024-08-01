import java.util.ArrayList;
import java.util.Scanner;

public class TicketAutomat {

    public static void ticket() {

//wir erstellen 2 ArrayLists
        ArrayList<Double> Preisstufe = new ArrayList<>();
        Preisstufe.add(1.4);
        Preisstufe.add(2.3);
        Preisstufe.add(4.7);
        Preisstufe.add(9.6);
        Preisstufe.add(11.4);

        ArrayList<String> Buchstaben = new ArrayList<>();
        Buchstaben.add("K");
        Buchstaben.add("A");
        Buchstaben.add("B");
        Buchstaben.add("C");
        Buchstaben.add("D");

//Scanner startet
        Scanner scan = new Scanner(System.in);
        System.out.println("Wähle ein Preisstufe: ");
        String s = scan.nextLine();

        int buchstbIndex=0;
        double w=0;
//forEach Schleife für Buchstaben ArrayList
            for (String c : Buchstaben) {
//Wir speichern alle Buchstaben index in ein int Variable buchstbIndex
//In Variable w wir speichern die Buchstaben indeces das wir die gleiche indexes von Preisstufe
//ArrayList benutzen können
                buchstbIndex = Buchstaben.indexOf(c);
                w = Preisstufe.get(buchstbIndex);
//Scanner nextLine String soll die gleiche Buchstabe aus unsere ArrayList sein
//Dann wir kriegen mit 'w' die Preisstuffe für die Kategorien
                if (s.equals(c)) {
                    System.out.println("Sie haben Preisstufe " + s + " gewählt.");
                    System.out.println("Bitte zahlen Sie " + w + " Euro.");

//Benutzer gibt uns eine Euro int - i-w= was die Kunde zurückkriegt
                int i = scan.nextInt();
                System.out.printf("Sie bekommen: %.2f Euro zurück \n" ,  i - w);

//wir erstellen eine Euro Cent variable - soll zwei decimals haben
                double cent = Math.floor(((i - w) % 1)*100)/100;
//wir erstellen ein Euro variable - ohne cent
                double euroCoin = (i - w) - ((i - w) % 1);
 // mit for Schleife wir printen die 2 Euros für gerade Summe
                if (euroCoin % 2 == 0) {
                    for (int h = 0; h < euroCoin / 2; h++) {
                        System.out.println("2 Euro");
                    }
 //und 1 Euro plus 2 Euros für ungerade Summe
                } else {
                    System.out.println("1 Euro");
                    for (int d = 0; d < (euroCoin - 1) / 2; d++) {
                        System.out.println("2 Euro");
                    }
                }
//Für cents wir untersuchen ob cents gerade sind (*10%2)
//wichtige Problem: Math.floor gibt uns manchmal nicht bequeme Zahlen zurück...
// bei Buchstabe 'D' wir kriegen ärger
                if (cent * 10 % 2 == 0) {
                    for (int j = 0; j < cent * 5; j++) {
                        System.out.println(0.2+ " Euro");
                    }
                } else  {
                    System.out.format("%.2f" +" Euro", 0.1);
                    for (int k = 0; k < ((cent)*10 / 2)-1; k++) {
                        System.out.println();
                        System.out.format("%.2f" +" Euro", 0.2);
                    }
                }
                }
            }
    }
}

