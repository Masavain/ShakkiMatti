package shakkimatti;

import java.util.ArrayList;
import java.util.List;

public class Lahetti extends Nappula {

    public Lahetti(int x, int y, int color) {
        super(x, y, color);
        this.merkki = "L";
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
        }
        return siirrot;
    }

}
