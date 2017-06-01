package shakkimatti.nappulat;

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

        if (x > 0 && y > 0) {
            if (tilanne[x - 1][y - 1] == null) {
                siirrot.add((x - 1) + "," + (y - 1));
            }
        }
        if (x > 0 && y < 8) {
            if (tilanne[x - 1][y + 1] == null) {
                siirrot.add((x - 1) + "," + (y + 1));
            }
        }
        if (x < 8 && y < 8) {
            if (tilanne[x + 1][y + 1] == null) {
                siirrot.add((x + 1) + "," + (y + 1));
            }
        }
        if (x < 8 && y > 0) {
            if (tilanne[x + 1][y - 1] == null) {
                siirrot.add((x + 1) + "," + (y - 1));
            }
        }
        return siirrot;
    }

    @Override
    public List<String> mahdollisetSyonnit(Nappula[][] tilanne) {
        List<String> syonnit = new ArrayList<String>();
        if (y > 0) {
            if (tilanne[x][y - 1] != null 
                    && tilanne[x][y - 1].color != this.color 
                    && !tilanne[x][y - 1].merkki.equals("K")) {
                syonnit.add(x + "," + (y - 1));
            }
        }
        if (y < 8) {
            if (tilanne[x][y + 1] != null
                    && tilanne[x][y + 1].color != this.color 
                    && !tilanne[x][y + 1].merkki.equals("K")) {
                syonnit.add(x + "," + (y + 1));
            }
        }
        if (x < 8) {
            if (tilanne[x + 1][y] != null
                    && tilanne[x + 1][y].color != this.color 
                    && !tilanne[x + 1][y].merkki.equals("K")) {
                syonnit.add((x + 1) + "," + y);
            }
        }
        if (x > 0) {
            if (tilanne[x - 1][y] != null
                    && tilanne[x - 1][y].color != this.color 
                    && !tilanne[x - 1][y].merkki.equals("K")) {
                syonnit.add((x - 1) + "," + y);
            }
        }

        if (x > 0 && y > 0) {
            if (tilanne[x - 1][y - 1] != null
                    && tilanne[x - 1][y - 1].color != this.color 
                    && !tilanne[x - 1][y - 1].merkki.equals("K")) {
                syonnit.add((x - 1) + "," + (y - 1));
            }
        }
        if (x > 0 && y < 8) {
            if (tilanne[x - 1][y + 1] != null
                    && tilanne[x - 1][y + 1].color != this.color 
                    && !tilanne[x - 1][y + 1].merkki.equals("K")) {
                syonnit.add((x - 1) + "," + (y + 1));
            }
        }
        if (x < 8 && y < 8) {
            if (tilanne[x + 1][y + 1] != null
                    && tilanne[x + 1][y + 1].color != this.color 
                    && !tilanne[x + 1][y + 1].merkki.equals("K")) {
                syonnit.add((x + 1) + "," + (y + 1));
            }
        }
        if (x < 8 && y > 0) {
            if (tilanne[x + 1][y - 1] != null
                    && tilanne[x + 1][y - 1].color != this.color 
                    && !tilanne[x + 1][y - 1].merkki.equals("K")) {
                syonnit.add((x + 1) + "," + (y - 1));
            }
        }
        return syonnit;
    }

}
