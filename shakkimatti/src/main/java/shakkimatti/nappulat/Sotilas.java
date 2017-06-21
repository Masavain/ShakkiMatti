package shakkimatti.nappulat;

import java.util.*;
import shakkimatti.logiikka.Pelaaja;

/**
 * Kuvaa shakkilaudan sotilas-nappulaa, jatkaa abstraktia Nappula-luokkaa.
 *
 */
public class Sotilas extends Nappula {

    public boolean liikutettu;

    /**
     * konstruktori, luo uuden kuninkaan.
     *
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     * @param color pelaaja, jolle nappula kuuluu
     * @param liikutettu kuvastaa sitä, onko sotilasta liikutettu vai ei, aluksi
     * yleensä false;
     */
    public Sotilas(int x, int y, Pelaaja color, boolean liikutettu) {
        super(x, y, color);
        setMerkki("S");
        this.liikutettu = liikutettu;
    }

    @Override
    public List<String> mahdollisetSiirrot(Nappula[][] tilanne) {
        List<String> siirrot = new ArrayList<String>();
        int x = getX();
        int y = getY();
        if (this.getPelaaja() == Pelaaja.MUSTA) {
            siirrot.addAll(mustanMahdollisetSiirrot(tilanne, x, y));
            siirrot.addAll(mustanMahdollisetSyonnit(tilanne, x, y));
        } else if (this.getPelaaja() == Pelaaja.VALKOINEN) {
            siirrot.addAll(valkoisenMahdollisetSiirrot(tilanne, x, y));
            siirrot.addAll(valkoisenMahdollisetSyonnit(tilanne, x, y));
        }
        return siirrot;
    }

    /**
     * muuten kuten Nappulan liiku, mutta liikkumisen jälkeen asetetaan sotilaan
     * liikutettu-muuttuja true:ksi.
     *
     */
    @Override
    public void liiku(int xMihin, int yMihin, Nappula[][] lauta) {
        List<String> mahdSiirrot = this.mahdollisetSiirrot(lauta);
        if (mahdSiirrot.contains(xMihin + "," + yMihin)) {
            setX(xMihin);
            setY(yMihin);
            liikutettu = true;
        }
    }

    /**
     * apumetodi mahdollisetSiirrot -metodille. tarkastaa mustan sotilaan
     * liikkumisen
     * @param tilanne pelilaudan tilanne
     * @param x sotilaan x-koordinaatti
     * @param y sotilaan y-koordinaatti
     * @return palauttaa mahdollisten siirtojen koordinaatit
     */
    public List<String> mustanMahdollisetSiirrot(Nappula[][] tilanne, int x, int y) {
        ArrayList<String> palautus = new ArrayList();
        if (y < 7) {
            if (tilanne[x][y + 1] == null) {
                palautus.add(x + "," + (y + 1));
            }
            if (y < 6 && !this.liikutettu && tilanne[x][y + 2] == null && tilanne[x][y + 1] == null){
                palautus.add(x + "," + (y + 2));
            }
        }
        return palautus;
    }

    /**
     * apumetodi mahdollisetSiirrot -metodille. tarkastaa valkoisen sotilaan
     * liikkumisen
     * @param tilanne pelilaudan tilanne
     * @param x sotilaan x-koordinaatti
     * @param y sotilaan y-koordinaatti
     * @return palauttaa mahdollisten siirtojen koordinaatit
     */
    public List<String> valkoisenMahdollisetSiirrot(Nappula[][] tilanne, int x, int y) {
        ArrayList<String> palautus = new ArrayList();
        if (y > 0) {
            if (tilanne[x][y - 1] == null) {
                palautus.add(x + "," + (y - 1));
            }
            if (y > 1 && !this.liikutettu && tilanne[x][y - 2] == null && tilanne[x][y - 1] == null) {
                palautus.add(x + "," + (y - 2));
            }
        }
        return palautus;
    }

    /**
     * apumetodi mahdollisetSiirrot -metodille. tarkastaa mustan sotilaan
     * syömisen yläviistoon
     * @param tilanne pelilaudan tilanne
     * @param x sotilaan x-koordinaatti
     * @param y sotilaan y-koordinaatti
     * @return palauttaa mahdollisten siirtojen koordinaatit
     */
    public List<String> mustanMahdollisetSyonnit(Nappula[][] tilanne, int x, int y) {
        ArrayList<String> palautus = new ArrayList();
        if (x < 7 && y < 7) {
            if (checkSyotava(x + 1, y + 1, tilanne)) {
                palautus.add((x + 1) + "," + (y + 1));
            }
        }
        if (x > 0 && y < 7) {
            if (checkSyotava(x - 1, y + 1, tilanne)) {
                palautus.add((x - 1) + "," + (y + 1));
            }
        }
        return palautus;
    }

    /**
     * apumetodi mahdollisetSiirrot -metodille. tarkastaa valkoisen sotilaan
     * syömisen yläviistoon
     * @param tilanne pelilaudan tilanne
     * @param x sotilaan x-koordinaatti
     * @param y sotilaan y-koordinaatti
     * @return palauttaa mahdollisten siirtojen koordinaatit
     */
    public List<String> valkoisenMahdollisetSyonnit(Nappula[][] tilanne, int x, int y) {
        ArrayList<String> palautus = new ArrayList();
        if (x < 7 && y > 0) {
            if (checkSyotava(x + 1, y - 1, tilanne)) {
                palautus.add((x + 1) + "," + (y - 1));
            }
        }
        if (x > 0 && y > 0) {
            if (checkSyotava(x - 1, y - 1, tilanne)) {
                palautus.add((x - 1) + "," + (y - 1));
            }
        }
        return palautus;
    }
}
