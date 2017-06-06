package shakkimatti.nappulat;

import java.util.*;
import shakkimatti.logiikka.Pelaaja;

public class Sotilas extends Nappula {

    public boolean liikutettu;

    public Sotilas(int x, int y, Pelaaja color, boolean liikutettu) {
        super(x, y, color);
        this.merkki = "S";
        this.liikutettu = liikutettu;
    }

    @Override
    public List<String> mahdollisetSiirrot(Nappula[][] tilanne) {
        List<String> siirrot = new ArrayList<String>();
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

    @Override
    public void liiku(int x, int y, Nappula[][] lauta) {
        List<String> mahdSiirrot = this.mahdollisetSiirrot(lauta);
        if (mahdSiirrot.contains(x + "," + y)) {
            if (!this.liikutettu) {
                this.liikutettu = true;
            }
            this.y = y;
        }
    }

    @Override
    public List<String> mahdollisetSyonnit(Nappula[][] tilanne) {
        List<String> syonnit = new ArrayList<String>();
        if (this.getPelaaja() == Pelaaja.MUSTA) {
            if (this.x < 7 && this.y < 7) {
                if (tilanne[this.x + 1][this.y + 1] != null && tilanne[this.x + 1][this.y + 1].getPelaaja() != this.getPelaaja()
                        && !tilanne[this.x + 1][this.y + 1].merkki.equals("K")) {
                    syonnit.add((x + 1) + "," + (y + 1));
                }
            }
            if (this.x > 0 && this.y < 7) {
                if (tilanne[this.x - 1][this.y + 1] != null && tilanne[this.x - 1][this.y + 1].getPelaaja() != this.getPelaaja()
                        && !tilanne[this.x - 1][this.y + 1].merkki.equals("K")) {
                    syonnit.add((x - 1) + "," + (y + 1));
                }
            }
        }
        if (this.getPelaaja() == Pelaaja.VALKOINEN) {
            if (this.x < 7 && this.y > 0) {
                if (tilanne[this.x + 1][this.y - 1] != null && tilanne[this.x + 1][this.y - 1].getPelaaja() != this.getPelaaja()
                        && !tilanne[this.x + 1][this.y - 1].merkki.equals("K")) {
                    syonnit.add((x + 1) + "," + (y - 1));
                }
            }
            if (this.x > 0 && this.y > 0) {
                if (tilanne[this.x - 1][this.y - 1] != null && tilanne[this.x - 1][this.y - 1].getPelaaja() != this.getPelaaja()
                        && !tilanne[this.x - 1][this.y - 1].merkki.equals("K")) {
                    syonnit.add((x - 1) + "," + (y - 1));
                }
            }
        }

        return syonnit;
    }

}
