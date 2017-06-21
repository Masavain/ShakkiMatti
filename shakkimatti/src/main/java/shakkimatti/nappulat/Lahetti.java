package shakkimatti.nappulat;

import java.util.ArrayList;
import java.util.List;
import shakkimatti.logiikka.Pelaaja;

/**
 * Kuvaa shakkilaudan lähetti-nappulaa, jatkaa abstraktia Nappula-luokkaa.
 *
 */
public class Lahetti extends Nappula {

    /**
     * konstruktori, luo uuden lähetin.
     *
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     * @param color pelaaja, jolle nappula kuuluu
     */
    public Lahetti(int x, int y, Pelaaja color) {
        super(x, y, color);
        setMerkki("L");
    }

    @Override
    public List<String> mahdollisetSiirrot(Nappula[][] tilanne) {
        List<String> siirrot = new ArrayList<String>();
        int x = getX();
        int y = getY();
        if (x < 7 && x >= 0) {
            siirrot.addAll(siirrotAlaOikeaan(tilanne, x, y));
        }
        if (x < 7 && x >= 0) {
            siirrot.addAll(siirrotYlaOikeaan(tilanne, x, y));
        }
        if (x > 0 && x <= 7) {
            siirrot.addAll(siirrotAlaVasempaan(tilanne, x, y));
        }
        if (x > 0 && x <= 7) {
            siirrot.addAll(siirrotYlaVasempaan(tilanne, x, y));
        }
        return siirrot;
    }

    /**
     * apumetodi mahdollisetSiirrot -metodille. tarkastaa lähetin yläoikean
     * suoran.
     *
     * @param tilanne pelilaudan tilanne
     * @param x lähetin x-koordinaatti
     * @param y lähetin y-koordinaatti
     * @return palauttaa mahdollisten siirtojen koordinaatit
     */
    public List<String> siirrotYlaOikeaan(Nappula[][] tilanne, int x, int y) {
        ArrayList<String> palautus = new ArrayList();
        int yi = y - 1;
        for (int i = x + 1; i < 8; i++) {
            if (yi < 0 || yi >= 7) {
                break;
            }
            if (tilanne[i][yi] == null) {
                palautus.add((i) + "," + (yi));
            } else if (checkSyotava(i, yi, tilanne)) {
                palautus.add((i) + "," + (yi));
                break;
            } else if (tilanne[i][yi] != null) {
                break;
            }
            yi--;
        }
        return palautus;
    }

    /**
     * apumetodi mahdollisetSiirrot -metodille. tarkastaa lähetin ylävasemman
     * suoran.
     *
     * @param tilanne pelilaudan tilanne
     * @param x lähetin x-koordinaatti
     * @param y lähetin y-koordinaatti
     * @return palauttaa mahdollisten siirtojen koordinaatit
     */
    public List<String> siirrotYlaVasempaan(Nappula[][] tilanne, int x, int y) {
        ArrayList<String> palautus = new ArrayList();
        int yi = y - 1;
        for (int i = x - 1; i >= 0; i--) {
            if (yi < 0 || yi >= 7) {
                break;
            }
            if (tilanne[i][yi] == null) {
                palautus.add((i) + "," + (yi));
            } else if (checkSyotava(i, yi, tilanne)) {
                palautus.add((i) + "," + (yi));
                break;
            } else if (tilanne[i][yi] != null) {
                break;
            }
            yi--;
        }
        return palautus;
    }

    /**
     * apumetodi mahdollisetSiirrot -metodille. tarkastaa lähetin alaoikean
     * suoran.
     *
     * @param tilanne pelilaudan tilanne
     * @param x lähetin x-koordinaatti
     * @param y lähetin y-koordinaatti
     * @return palauttaa mahdollisten siirtojen koordinaatit
     */
    public List<String> siirrotAlaOikeaan(Nappula[][] tilanne, int x, int y) {
        ArrayList<String> palautus = new ArrayList();
        int yi = y + 1;
        for (int i = x + 1; i < 8; i++) {

            if (yi > 7 || yi <= 0) {
                break;
            }
            if (tilanne[i][yi] == null) {
                palautus.add((i) + "," + (yi));
            } else if (checkSyotava(i, yi, tilanne)) {
                palautus.add((i) + "," + (yi));
                break;
            } else if (tilanne[i][yi] != null) {
                break;
            }
            yi++;
        }
        return palautus;
    }

    /**
     * apumetodi mahdollisetSiirrot -metodille. tarkastaa lähetin alavasemman
     * suoran.
     *
     * @param tilanne pelilaudan tilanne
     * @param x lähetin x-koordinaatti
     * @param y lähetin y-koordinaatti
     * @return palauttaa mahdollisten siirtojen koordinaatit
     */
    public List<String> siirrotAlaVasempaan(Nappula[][] tilanne, int x, int y) {
        ArrayList<String> palautus = new ArrayList();
        int yi = y + 1;
        for (int i = x - 1; i >= 0; i--) {
            if (yi > 7 || yi <= 0) {
                break;
            }
            if (tilanne[i][yi] == null) {
                palautus.add((i) + "," + (yi));
            } else if (checkSyotava(i, yi, tilanne)) {
                palautus.add((i) + "," + (yi));
                break;
            } else if (tilanne[i][yi] != null) {
                break;
            }
            yi++;
        }
        return palautus;
    }
}
