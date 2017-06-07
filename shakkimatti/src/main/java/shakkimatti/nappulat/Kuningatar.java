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
     * ylös/alas/ oikealle/vasemmalle)
     *
     * @param tilanne tämänhetkinen pelilaudan pelitilanne
     * @return palauttaa listan mahdollisten siirtojen koordinaateista
     */
    @Override
    public List<String> mahdollisetSiirrot(Nappula[][] tilanne) {
        List<String> siirrot = new ArrayList<String>();
        int x = getX();
        int y = getY();
        if (x < 8) {
            for (int i = x + 1; i < 8; i++) {
                if (tilanne[i][y] == null) {
                    siirrot.add(i + "," + y);
                } else {
                    break;
                }
            }
        }
        if (x > 0) {
            for (int i = x - 1; i >= 0; i--) {

                if (tilanne[i][y] == null) {
                    siirrot.add(i + "," + y);
                } else {
                    break;
                }
            }
        }
        if (y < 8) {
            for (int i = y + 1; i < 8; i++) {
                if (tilanne[x][i] == null) {
                    siirrot.add(x + "," + i);
                } else {
                    break;
                }
            }
        }
        if (y > 0) {
            for (int i = y - 1; i >= 0; i--) {
                if (tilanne[x][i] == null) {
                    siirrot.add(x + "," + i);
                } else {
                    break;
                }
            }
        }
        if (x < 8) {
            int yi = y + 1;
            for (int i = x + 1; i < 8; i++) {
                if (yi == 7) {
                    break;
                }
                if (tilanne[i][yi] != null) {
                    break;
                } else {
                    siirrot.add((i) + "," + (yi));
                }
                yi++;
            }
        }
        if (x < 8) {
            int yi = y - 1;
            for (int i = x + 1; i < 8; i++) {
                if (yi == -1) {
                    break;
                }
                if (tilanne[i][yi] != null) {
                    break;
                } else {
                    siirrot.add((i) + "," + (yi));
                }
                yi--;
            }
        }
        if (x > 0) {
            int yi = y + 1;
            for (int i = x - 1; i >= 0; i--) {
                if (yi == 7) {
                    break;
                }
                if (tilanne[i][yi] != null) {
                    break;
                } else {
                    siirrot.add((i) + "," + (yi));
                }
                yi++;
            }
        }
        if (x > 0) {
            int yi = y - 1;
            for (int i = x - 1; i >= 0; i--) {
                if (yi == -1) {
                    break;
                }
                if (tilanne[i][yi] != null) {
                    break;
                } else {
                    siirrot.add((i) + "," + (yi));
                }
                yi--;
            }
        }
        return siirrot;
    }

    /**
     * tarkastaa kuningattaren mahdolliset syönnit (suorat viistoihin ja
     * ylös/alas/ oikealle/vasemmalle)
     *
     * @param tilanne tämänhetkinen pelilaudan pelitilanne
     * @return palauttaa listan mahdollisten syöntien koordinaateista
     */
    @Override
    public List<String> mahdollisetSyonnit(Nappula[][] tilanne) {
        List<String> syonnit = new ArrayList<String>();
        int x = getX();
        int y = getY();
        if (x < 8) {
            int yi = y + 1;
            for (int i = x + 1; i < 8; i++) {
                if (yi == 7) {
                    break;
                }
                if (checkSyotava(i, yi, tilanne)) {
                    syonnit.add((i) + "," + (yi));
                }
                yi++;
            }
        }
        if (x < 8) {
            int yi = y - 1;
            for (int i = x + 1; i < 8; i++) {
                if (yi == -1) {
                    break;
                }
                if (checkSyotava(i, yi, tilanne)) {
                    syonnit.add((i) + "," + (yi));
                }
                yi--;
            }
        }
        if (x > 0) {
            int yi = y + 1;
            for (int i = x - 1; i >= 0; i--) {
                if (yi == 7) {
                    break;
                }
                if (checkSyotava(i, yi, tilanne)) {
                    syonnit.add((i) + "," + (yi));
                }
                yi++;
            }
        }
        if (x > 0) {
            int yi = y - 1;
            for (int i = x - 1; i >= 0; i--) {
                if (yi == -1) {
                    break;
                }
                if (checkSyotava(i, yi, tilanne)) {
                    syonnit.add((i) + "," + (yi));
                }
                yi--;
            }
        }
        if (x < 8) {
            for (int i = x + 1; i < 8; i++) {
                if (checkSyotava(i, y, tilanne)) {
                    syonnit.add(i + "," + y);
                    break;
                }
            }
        }
        if (x > 0) {
            for (int i = x - 1; i >= 0; i--) {
                if (checkSyotava(i, y, tilanne)) {
                    syonnit.add(i + "," + y);
                    break;
                }
            }
        }
        if (y < 8) {
            for (int i = y + 1; i < 8; i++) {
                if (checkSyotava(x, i, tilanne)) {
                    syonnit.add(x + "," + i);
                    break;
                }
            }
        }
        if (y > 0) {
            for (int i = y - 1; i >= 0; i--) {
                if (checkSyotava(x, i, tilanne)) {
                    syonnit.add(x + "," + i);
                    break;
                }
            }
        }
        return syonnit;
    }

    public boolean checkSyotava(int x, int y, Nappula[][] tilanne) {
        if (tilanne[x][y] != null && tilanne[x][y].getPelaaja() != getPelaaja() && !tilanne[x][y].getMerkki().equals("K")) {
            return true;
        }
        return false;
    }
}
