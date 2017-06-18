package shakkimatti.nappulat;

import java.util.*;
import shakkimatti.logiikka.Pelaaja;

/**
 * Kuvaa shakkilaudan ratsu-nappulaa, jatkaa abstraktia Nappula-luokkaa.
 *
 */
public class Ratsu extends Nappula {

    /**
     * konstruktori, luo uuden ratsun.
     *
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     * @param color pelaaja, jolle nappula kuuluu
     */
    public Ratsu(int x, int y, Pelaaja color) {
        super(x, y, color);
        setMerkki("R");
    }

    @Override
    public List<String> mahdollisetSiirrot(Nappula[][] tilanne) {
        List<String> siirrot = new ArrayList<String>();
        int x = getX();
        int y = getY();
        if (x + 1 < 8 && y + 2 < 8) {
            siirrot.addAll(eka(tilanne, x, y));
        }
        if (x + 2 < 8 && y + 1 < 8) {
            siirrot.addAll(toka(tilanne, x, y));
        }
        if (x - 1 >= 0 && y + 2 < 8) {
            siirrot.addAll(kolmas(tilanne, x, y));
        }
        if (x - 2 >= 0 && y + 1 < 8) {
            siirrot.addAll(neljas(tilanne, x, y));
        }
        if (x - 1 >= 0 && y - 2 >= 0) {
            siirrot.addAll(viides(tilanne, x, y));
        }
        if (x - 2 >= 0 && y - 1 >= 0) {
            siirrot.addAll(kuudes(tilanne, x, y));
        }
        if (x + 1 < 8 && y - 2 >= 0) {
            siirrot.addAll(setsemas(tilanne, x, y));
        }
        if (x + 2 < 8 && y - 1 >= 0) {
            siirrot.addAll(kahdeksas(tilanne, x, y));
        }
        return siirrot;
    }

    /**
     * apumetodi mahdollisetSiirrot -metodille. tarkastaa ratsun liikkumisen
     * koordinaattiin (x+1,y+2)
     * @param tilanne pelilaudan tilanne
     * @param x ratsun x-koordinaatti
     * @param y ratsun y-koordinaatti
     * @return palauttaa mahdollisten siirtojen koordinaatit
     */
    public List<String> eka(Nappula[][] tilanne, int x, int y) {
        ArrayList<String> palautus = new ArrayList();
        if (tilanne[x + 1][y + 2] == null) {
            palautus.add((x + 1) + "," + (y + 2));
        } else if (checkSyotava(x + 1, y + 2, tilanne)) {
            palautus.add((x + 1) + "," + (y + 2));
        }
        return palautus;
    }

    /**
     * apumetodi mahdollisetSiirrot -metodille. tarkastaa ratsun liikkumisen
     * koordinaattiin (x+2,y+1)
     * @param tilanne pelilaudan tilanne
     * @param x ratsun x-koordinaatti
     * @param y ratsun y-koordinaatti
     * @return palauttaa mahdollisten siirtojen koordinaatit
     */
    public List<String> toka(Nappula[][] tilanne, int x, int y) {
        ArrayList<String> palautus = new ArrayList();
        if (tilanne[x + 2][y + 1] == null) {
            palautus.add((x + 2) + "," + (y + 1));
        } else if (checkSyotava(x + 2, y + 1, tilanne)) {
            palautus.add((x + 2) + "," + (y + 1));
        }
        return palautus;
    }

    /**
     * apumetodi mahdollisetSiirrot -metodille. tarkastaa ratsun liikkumisen
     * koordinaattiin (x-1,y+2)
     * @param tilanne pelilaudan tilanne
     * @param x ratsun x-koordinaatti
     * @param y ratsun y-koordinaatti
     * @return palauttaa mahdollisten siirtojen koordinaatit
     */
    public List<String> kolmas(Nappula[][] tilanne, int x, int y) {
        ArrayList<String> palautus = new ArrayList();
        if (tilanne[x - 1][y + 2] == null) {
            palautus.add((x - 1) + "," + (y + 2));
        } else if (checkSyotava(x - 1, y + 2, tilanne)) {
            palautus.add((x - 1) + "," + (y + 2));
        }
        return palautus;
    }

    /**
     * apumetodi mahdollisetSiirrot -metodille. tarkastaa ratsun liikkumisen
     * koordinaattiin (x-2,y+1)
     * @param tilanne pelilaudan tilanne
     * @param x ratsun x-koordinaatti
     * @param y ratsun y-koordinaatti
     * @return palauttaa mahdollisten siirtojen koordinaatit
     */
    public List<String> neljas(Nappula[][] tilanne, int x, int y) {
        ArrayList<String> palautus = new ArrayList();
        if (tilanne[x - 2][y + 1] == null) {
            palautus.add((x - 2) + "," + (y + 1));
        } else if (checkSyotava(x - 2, y + 1, tilanne)) {
            palautus.add((x - 2) + "," + (y + 1));
        }
        return palautus;
    }

    /**
     * apumetodi mahdollisetSiirrot -metodille. tarkastaa ratsun liikkumisen
     * koordinaattiin (x-1,y-2)
     * @param tilanne pelilaudan tilanne
     * @param x ratsun x-koordinaatti
     * @param y ratsun y-koordinaatti
     * @return palauttaa mahdollisten siirtojen koordinaatit
     */
    public List<String> viides(Nappula[][] tilanne, int x, int y) {
        ArrayList<String> palautus = new ArrayList();
        if (tilanne[x - 1][y - 2] == null) {
            palautus.add((x - 1) + "," + (y - 2));
        } else if (checkSyotava(x - 1, y - 2, tilanne)) {
            palautus.add((x - 1) + "," + (y - 2));
        }
        return palautus;
    }

    /**
     * apumetodi mahdollisetSiirrot -metodille. tarkastaa ratsun liikkumisen
     * koordinaattiin (x-2,y-1)
     * @param tilanne pelilaudan tilanne
     * @param x ratsun x-koordinaatti
     * @param y ratsun y-koordinaatti
     * @return palauttaa mahdollisten siirtojen koordinaatit
     */
    public List<String> kuudes(Nappula[][] tilanne, int x, int y) {
        ArrayList<String> palautus = new ArrayList();
        if (tilanne[x - 2][y - 1] == null) {
            palautus.add((x - 2) + "," + (y - 1));
        } else if (checkSyotava(x - 2, y - 1, tilanne)) {
            palautus.add((x - 2) + "," + (y - 1));
        }
        return palautus;
    }

    /**
     * apumetodi mahdollisetSiirrot -metodille. tarkastaa ratsun liikkumisen
     * koordinaattiin (x+1,y-2)
     * @param tilanne pelilaudan tilanne
     * @param x ratsun x-koordinaatti
     * @param y ratsun y-koordinaatti
     * @return palauttaa mahdollisten siirtojen koordinaatit
     */
    public List<String> setsemas(Nappula[][] tilanne, int x, int y) {
        ArrayList<String> palautus = new ArrayList();
        if (tilanne[x + 1][y - 2] == null) {
            palautus.add((x + 1) + "," + (y - 2));
        } else if (checkSyotava(x + 1, y - 2, tilanne)) {
            palautus.add((x + 1) + "," + (y - 2));
        }
        return palautus;
    }

    /**
     * apumetodi mahdollisetSiirrot -metodille. tarkastaa ratsun liikkumisen
     * koordinaattiin (x+2,y-1)
     * @param tilanne pelilaudan tilanne
     * @param x ratsun x-koordinaatti
     * @param y ratsun y-koordinaatti
     * @return palauttaa mahdollisten siirtojen koordinaatit
     */
    public List<String> kahdeksas(Nappula[][] tilanne, int x, int y) {
        ArrayList<String> palautus = new ArrayList();
        if (tilanne[x + 2][y - 1] == null) {
            palautus.add((x + 2) + "," + (y - 1));
        } else if (checkSyotava(x + 2, y - 1, tilanne)) {
            palautus.add((x + 2) + "," + (y - 1));
        }
        return palautus;
    }

}
