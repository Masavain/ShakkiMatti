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
     * tai jos sotilasta ei olla vielä liikutettu, niin yksi tai kaksi ylös/alas).
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
                siirrot.add(x + "," + (y + 1));
                if (!this.liikutettu) {
                    siirrot.add(x + "," + (y + 2));
                }
            }
        } else if (this.getPelaaja() == Pelaaja.VALKOINEN) {
            if (y > 0) {
                siirrot.add(x + "," + (y - 1));
                if (!this.liikutettu) {
                    siirrot.add(x + "," + (y - 2));
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
        List<String> mahdSyonnit = this.mahdollisetSyonnit(lauta);
        if (mahdSiirrot.contains(xMihin + "," + yMihin) || mahdSyonnit.contains(xMihin + "," + yMihin)) {
            setX(xMihin);
            setY(yMihin);
            liikutettu=true;
        }
    }
    
    /**
     * tarkastaa sotilaan mahdolliset syönnit
     *
     * @param tilanne tämänhetkinen pelilaudan pelitilanne
     * @return palauttaa listan mahdollisten syöntien koordinaateista
     */
    @Override
    public List<String> mahdollisetSyonnit(Nappula[][] tilanne) {
        int x = getX();
        int y = getY();
        List<String> syonnit = new ArrayList<String>();
        if (getPelaaja() == Pelaaja.MUSTA) {
            if (x < 7 && y < 7) {
                if (tilanne[x + 1][y + 1] != null && tilanne[x + 1][y + 1].getPelaaja() != this.getPelaaja()
                        && !tilanne[x + 1][y + 1].getMerkki().equals("K")) {
                    syonnit.add((x + 1) + "," + (y + 1));
                }
            }
            if (x > 0 && y < 7) {
                if (tilanne[x - 1][y + 1] != null && tilanne[x - 1][y + 1].getPelaaja() != this.getPelaaja()
                        && !tilanne[x - 1][y + 1].getMerkki().equals("K")) {
                    syonnit.add((x - 1) + "," + (y + 1));
                }
            }
        }
        if (this.getPelaaja() == Pelaaja.VALKOINEN) {
            if (x < 7 && y > 0) {
                if (tilanne[x + 1][y - 1] != null && tilanne[x + 1][y - 1].getPelaaja() != this.getPelaaja()
                        && !tilanne[x + 1][y - 1].getMerkki().equals("K")) {
                    syonnit.add((x + 1) + "," + (y - 1));
                }
            }
            if (x > 0 && y > 0) {
                if (tilanne[x - 1][y - 1] != null && tilanne[x - 1][y - 1].getPelaaja() != this.getPelaaja()
                        && !tilanne[x - 1][y - 1].getMerkki().equals("K")) {
                    syonnit.add((x - 1) + "," + (y - 1));
                }
            }
        }

        return syonnit;
    }

}
