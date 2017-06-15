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
        if (y > 0 && y <= 7 && x >= 0 && x <= 7) {
            if (tilanne[x][y - 1] == null) {
                siirrot.add(x + "," + (y - 1));
            } else if (checkSyotava(x, y - 1, tilanne)) {
                siirrot.add(x + "," + (y - 1));
            }
        }
        if (y >= 0 && y < 7 && x >= 0 && x <= 7) {
            if (tilanne[x][y + 1] == null) {
                siirrot.add(x + "," + (y + 1));
            } else if (checkSyotava(x, y + 1, tilanne)) {
                siirrot.add(x + "," + (y + 1));
            }
        }
        if (y >= 0 && y <= 7 && x >= 0 && x < 7) {
            if (tilanne[x + 1][y] == null) {
                siirrot.add((x + 1) + "," + y);
            } else if (checkSyotava(x + 1, y, tilanne)) {
                siirrot.add((x + 1) + "," + y);
            }
        }
        if (y >= 0 && y <= 7 && x > 0 && x <= 7) {
            if (tilanne[x - 1][y] == null) {
                siirrot.add((x - 1) + "," + y);
            } else if (checkSyotava(x - 1, y, tilanne)) {
                siirrot.add((x - 1) + "," + y);
            }
        }

        if (x > 0 && y > 0 && x <= 7 && y <= 7) {
            if (tilanne[x - 1][y - 1] == null) {
                siirrot.add((x - 1) + "," + (y - 1));
            } else if (checkSyotava(x - 1, y - 1, tilanne)) {
                siirrot.add((x - 1) + "," + (y - 1));
            }
        }
        if (x > 0 && y < 7 && x <= 7 && y >= 0) {
            if (tilanne[x - 1][y + 1] == null) {
                siirrot.add((x - 1) + "," + (y + 1));
            } else if (checkSyotava(x - 1, y + 1, tilanne)) {
                siirrot.add((x - 1) + "," + (y + 1));
            }
        }
        if (x < 7 && y < 7 && y >= 0 && x >= 0) {
            if (tilanne[x + 1][y + 1] == null) {
                siirrot.add((x + 1) + "," + (y + 1));
            } else if (checkSyotava(x + 1, y + 1, tilanne)) {
                siirrot.add((x + 1) + "," + (y + 1));
            }
        }
        if (x < 7 && y > 0 && x >= 0 && y <= 7) {
            if (tilanne[x + 1][y - 1] == null) {
                siirrot.add((x + 1) + "," + (y - 1));
            } else if (checkSyotava(x + 1, y - 1, tilanne)) {
                siirrot.add((x + 1) + "," + (y - 1));
            }
        }
        return siirrot;
    }
}
