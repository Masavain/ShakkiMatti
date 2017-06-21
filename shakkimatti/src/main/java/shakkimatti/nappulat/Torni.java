package shakkimatti.nappulat;

import java.util.ArrayList;
import java.util.List;
import shakkimatti.logiikka.Pelaaja;

/**
 * Kuvaa shakkilaudan torni-nappulaa, jatkaa abstraktia Nappula-luokkaa.
 *
 */
public class Torni extends Nappula {

    /**
     * konstruktori, luo uuden tornin.
     *
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     * @param color pelaaja, jolle nappula kuuluu
     */
    public Torni(int x, int y, Pelaaja color) {
        super(x, y, color);
        setMerkki("T");
    }

    @Override
    public List<String> mahdollisetSiirrot(Nappula[][] tilanne) {
        List<String> siirrot = new ArrayList<String>();
        int x = getX();
        int y = getY();
        if (x < 7 && x >= 0) {
            siirrot.addAll(siirrotOikeaan(tilanne, x, y));
        }
        if (x <= 7 && x > 0) {
            siirrot.addAll(siirrotVasempaan(tilanne, x, y));
        }
        if (y < 7 && y >= 0) {
            siirrot.addAll(siirrotAlas(tilanne, x, y));
        }
        if (y > 0 && y <= 7) {
            siirrot.addAll(siirrotYlos(tilanne, x, y));
        }
        return siirrot;
    }

    /**
     * apumetodi mahdollisetSiirrot -metodille. tarkastaa tornin liikkumisen
     * ylöspäin
     *
     * @param tilanne pelilaudan tilanne
     * @param x tornin x-koordinaatti
     * @param y tornin y-koordinaatti
     * @return palauttaa mahdollisten siirtojen koordinaatit
     */
    public List<String> siirrotYlos(Nappula[][] tilanne, int x, int y) {
        ArrayList<String> palautus = new ArrayList();
        for (int i = y - 1; i >= 0; i--) {
            if (tilanne[x][i] == null) {
                palautus.add(x + "," + i);
            } else if (checkSyotava(x, i, tilanne)) {
                palautus.add(x + "," + i);
                break;
            } else if (tilanne[x][i] != null) {
                break;
            }
        }
        return palautus;
    }

    /**
     * apumetodi mahdollisetSiirrot -metodille. tarkastaa tornin liikkumisen
     * alaspäin
     *
     * @param tilanne pelilaudan tilanne
     * @param x tornin x-koordinaatti
     * @param y tornin y-koordinaatti
     * @return palauttaa mahdollisten siirtojen koordinaatit
     */
    public List<String> siirrotAlas(Nappula[][] tilanne, int x, int y) {
        ArrayList<String> palautus = new ArrayList();
        for (int i = y + 1; i < 8; i++) {
            if (tilanne[x][i] == null) {
                palautus.add(x + "," + i);
            } else if (checkSyotava(x, i, tilanne)) {
                palautus.add(x + "," + i);
                break;
            } else if (tilanne[x][i] != null) {
                break;
            }
        }
        return palautus;
    }

    /**
     * apumetodi mahdollisetSiirrot -metodille. tarkastaa tornin liikkumisen
     * vasemmalle
     *
     * @param tilanne pelilaudan tilanne
     * @param x tornin x-koordinaatti
     * @param y tornin y-koordinaatti
     * @return palauttaa mahdollisten siirtojen koordinaatit
     */
    public List<String> siirrotVasempaan(Nappula[][] tilanne, int x, int y) {
        ArrayList<String> palautus = new ArrayList();
        for (int i = x - 1; i >= 0; i--) {
            if (tilanne[i][y] == null) {
                palautus.add(i + "," + y);
            } else if (checkSyotava(i, y, tilanne)) {
                palautus.add(i + "," + y);
                break;
            } else if (tilanne[i][y] != null) {
                break;
            }
        }
        return palautus;
    }

    /**
     * apumetodi mahdollisetSiirrot -metodille. tarkastaa tornin liikkumisen
     * oikealle
     *
     * @param tilanne pelilaudan tilanne
     * @param x tornin x-koordinaatti
     * @param y tornin y-koordinaatti
     * @return palauttaa mahdollisten siirtojen koordinaatit
     */
    public List<String> siirrotOikeaan(Nappula[][] tilanne, int x, int y) {
        ArrayList<String> palautus = new ArrayList();
        for (int i = x + 1; i < 8; i++) {
            if (tilanne[i][y] == null) {
                palautus.add(i + "," + y);
            } else if (checkSyotava(i, y, tilanne)) {
                palautus.add(i + "," + y);
                break;
            } else if (tilanne[i][y] != null) {
                break;
            }
        }
        return palautus;
    }
}
