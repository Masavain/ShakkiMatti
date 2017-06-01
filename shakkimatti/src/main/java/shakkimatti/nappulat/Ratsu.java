package shakkimatti.nappulat;

import java.util.*;

public class Ratsu extends Nappula {

    public Ratsu(int x, int y, int color) {
        super(x, y, color);
        this.merkki = "R";
    }

    @Override
    public List<String> mahdollisetSiirrot(Nappula[][] tilanne) {
        List<String> siirrot = new ArrayList<String>();

        if (x + 1 < 8 && y + 2 < 8) {
            if (tilanne[x + 1][y + 2] == null) {
                siirrot.add((x + 1) + "," + (y + 2));
            }
        }
        if (x + 2 < 8 && y + 1 < 8) {
            if (tilanne[x + 2][y + 1] == null) {
                siirrot.add((x + 2) + "," + (y + 1));
            }
        }
        if (x - 1 >= 0 && y + 2 < 8) {
            if (tilanne[x - 1][y + 2] == null) {
                siirrot.add((x - 1) + "," + (y + 2));
            }
        }
        if (x - 2 >= 0 && y + 1 < 8) {
            if (tilanne[x - 2][y + 1] == null) {
                siirrot.add((x - 2) + "," + (y + 1));
            }
        }
        if (x - 1 >= 0 && y - 2 >= 0) {
            if (tilanne[x - 1][y - 2] == null) {
                siirrot.add((x - 1) + "," + (y - 2));
            }
        }
        if (x - 2 >= 0 && y - 1 >= 0) {
            if (tilanne[x - 2][y - 1] == null) {
                siirrot.add((x - 2) + "," + (y - 1));
            }
        }
        if (x + 1 < 8 && y - 2 >= 0) {
            if (tilanne[x + 1][y - 2] == null) {
                siirrot.add((x + 1) + "," + (y - 2));
            }
        }
        if (x + 2 < 8 && y - 1 >= 0) {
            if (tilanne[x + 2][y - 1] == null) {
                siirrot.add((x + 2) + "," + (y - 1));
            }
        }

        return siirrot;
    }

    @Override
    public List<String> mahdollisetSyonnit(Nappula[][] tilanne) {
        List<String> syonnit = new ArrayList<String>();

        if (x + 1 < 8 && y + 2 < 8) {
            if (tilanne[x + 1][y + 2] != null
                    && tilanne[x + 1][y + 2].color != this.color 
                    && !tilanne[x + 1][y + 2].merkki.equals("K")) {
                syonnit.add((x + 1) + "," + (y + 2));
            }
        }
        if (x + 2 < 8 && y + 1 < 8) {
            if (tilanne[x + 2][y + 1] != null
                    && tilanne[x + 2][y + 1].color != this.color 
                    && !tilanne[x + 2][y + 1].merkki.equals("K")) {
                syonnit.add((x + 2) + "," + (y + 1));
            }
        }
        if (x - 1 >= 0 && y + 2 < 8) {
            if (tilanne[x - 1][y + 2] != null
                    && tilanne[x - 1][y + 2].color != this.color 
                    && !tilanne[x - 1][y + 2].merkki.equals("K")) {
                syonnit.add((x - 1) + "," + (y + 2));
            }
        }
        if (x - 2 >= 0 && y + 1 < 8) {
            if (tilanne[x - 2][y + 1] != null
                    && tilanne[x - 2][y + 1].color != this.color 
                    && !tilanne[x - 2][y + 1].merkki.equals("K")) {
                syonnit.add((x - 2) + "," + (y + 1));
            }
        }
        if (x - 1 >= 0 && y - 2 >= 0) {
            if (tilanne[x - 1][y - 2] != null
                    && tilanne[x - 1][y - 2].color != this.color 
                    && !tilanne[x - 1][y - 2].merkki.equals("K")) {
                syonnit.add((x - 1) + "," + (y - 2));
            }
        }
        if (x - 2 >= 0 && y - 1 >= 0) {
            if (tilanne[x - 2][y - 1] != null
                    && tilanne[x - 2][y - 1].color != this.color 
                    && !tilanne[x - 2][y - 1].merkki.equals("K")) {
                syonnit.add((x - 2) + "," + (y - 1));
            }
        }
        if (x + 1 < 8 && y - 2 >= 0) {
            if (tilanne[x + 1][y - 2] != null 
                    && tilanne[x + 1][y - 2].color != this.color 
                    && !tilanne[x + 1][y - 2].merkki.equals("K")) {
                syonnit.add((x + 1) + "," + (y - 2));
            }
        }
        if (x + 2 < 8 && y - 1 >= 0) {
            if (tilanne[x + 2][y - 1] != null 
                    && tilanne[x + 2][y - 1].color != this.color 
                    && !tilanne[x + 2][y - 1].merkki.equals("K")) {
                syonnit.add((x + 2) + "," + (y - 1));
            }
        }

        return syonnit;
    }


}
