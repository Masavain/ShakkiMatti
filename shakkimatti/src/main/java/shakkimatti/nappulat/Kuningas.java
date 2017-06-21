package shakkimatti.nappulat;

import java.util.ArrayList;
import java.util.List;
import shakkimatti.logiikka.Pelaaja;

/**
 * Kuvaa shakkilaudan kuningas-nappulaa, jatkaa abstraktia Nappula-luokkaa.
 *
 */
public class Kuningas extends Nappula {

    /**
     * konstruktori, luo uuden kuninkaan.
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     * @param color pelaaja, jolle nappula kuuluu
     */
    public Kuningas(int x, int y, Pelaaja color) {
        super(x, y, color);
        setMerkki("K");
    }

    @Override
    public List<String> mahdollisetSiirrot(Nappula[][] tilanne) {
        List<String> siirrot = new ArrayList<String>();
        int x = getX();
        int y = getY();
        siirrot.addAll(siirtoYlos(tilanne, x, y));
        siirrot.addAll(siirtoAlas(tilanne, x, y));
        siirrot.addAll(siirtoOikealle(tilanne, x, y));
        siirrot.addAll(siirtoVasemmalle(tilanne, x, y));
        siirrot.addAll(siirtoYlaOikeaan(tilanne, x, y));
        siirrot.addAll(siirtoYlaVasempaan(tilanne, x, y));
        siirrot.addAll(siirtoAlaOikeaan(tilanne, x, y));
        siirrot.addAll(siirtoAlaVasempaan(tilanne, x, y));
        return siirrot;
    }

    /**
     * apumetodi mahdollisetSiirrot -metodille. tarkastaa kuninkaan yläpuolisen
     * ruudun.
     * @param tilanne pelilaudan tilanne
     * @param x kuninkaan x-koordinaatti
     * @param y kuninkaan y-koordinaatti
     * @return palauttaa mahdollisten siirtojen koordinaatit 
     */
    public List<String> siirtoYlos(Nappula[][] tilanne, int x, int y) {
        ArrayList<String> palautus = new ArrayList();
        if (y > 0 && y <= 7 && x >= 0 && x <= 7) {
            if (tilanne[x][y - 1] == null) {
                palautus.add(x + "," + (y - 1));
            } else if (checkSyotava(x, y - 1, tilanne)) {
                palautus.add(x + "," + (y - 1));
            }
        }
        return palautus;
    }

    /**
     * apumetodi mahdollisetSiirrot -metodille. tarkastaa kuninkaan alapuolisen
     * ruudun.
     * @param tilanne pelilaudan tilanne
     * @param x kuninkaan x-koordinaatti
     * @param y kuninkaan y-koordinaatti
     * @return palauttaa mahdollisten siirtojen koordinaatit 
     */
    public List<String> siirtoAlas(Nappula[][] tilanne, int x, int y) {
        ArrayList<String> palautus = new ArrayList();
        if (y >= 0 && y < 7 && x >= 0 && x <= 7) {
            if (tilanne[x][y + 1] == null) {
                palautus.add(x + "," + (y + 1));
            } else if (checkSyotava(x, y + 1, tilanne)) {
                palautus.add(x + "," + (y + 1));
            }
        }
        return palautus;
    }

    /**
     * apumetodi mahdollisetSiirrot -metodille. tarkastaa kuninkaan oikean
     * ruudun.
     * @param tilanne pelilaudan tilanne
     * @param x kuninkaan x-koordinaatti
     * @param y kuninkaan y-koordinaatti
     * @return palauttaa mahdollisten siirtojen koordinaatit 
     */
    public List<String> siirtoOikealle(Nappula[][] tilanne, int x, int y) {
        ArrayList<String> palautus = new ArrayList();
        if (y >= 0 && y <= 7 && x >= 0 && x < 7) {
            if (tilanne[x + 1][y] == null) {
                palautus.add((x + 1) + "," + y);
            } else if (checkSyotava(x + 1, y, tilanne)) {
                palautus.add((x + 1) + "," + y);
            }
        }
        return palautus;
    }

    /**
     * apumetodi mahdollisetSiirrot -metodille. tarkastaa kuninkaan vasemman
     * ruudun.
     * @param tilanne pelilaudan tilanne
     * @param x kuninkaan x-koordinaatti
     * @param y kuninkaan y-koordinaatti
     * @return palauttaa mahdollisten siirtojen koordinaatit 
     */
    public List<String> siirtoVasemmalle(Nappula[][] tilanne, int x, int y) {
        ArrayList<String> palautus = new ArrayList();
        if (y >= 0 && y <= 7 && x > 0 && x <= 7) {
            if (tilanne[x - 1][y] == null) {
                palautus.add((x - 1) + "," + y);
            } else if (checkSyotava(x - 1, y, tilanne)) {
                palautus.add((x - 1) + "," + y);
            }
        }
        return palautus;
    }

    /**
     * apumetodi mahdollisetSiirrot -metodille. tarkastaa kuninkaan ylavasemman
     * ruudun.
     * @param tilanne pelilaudan tilanne
     * @param x kuninkaan x-koordinaatti
     * @param y kuninkaan y-koordinaatti
     * @return palauttaa mahdollisten siirtojen koordinaatit 
     */
    public List<String> siirtoYlaVasempaan(Nappula[][] tilanne, int x, int y) {
        ArrayList<String> palautus = new ArrayList();
        if (x > 0 && y > 0 && x <= 7 && y <= 7) {
            if (tilanne[x - 1][y - 1] == null) {
                palautus.add((x - 1) + "," + (y - 1));
            } else if (checkSyotava(x - 1, y - 1, tilanne)) {
                palautus.add((x - 1) + "," + (y - 1));
            }
        }
        return palautus;
    }

    /**
     * apumetodi mahdollisetSiirrot -metodille. tarkastaa kuninkaan alavasemman
     * ruudun.
     * @param tilanne pelilaudan tilanne
     * @param x kuninkaan x-koordinaatti
     * @param y kuninkaan y-koordinaatti
     * @return palauttaa mahdollisten siirtojen koordinaatit 
     */
    public List<String> siirtoAlaVasempaan(Nappula[][] tilanne, int x, int y) {
        ArrayList<String> palautus = new ArrayList();
        if (x > 0 && y < 7 && x <= 7 && y >= 0) {
            if (tilanne[x - 1][y + 1] == null) {
                palautus.add((x - 1) + "," + (y + 1));
            } else if (checkSyotava(x - 1, y + 1, tilanne)) {
                palautus.add((x - 1) + "," + (y + 1));
            }
        }
        return palautus;
    }

    /**
     * apumetodi mahdollisetSiirrot -metodille. tarkastaa kuninkaan alaoikean
     * ruudun.
     * @param tilanne pelilaudan tilanne
     * @param x kuninkaan x-koordinaatti
     * @param y kuninkaan y-koordinaatti
     * @return palauttaa mahdollisten siirtojen koordinaatit 
     */
    public List<String> siirtoAlaOikeaan(Nappula[][] tilanne, int x, int y) {
        ArrayList<String> palautus = new ArrayList();
        if (x < 7 && y < 7 && y >= 0 && x >= 0) {
            if (tilanne[x + 1][y + 1] == null) {
                palautus.add((x + 1) + "," + (y + 1));
            } else if (checkSyotava(x + 1, y + 1, tilanne)) {
                palautus.add((x + 1) + "," + (y + 1));
            }
        }
        return palautus;
    }

    /**
     * apumetodi mahdollisetSiirrot -metodille. tarkastaa kuninkaan yläoikean
     * ruudun.
     * @param tilanne pelilaudan tilanne
     * @param x kuninkaan x-koordinaatti
     * @param y kuninkaan y-koordinaatti
     * @return palauttaa mahdollisten siirtojen koordinaatit 
     */
    public List<String> siirtoYlaOikeaan(Nappula[][] tilanne, int x, int y) {
        ArrayList<String> palautus = new ArrayList();
        if (x < 7 && y > 0 && x >= 0 && y <= 7) {
            if (tilanne[x + 1][y - 1] == null) {
                palautus.add((x + 1) + "," + (y - 1));
            } else if (checkSyotava(x + 1, y - 1, tilanne)) {
                palautus.add((x + 1) + "," + (y - 1));
            }
        }
        return palautus;
    }
}