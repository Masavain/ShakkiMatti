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
            for (int i = x + 1; i < 8; i++) {
                if (tilanne[i][y] == null) {
                    siirrot.add(i + "," + y);
                } else if (checkSyotava(i, y, tilanne)) {
                    siirrot.add(i + "," + y);
                    break;
                } else if (tilanne[i][y] != null) {
                    break;
                }
            }
        }

        if (x <= 7 && x > 0) {
            for (int i = x - 1; i >= 0; i--) {

                if (tilanne[i][y] == null) {
                    siirrot.add(i + "," + y);
                } else if (checkSyotava(i, y, tilanne)) {
                    siirrot.add(i + "," + y);
                    break;
                } else if (tilanne[i][y] != null) {
                    break;
                }
            }
        }

        if (y < 7 && y >= 0) {
            for (int i = y + 1; i < 8; i++) {
                if (tilanne[x][i] == null) {
                    siirrot.add(x + "," + i);
                } else if (checkSyotava(x, i, tilanne)) {
                    siirrot.add(x + "," + i);
                    break;
                } else if (tilanne[x][i] != null) {
                    break;
                }
            }
        }
        if (y > 0 && y <= 7) {
            for (int i = y - 1; i >= 0; i--) {
                if (tilanne[x][i] == null) {
                    siirrot.add(x + "," + i);
                } else if (checkSyotava(x, i, tilanne)) {
                    siirrot.add(x + "," + i);
                    break;
                } else if (tilanne[x][i] != null) {
                    break;
                }
            }
        }

        return siirrot;
    }
}
