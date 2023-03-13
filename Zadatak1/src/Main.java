import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

//        double brojKilometara;
//        double brojZaKonverziju;
//
//        Scanner scanner = new Scanner(System.in);
//
//        boolean valid = false;
//
//        do {
//            System.out.println("Unesite broj kilometara koji zelite za konverziju:");
//            brojKilometara = scanner.nextDouble();
//            valid = brojKilometara < 0 ? false : true;
//            if (!valid) {
//                System.out.println("Unijeli ste negativan broj. Pokušajte ponovno.");
//            }
//        } while (!valid);

        double brojKilometara = brojKilometara();
        double konverzijskiBroj = konverzijskiBroj();
        double kilometriUMilje = brojKilometara / konverzijskiBroj;
        System.out.printf("Uneseno je %.1f kilometara, što je %d milja.",
                brojKilometara, (int)kilometriUMilje);

    }


    public static double brojKilometara() {

        String brojKilometara;
        boolean valid = false;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Unesite broj kilometara koji želite za konverziju:");
            brojKilometara = scanner.nextLine();
            valid = Double.parseDouble(brojKilometara) < 0 ? false : true;
            if (!valid) {
                System.out.println("Unijeli ste negativan broj. Pokušajte ponovno.");
            }
        } while (!valid);

        return Double.parseDouble(brojKilometara);
    }


        public static double konverzijskiBroj() throws IOException {

        String konverzijskiBrojString;
        boolean valid = false;

            File file = new File("upisKonverzijskogBroja.txt");

            FileWriter writer = new FileWriter(file);

        Scanner scanner = new Scanner(System.in);

            do {
                System.out.println("Unesite konverzijski broj:");
                konverzijskiBrojString = scanner.nextLine();
                double konverzijskiBroj = Double.parseDouble(konverzijskiBrojString);
                valid = konverzijskiBroj < 0 ? false : true;
                if (!valid) {
                    System.out.println("Unijeli ste negativan broj. Pokušajte ponovno.");
                }
            } while (!valid);

            writer.write(konverzijskiBrojString);
            writer.close();

            FileReader reader = new FileReader(file);

            char[] buffer = new char[10];
            reader.read(buffer);
            reader.close();

            String content = new String(buffer);

            if (content == konverzijskiBrojString){
                System.out.println("Konverzijski broj se podudara.");
            }else {
                System.out.println("Konverzijski broj nije ispravan.");
            }

            return Double.parseDouble(konverzijskiBrojString);
        }
}
