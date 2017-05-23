package shakkimatti;

import java.util.*;

public class main {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        ArrayList<String> kirjaimet = new ArrayList<String>(Arrays.asList
        (new String[]{"a", "b", "c", "d", "e", "f", "g", "h"}));

        Pelilauta lauta = new Pelilauta();
        lauta.tulosta();
        Peliapu apu = new Peliapu(lauta);
        
        int vuoro = 1;

        while (true) {
            // valkoisen siirto
            System.out.println("vuoro:" + vuoro + " valkoinen, anna lähtökoordinaatti:");
            String lahto = lukija.nextLine();
            int xMista = kirjaimet.indexOf(lahto.substring(0, 1));
            int yMista = Integer.parseInt(lahto.substring(1, 2)) - 1;

            if (apu.validiSiirrettava(0, xMista, yMista)) {
                Nappula siirrettava = lauta.lauta[xMista][yMista];
                List<String> mahdSiirrot = siirrettava.mahdollisetSiirrot();
                System.out.println(mahdSiirrot);

                while (true) {
                    System.out.println("valkoinen, anna päätekoordinaatti:");
                    String paate = lukija.nextLine();
                    
                    int xMihin = kirjaimet.indexOf(lahto.substring(0, 1));
                    int yMihin = Integer.parseInt(paate.substring(1, 2)) - 1;

                    if(apu.vuoro(0, siirrettava, xMihin, yMihin)) break;
                }
            }
            lauta.tulosta();

            // mustan siirto
            System.out.println("vuoro:" + vuoro + " musta, anna lähtökoordinaatti:");
            lahto = lukija.nextLine();
            xMista = kirjaimet.indexOf(lahto.substring(0, 1));
            yMista = Integer.parseInt(lahto.substring(1, 2)) - 1;

            if (apu.validiSiirrettava(1, xMista, yMista)) {
                Nappula siirrettava = lauta.lauta[xMista][yMista];
                List<String> mahdSiirrot = siirrettava.mahdollisetSiirrot();
                System.out.println(mahdSiirrot);

                while (true) {
                    System.out.println("musta, anna päätekoordinaatti:");
                    String paate = lukija.nextLine();
                    int xMihin = kirjaimet.indexOf(lahto.substring(0, 1));
                    int yMihin = Integer.parseInt(paate.substring(1, 2)) - 1;

                    if(apu.vuoro(1, siirrettava, xMihin, yMihin)) break;
                }
            }
            lauta.tulosta();
            vuoro++;
        }
    }
}
