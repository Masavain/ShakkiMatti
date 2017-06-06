package shakkimatti.nappulat;

import java.util.*;
import shakkimatti.logiikka.Pelaaja;

public class Kuningatar extends Nappula {

    public Kuningatar(int x, int y, Pelaaja color) {
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
        List<String> syonnit = new ArrayList<String>();
        if (x < 8) {
            int yi = y + 1;
            for (int i = x + 1; i < 8; i++) {

                if (yi == 7) {
                    break;
                }
                if (tilanne[i][yi] != null && tilanne[i][yi].getPelaaja() != getPelaaja() && !tilanne[i][yi].merkki.equals("K")) {
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
                if (tilanne[i][yi] != null && tilanne[i][yi].getPelaaja() != getPelaaja() && !tilanne[i][yi].merkki.equals("K")) {
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
                if (tilanne[i][yi] != null && tilanne[i][yi].getPelaaja() != getPelaaja() && !tilanne[i][yi].merkki.equals("K")) {
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
                if (tilanne[i][yi] != null && tilanne[i][yi].getPelaaja() != getPelaaja() && !tilanne[i][yi].merkki.equals("K")) {
                    syonnit.add((i) + "," + (yi));
                }
                yi--;
            }
        }
        if (this.x < 8) {
            for (int i = this.x + 1; i < 8; i++) {
                if (tilanne[i][this.y] != null && tilanne[i][this.y].getPelaaja() != getPelaaja() && !tilanne[i][this.y].merkki.equals("K")) {
                    syonnit.add(i + "," + this.y);
                    break;
                }
            }
        }
        if (this.x > 0) {
            for (int i = this.x - 1; i >= 0; i--) {
                if (tilanne[i][this.y] != null && tilanne[i][this.y].getPelaaja() != getPelaaja() && !tilanne[i][this.y].merkki.equals("K")) {
                    syonnit.add(i + "," + this.y);
                    break;
                }
            }
        }
        if (this.y < 8) {
            for (int i = this.y + 1; i < 8; i++) {
                if (tilanne[this.x][i] != null && tilanne[this.x][i].getPelaaja() != getPelaaja() && !tilanne[this.x][i].merkki.equals("K")) {
                    syonnit.add(this.x + "," + i);
                    break;
                }
            }
        }
        if (this.y > 0) {
            for (int i = this.y - 1; i >= 0; i--) {
                if (tilanne[this.x][i] != null && tilanne[this.x][i].getPelaaja() != getPelaaja() && !tilanne[this.x][i].merkki.equals("K")) {
                    syonnit.add(this.x + "," + i);
                    break;
                }
            }
        }
        return syonnit;
    }
}
