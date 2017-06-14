package shakkimatti.nappulat;

import java.util.*;
import shakkimatti.logiikka.Pelaaja;

/**
 * Kuvaa shakkilaudan sotilas-nappulaa, jatkaa abstraktia Nappula-luokkaa
 *
 */
public class Sotilas extends Nappula {

    public boolean liikutettu;

    public Sotilas(int x, int y, Pelaaja color, boolean liikutettu) {
        super(x, y, color);
        setMerkki("S");
        this.liikutettu = liikutettu;
    }

    /**
     * tarkastaa sotilaan mahdolliset siirrot (yhden ylös/alas riippuen väristä,
     * tai jos sotilasta ei olla vielä liikutettu, niin yksi tai kaksi
     * ylös/alas).
     *
     * @param tilanne tämänhetkinen pelilaudan pelitilanne
     * @return palauttaa listan mahdollisten siirtojen koordinaateista
     */
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
        setX(xMihin);
        setY(yMihin);
        liikutettu = true;
    }

}
