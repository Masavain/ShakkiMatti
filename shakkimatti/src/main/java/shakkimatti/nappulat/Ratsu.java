package shakkimatti.nappulat;

import java.util.*;
import shakkimatti.logiikka.Pelaaja;

/**
 * Kuvaa shakkilaudan ratsu-nappulaa, jatkaa abstraktia Nappula-luokkaa
 *
 */
public class Ratsu extends Nappula {

    public Ratsu(int x, int y, Pelaaja color) {
        super(x, y, color);
        setMerkki("R");
    }

    /**
     * tarkastaa ratsun mahdolliset siirrot (1 yhteen suuntaan, 2 toiseen)
     *
     * @param tilanne tämänhetkinen pelilaudan pelitilanne
     * @return palauttaa listan mahdollisten siirtojen koordinaateista
     */
    @Override
    public List<String> mahdollisetSiirrot(Nappula[][] tilanne) {
        List<String> siirrot = new ArrayList<String>();
        int x = getX();
        int y = getY();
        if (x + 1 < 8 && y + 2 < 8) {
            if (tilanne[x + 1][y + 2] == null) {
                siirrot.add((x + 1) + "," + (y + 2));
            } else if (checkSyotava(x + 1, y + 2, tilanne)) {
                siirrot.add((x + 1) + "," + (y + 2));
            }
        }
        if (x + 2 < 8 && y + 1 < 8) {
            if (tilanne[x + 2][y + 1] == null) {
                siirrot.add((x + 2) + "," + (y + 1));
            } else if (checkSyotava(x + 2, y + 1, tilanne)) {
                siirrot.add((x + 2) + "," + (y + 1));
            }
        }
        if (x - 1 >= 0 && y + 2 < 8) {
            if (tilanne[x - 1][y + 2] == null) {
                siirrot.add((x - 1) + "," + (y + 2));
            } else if (checkSyotava(x - 1, y + 2, tilanne)) {
                siirrot.add((x - 1) + "," + (y + 2));
            }
        }
        if (x - 2 >= 0 && y + 1 < 8) {
            if (tilanne[x - 2][y + 1] == null) {
                siirrot.add((x - 2) + "," + (y + 1));
            } else if (checkSyotava(x - 2, y + 1, tilanne)) {
                siirrot.add((x - 2) + "," + (y + 1));
            }
        }
        if (x - 1 >= 0 && y - 2 >= 0) {
            if (tilanne[x - 1][y - 2] == null) {
                siirrot.add((x - 1) + "," + (y - 2));
            } else if (checkSyotava(x - 1, y - 2, tilanne)) {
                siirrot.add((x - 1) + "," + (y - 2));
            }
        }
        if (x - 2 >= 0 && y - 1 >= 0) {
            if (tilanne[x - 2][y - 1] == null) {
                siirrot.add((x - 2) + "," + (y - 1));
            } else if (checkSyotava(x - 2, y - 1, tilanne)) {
                siirrot.add((x - 2) + "," + (y - 1));
            }
        }
        if (x + 1 < 8 && y - 2 >= 0) {
            if (tilanne[x + 1][y - 2] == null) {
                siirrot.add((x + 1) + "," + (y - 2));
            } else if (checkSyotava(x + 1, y - 2, tilanne)) {
                siirrot.add((x + 1) + "," + (y - 2));
            }
        }
        if (x + 2 < 8 && y - 1 >= 0) {
            if (tilanne[x + 2][y - 1] == null) {
                siirrot.add((x + 2) + "," + (y - 1));
            } else if (checkSyotava(x + 2, y - 1, tilanne)) {
                siirrot.add((x + 2) + "," + (y - 1));
            }
        }

        return siirrot;
    }
}
