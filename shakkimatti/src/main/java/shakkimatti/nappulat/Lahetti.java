package shakkimatti.nappulat;

import java.util.ArrayList;
import java.util.List;
import shakkimatti.logiikka.Pelaaja;

/**
 * Kuvaa shakkilaudan lähetti-nappulaa, jatkaa abstraktia Nappula-luokkaa
 *
 */
public class Lahetti extends Nappula {

    public Lahetti(int x, int y, Pelaaja color) {
        super(x, y, color);
        setMerkki("L");
    }

    /**
     * tarkastaa lähetin mahdolliset siirrot (suorat viistoihin)
     *
     * @param tilanne tämänhetkinen pelilaudan pelitilanne
     * @return palauttaa listan mahdollisten siirtojen koordinaateista
     */
    @Override
    public List<String> mahdollisetSiirrot(Nappula[][] tilanne) {
        List<String> siirrot = new ArrayList<String>();
        int x = getX();
        int y = getY();
        if (x < 7) {
            int yi = y + 1;
            for (int i = x + 1; i < 8; i++) {

                if (yi > 7) {
                    break;
                }
                if (tilanne[i][yi] == null) {
                    siirrot.add((i) + "," + (yi));
                } else if (checkSyotava(i, yi, tilanne)) {
                    siirrot.add((i) + "," + (yi));
                    break;
                } else if (tilanne[i][yi] != null) {
                    break;
                }
                yi++;
            }
        }

        if (x < 7) {
            int yi = y - 1;
            for (int i = x + 1; i < 8; i++) {
                if (yi < 0) {
                    break;
                }
                if (tilanne[i][yi] == null) {
                    siirrot.add((i) + "," + (yi));
                    break;
                } else if (checkSyotava(i, yi, tilanne)) {
                    siirrot.add((i) + "," + (yi));
                    break;
                } else if (tilanne[i][yi] != null) {
                    break;
                }
                yi--;
            }
        }
        if (x > 0) {
            int yi = y + 1;
            for (int i = x - 1; i >= 0; i--) {
                if (yi > 7) {
                    break;
                }
                if (tilanne[i][yi] == null) {
                    siirrot.add((i) + "," + (yi));
                } else if (checkSyotava(i, yi, tilanne)) {
                    siirrot.add((i) + "," + (yi));
                    break;
                } else if (tilanne[i][yi] != null) {
                    break;
                }
                yi++;
            }
        }
        if (x > 0) {
            int yi = y - 1;
            for (int i = x - 1; i >= 0; i--) {
                if (yi < 0) {
                    break;
                }
                if (tilanne[i][yi] != null) {
                    siirrot.add((i) + "," + (yi));
                } else if (checkSyotava(i, yi, tilanne)) {
                    siirrot.add((i) + "," + (yi));
                    break;
                } else if (tilanne[i][yi] != null) {
                    break;
                }
                yi--;
            }
        }

        return siirrot;
    }

}
