package shakkimatti.nappulat;

import java.util.*;
import shakkimatti.logiikka.Pelaaja;

/**
 * Kuvaa shakkilaudan sotilas-nappulaa, jatkaa abstraktia Nappula-luokkaa.
 *
 */
public class Sotilas extends Nappula {

    public boolean liikutettu;

    /**
     * konstruktori, luo uuden kuninkaan.
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     * @param color pelaaja, jolle nappula kuuluu
     * @param liikutettu kuvastaa sitä, onko sotilasta liikutettu vai ei, aluksi
     * yleensä false;
     */
    public Sotilas(int x, int y, Pelaaja color, boolean liikutettu) {
        super(x, y, color);
        setMerkki("S");
        this.liikutettu = liikutettu;
    }

    @Override
    public List<String> mahdollisetSiirrot(Nappula[][] tilanne) {
        List<String> siirrot = new ArrayList<String>();
        int x = getX();
        int y = getY();
        if (this.getPelaaja() == Pelaaja.MUSTA) {
            if (y < 7) {
                if (tilanne[x][y + 1] == null) {
                    siirrot.add(x + "," + (y + 1));
                }
                if (y < 6 && !this.liikutettu && tilanne[x][y + 2] == null) {
                    siirrot.add(x + "," + (y + 2));
                }
            }
        } else if (this.getPelaaja() == Pelaaja.VALKOINEN) {
            if (y > 0) {
                if (tilanne[x][y - 1] == null) {
                    siirrot.add(x + "," + (y - 1));
                }
                if (y > 1 && !this.liikutettu && tilanne[x][y - 2] == null) {
                    siirrot.add(x + "," + (y - 2));
                }
            }
        }

        if (getPelaaja() == Pelaaja.MUSTA) {
            if (x < 7 && y < 7) {
                if (checkSyotava(x + 1, y + 1, tilanne)) {
                    siirrot.add((x + 1) + "," + (y + 1));
                }
            }
            if (x > 0 && y < 7) {
                if (checkSyotava(x - 1, y + 1, tilanne)) {
                    siirrot.add((x - 1) + "," + (y + 1));
                }
            }
        }
        if (this.getPelaaja() == Pelaaja.VALKOINEN) {
            if (x < 7 && y > 0) {
                if (checkSyotava(x + 1, y - 1, tilanne)) {
                    siirrot.add((x + 1) + "," + (y - 1));
                }
            }
            if (x > 0 && y > 0) {
                if (checkSyotava(x - 1, y - 1, tilanne)) {
                    siirrot.add((x - 1) + "," + (y - 1));
                }
            }
        }
        return siirrot;
    }

    /**
     * muuten kuten Nappulan liiku, mutta liikkumisen jälkeen asetetaan sotilaan
     * liikutettu-muuttuja true:ksi.
     *
     */
    @Override
    public void liiku(int xMihin, int yMihin, Nappula[][] lauta) {
        List<String> mahdSiirrot = this.mahdollisetSiirrot(lauta);
        if (mahdSiirrot.contains(xMihin + "," + yMihin)) {
            setX(xMihin);
            setY(yMihin);
            liikutettu = true;
        }
    }

}
