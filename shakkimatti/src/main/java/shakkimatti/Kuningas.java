package shakkimatti;

import java.util.ArrayList;
import java.util.List;

public class Kuningas extends Nappula {

    public Kuningas(int x, int y, int color) {
        super(x, y, color);
        this.merkki = "K";
    }

    @Override
    public List<String> mahdollisetSiirrot(Nappula[][] tilanne) {
        List<String> siirrot = new ArrayList<String>();
        if (y > 0) {
            if (tilanne[x][y - 1] == null) {
                siirrot.add(x + "," + (y - 1));
            }
        }
        if (y < 8) {
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
        return siirrot;
    }

    @Override
    public List<String> mahdollisetSyonnit(Nappula[][] tilanne) {
        List<String> siirrot = this.mahdollisetSiirrot(tilanne);
        List<String> syonnit = new ArrayList<String>();

        for (String koord : siirrot) {
            String[] temp = koord.split(",");
            int ax = Integer.parseInt(temp[0]);
            int ay = Integer.parseInt(temp[1]);

            if (tilanne[ax][ay] != null && !tilanne[ax][ay].merkki.equals("K") && tilanne[ax][ay].color != this.color) {
                syonnit.add(koord);
            }
        }
        return syonnit;
    }

}
