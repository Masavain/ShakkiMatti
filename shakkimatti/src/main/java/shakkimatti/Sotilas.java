package shakkimatti;

import java.util.*;

public class Sotilas extends Nappula {

    boolean liikutettu;

    public Sotilas(int x, int y, int color) {
        super(x, y, color);
        this.merkki = "S";
        this.liikutettu = false;
    }

    @Override
    public List<String> mahdollisetSiirrot() {
        List<String> siirrot = new ArrayList<String>();
        if (this.color == 0) {
            if (y < 8) {
                siirrot.add(x + "," + (y + 1));
                if (!this.liikutettu) {
                    siirrot.add(x + "," + (y + 2));
                }
            }
        } else if (this.color == 1) {
            if (y >= 0) {
                siirrot.add(x + "," + (y - 1));
                if (!this.liikutettu) {
                    siirrot.add(x + "," + (y - 2));
                }
            }
        }
        return siirrot;
    }

    @Override
    public void liiku(int x, int y) {
        List<String> mahdSiirrot = this.mahdollisetSiirrot();
        if (mahdSiirrot.contains(x + "," + y)) {
            if (!this.liikutettu) {
                this.liikutettu = true;
            }
            this.y = y;
        }

    }
}
