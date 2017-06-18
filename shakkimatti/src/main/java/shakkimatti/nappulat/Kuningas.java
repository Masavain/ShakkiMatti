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
        siirrot.addAll(ylos(tilanne, x, y));
        siirrot.addAll(alas(tilanne, x, y));
        siirrot.addAll(oikea(tilanne, x, y));
        siirrot.addAll(vasen(tilanne, x, y));
        siirrot.addAll(ylaOikea(tilanne, x, y));
        siirrot.addAll(ylaVasen(tilanne, x, y));
        siirrot.addAll(alaOikea(tilanne, x, y));
        siirrot.addAll(alaVasen(tilanne, x, y));
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
    public List<String> ylos(Nappula[][] tilanne, int x, int y) {
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
    public List<String> alas(Nappula[][] tilanne, int x, int y) {
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
    public List<String> oikea(Nappula[][] tilanne, int x, int y) {
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
    public List<String> vasen(Nappula[][] tilanne, int x, int y) {
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
    public List<String> ylaVasen(Nappula[][] tilanne, int x, int y) {
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
    public List<String> alaVasen(Nappula[][] tilanne, int x, int y) {
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
    public List<String> alaOikea(Nappula[][] tilanne, int x, int y) {
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
    public List<String> ylaOikea(Nappula[][] tilanne, int x, int y) {
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