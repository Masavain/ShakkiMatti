package shakkimatti;

import java.util.ArrayList;
import java.util.List;

public class Lahetti extends Nappula {

    public Lahetti(int x, int y, int color) {
        super(x, y, color);
        this.merkki = "L";
    }

    @Override
    public List<String> mahdollisetSiirrot(Nappula[][] tilanne) {
        List<String> siirrot = new ArrayList<String>();
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
