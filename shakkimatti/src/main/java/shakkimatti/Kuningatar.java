package shakkimatti;

import java.util.*;

public class Kuningatar extends Nappula {

    public Kuningatar(int x, int y, int color) {
        super(x, y, color);
        this.merkki = "Q";
    }

    @Override
    public List<String> mahdollisetSiirrot(Nappula[][] tilanne) {
        List<String> siirrot = new ArrayList<String>();
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
