package shakkimatti.nappulat;

import java.util.ArrayList;
import java.util.List;
import shakkimatti.logiikka.Pelaaja;

/**
 * Kuvaa shakkilaudan kuningas-nappulaa, jatkaa abstraktia Nappula-luokkaa
 *
 */
public class Kuningas extends Nappula {

    public Kuningas(int x, int y, Pelaaja color) {
        super(x, y, color);
        setMerkki("K");
    }

    /**
     *  tarkastaa kuninkaan mahdolliset siirrot (ylä-/alaviistot sekä ylös, alas
     *  oikea ja vasen).
     * @param tilanne tämänhetkinen pelilaudan pelitilanne
     * @return palauttaa listan mahdollisten siirtojen koordinaateista
     */
    @Override
    public List<String> mahdollisetSiirrot(Nappula[][] tilanne) {
        List<String> siirrot = new ArrayList<String>();
        int x = getX();
        int y = getY();
        if (getY() > 0) {
            if (tilanne[x][y - 1] == null) {
                siirrot.add(x + "," + (y - 1));
            }
        }
        if (getY() < 8) {
            if (tilanne[x][y + 1] == null) {
                siirrot.add(x + "," + (y + 1));
            }
        }
        if (x < 8) {
            if (tilanne[x + 1][y] == null) {
                siirrot.add((x + 1) + "," + y);
            }
        }
        if (x > 0) {
            if (tilanne[x - 1][y] == null) {
                siirrot.add((x - 1) + "," + y);
            }
        }

        if (x > 0 && y > 0) {
            if (tilanne[x - 1][y - 1] == null) {
                siirrot.add((x - 1) + "," + (y - 1));
            }
        }
        if (x > 0 && y < 8) {
            if (tilanne[x - 1][y + 1] == null) {
                siirrot.add((x - 1) + "," + (y + 1));
            }
        }
        if (x < 8 && y < 8) {
            if (tilanne[x + 1][y + 1] == null) {
                siirrot.add((x + 1) + "," + (y + 1));
            }
        }
        if (x < 8 && y > 0) {
            if (tilanne[x + 1][y - 1] == null) {
                siirrot.add((x + 1) + "," + (y - 1));
            }
        }
        return siirrot;
    }

    /**
     *  tarkastaa kuninkaan mahdolliset syönnit (ylä-/alaviistot sekä ylös, alas
     *  oikea ja vasen).
     * @param tilanne tämänhetkinen pelilaudan pelitilanne
     * @return palauttaa listan mahdollisten syöntien koordinaateista
     */
    @Override
    public List<String> mahdollisetSyonnit(Nappula[][] tilanne) {
        List<String> syonnit = new ArrayList<String>();
        int x = getX();
        int y = getY();
        if (y > 0) {
            if (tilanne[x][y - 1] != null
                    && tilanne[x][y - 1].getPelaaja() != getPelaaja()
                    && !tilanne[x][y - 1].getMerkki().equals("K")) {
                syonnit.add(x + "," + (y - 1));
            }
        }
        if (y < 8) {
            if (tilanne[x][y + 1] != null
                    && tilanne[x][y + 1].getPelaaja() != getPelaaja()
                    && !tilanne[x][y + 1].getMerkki().equals("K")) {
                syonnit.add(x + "," + (y + 1));
            }
        }
        if (x < 8) {
            if (tilanne[x + 1][y] != null
                    && tilanne[x + 1][y].getPelaaja() != getPelaaja()
                    && !tilanne[x + 1][y].getMerkki().equals("K")) {
                syonnit.add((x + 1) + "," + y);
            }
        }
        if (x > 0) {
            if (tilanne[x - 1][y] != null
                    && tilanne[x - 1][y].getPelaaja() != getPelaaja()
                    && !tilanne[x - 1][y].getMerkki().equals("K")) {
                syonnit.add((x - 1) + "," + y);
            }
        }

        if (x > 0 && y > 0) {
            if (tilanne[x - 1][y - 1] != null
                    && tilanne[x - 1][y - 1].getPelaaja() != getPelaaja()
                    && !tilanne[x - 1][y - 1].getMerkki().equals("K")) {
                syonnit.add((x - 1) + "," + (y - 1));
            }
        }
        if (x > 0 && y < 8) {
            if (tilanne[x - 1][y + 1] != null
                    && tilanne[x - 1][y + 1].getPelaaja() != getPelaaja()
                    && !tilanne[x - 1][y + 1].getMerkki().equals("K")) {
                syonnit.add((x - 1) + "," + (y + 1));
            }
        }
        if (x < 8 && y < 8) {
            if (tilanne[x + 1][y + 1] != null
                    && tilanne[x + 1][y + 1].getPelaaja() != getPelaaja()
                    && !tilanne[x + 1][y + 1].getMerkki().equals("K")) {
                syonnit.add((x + 1) + "," + (y + 1));
            }
        }
        if (x < 8 && y > 0) {
            if (tilanne[x + 1][y - 1] != null
                    && tilanne[x + 1][y - 1].getPelaaja() != getPelaaja()
                    && !tilanne[x + 1][y - 1].getMerkki().equals("K")) {
                syonnit.add((x + 1) + "," + (y - 1));
            }
        }
        return syonnit;
    }

}
