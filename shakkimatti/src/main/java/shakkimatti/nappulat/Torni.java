package shakkimatti.nappulat;

import java.util.ArrayList;
import java.util.List;

public class Torni extends Nappula {

    public Torni(int x, int y, int color) {
        super(x, y, color);
        this.merkki = "T";
    }

    @Override
    public List<String> mahdollisetSiirrot(Nappula[][] tilanne) {
        List<String> siirrot = new ArrayList<String>();
        if (this.x < 7 && x >= 0) {
            for (int i = this.x + 1; i < 8; i++) {
                if (tilanne[i][this.y] == null) {
                    siirrot.add(i + "," + this.y);
                } else {
                    break;
                }
            }
        }

        if (this.x <= 7 && this.x > 0) {
            for (int i = this.x - 1; i >= 0; i--) {

                if (tilanne[i][this.y] == null) {
                    siirrot.add(i + "," + this.y);
                } else {
                    break;
                }
            }
        }

        if (this.y < 7 && this.y >= 0) {
            for (int i = this.y + 1; i < 8; i++) {

                if (tilanne[this.x][i] == null) {
                    siirrot.add(this.x + "," + i);
                } else {
                    break;
                }
            }
        }
        if (this.y > 0 && this.y <= 7) {
            for (int i = this.y - 1; i >= 0; i--) {
                if (tilanne[this.x][i] == null) {
                    siirrot.add(this.x + "," + i);
                } else {
                    break;
                }
            }
        }

        return siirrot;
    }

    @Override
    public List<String> mahdollisetSyonnit(Nappula[][] tilanne) {
        List<String> syonnit = new ArrayList<String>();
        if (this.x < 7 && this.x >= 0) {
            for (int i = this.x + 1; i < 8; i++) {
                if (tilanne[i][this.y] != null
                        && tilanne[i][this.y].color != this.color
                        && !tilanne[i][this.y].merkki.equals("K")) {
                    syonnit.add(i + "," + this.y);
                    break;
                }
            }
        }
        if (this.x <= 7 && this.x > 0) {
            for (int i = this.x - 1; i >= 0; i--) {

                if (tilanne[i][this.y] != null
                        && tilanne[i][this.y].color != this.color
                        && !tilanne[i][this.y].merkki.equals("K")) {
                    syonnit.add(i + "," + this.y);
                    break;
                }
            }
        }

        if (this.y < 7 && this.y >= 0) {
            for (int i = this.y + 1; i < 8; i++) {

                if (tilanne[this.x][i] != null
                        && tilanne[this.x][i].color != this.color
                        && !tilanne[this.x][i].merkki.equals("K")) {
                    syonnit.add(this.x + "," + i);
                    break;
                }

            }
        }
        if (this.y <= 7 && this.y > 0) {
            for (int i = this.y - 1; i >= 0; i--) {
                if (tilanne[this.x][i] != null
                        && tilanne[this.x][i].color != this.color
                        && !tilanne[this.x][i].merkki.equals("K")) {
                    syonnit.add(this.x + "," + i);
                    break;
                }
            }
        }

        return syonnit;
    }

}
