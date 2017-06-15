package shakkimatti.nappulat;

import java.util.*;
import shakkimatti.logiikka.Pelaaja;

/**
 * Kuvaa shakkilaudan kuningatar-nappulaa, jatkaa abstraktia Nappula-luokkaa.
 *
 */
public class Kuningatar extends Nappula {

    /**
     * konstruktori, luo uuden kuningattaren.
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     * @param color pelaaja, jolle nappula kuuluu
     */
    public Kuningatar(int x, int y, Pelaaja color) {
        super(x, y, color);
        setMerkki("Q");
    }

    @Override
    public List<String> mahdollisetSiirrot(Nappula[][] tilanne) {
        List<String> siirrot = new ArrayList<String>();
        int x = getX();
        int y = getY();
        Lahetti tempL = new Lahetti(x, y, getPelaaja());
        Torni tempT = new Torni(x, y, getPelaaja());
        siirrot.addAll(tempL.mahdollisetSiirrot(tilanne));
        siirrot.addAll(tempT.mahdollisetSiirrot(tilanne));
        return siirrot;
    }
}
