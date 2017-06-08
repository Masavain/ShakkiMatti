package shakkimatti.nappulat;

import java.util.*;
import shakkimatti.logiikka.Pelaaja;

/**
 * Kuvaa shakkilaudan kuningatar-nappulaa, jatkaa abstraktia Nappula-luokkaa
 *
 */
public class Kuningatar extends Nappula {

    public Kuningatar(int x, int y, Pelaaja color) {
        super(x, y, color);
        setMerkki("Q");
    }

    /**
     * tarkastaa kuningattaren mahdolliset siirrot (suorat viistoihin ja
     * ylös/alas/ oikealle/vasemmalle), yhdistää tarkastukset tornin ja lähetin
     * vastaavista metodeista
     *
     * @param tilanne tämänhetkinen pelilaudan pelitilanne
     * @return palauttaa listan mahdollisten siirtojen koordinaateista
     */
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
