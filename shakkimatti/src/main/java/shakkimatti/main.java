package shakkimatti;

import java.util.*;

public class main {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        String[] kirj = {"a", "b", "c", "d", "e", "f", "g", "h"};
        ArrayList<String> kirjaimet = new ArrayList<String>(Arrays.asList(kirj));

        Pelilauta a = new Pelilauta();
        a.tulosta();

        while (true) {
            // valkoisen siirto

            System.out.println("valkoinen, anna lähtökoordinaatti:");
            String lahto = lukija.nextLine();
            int x = kirjaimet.indexOf(lahto.substring(0, 1));
            int y = Integer.parseInt(lahto.substring(1, 2)) - 1;
            System.out.println("valkoinen, anna päätekoordinaatti:");
            String paate = lukija.nextLine();
            int xMihin = kirjaimet.indexOf(lahto.substring(0, 1));
            int yMihin = Integer.parseInt(paate.substring(1, 2)) - 1;

            if (a.lauta[x][y] != null && a.lauta[x][y].getColor() == 0) {
                Nappula asd = a.lauta[x][y];
                List<String> mahdSiirrot = asd.mahdollisetSiirrot();
                System.out.println(mahdSiirrot);
                if (mahdSiirrot.contains(xMihin + "," + yMihin)) {
                    
                    a.lauta[x][y] = null;
                    a.lauta[xMihin][yMihin] = asd;
                    asd.setX(xMihin);
                    asd.setY(yMihin);
                }
            }

            a.tulosta();

            // mustan siirto
            System.out.println("musta, anna lähtökoordinaatti:");
            lahto = lukija.nextLine();
            x = kirjaimet.indexOf(lahto.substring(0, 1));
            y = Integer.parseInt(lahto.substring(1, 2)) - 1;
            System.out.println("musta, anna päätekoordinaatti:");
            paate = lukija.nextLine();
            xMihin = kirjaimet.indexOf(lahto.substring(0, 1));
            yMihin = Integer.parseInt(paate.substring(1, 2)) - 1;

            if (a.lauta[x][y] != null && a.lauta[x][y].getColor() == 1) {
                Nappula asd = a.lauta[x][y];
                List<String> mahdSiirrot = asd.mahdollisetSiirrot();
                System.out.println(mahdSiirrot);
                if (mahdSiirrot.contains(xMihin + "," + yMihin)) {
                    a.lauta[x][y] = null;
                    a.lauta[xMihin][yMihin] = asd;
                    asd.setX(xMihin);
                    asd.setY(yMihin);
                }
            }

            a.tulosta();
        }
    }
}
