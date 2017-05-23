package shakkimatti;

import java.util.*;

public class Kuningatar extends Nappula {

    public Kuningatar(int x, int y, int color) {
        super(x, y, color);
        this.merkki = "Q";
    }

    @Override
    public List<String> mahdollisetSiirrot() {
        List<String> siirrot = new ArrayList<String>();
        for (int i = 1; i < 8; i++) {
            if (x + i < 8 && y + i < 8) {
                siirrot.add((x + i) + "," + (y + i));
            }
            if (x + i < 8 && y - i >= 0) {
                siirrot.add((x + i) + "," + (y - i));
            }
            if (x - i >= 0 && y + i < 7) {
                siirrot.add((x - i) + "," + (y + i));
            }
            if (x - i >= 0 && y - i >= 0) {
                siirrot.add((x - i) + "," + (y - i));
            }
            if(i!=x) siirrot.add(i + "," + y);
            if (i!=y) siirrot.add(x + "," + i);
            
        }
        return siirrot;
    }

}
