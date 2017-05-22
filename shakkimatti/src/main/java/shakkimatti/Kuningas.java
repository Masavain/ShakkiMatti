
package shakkimatti;

import java.util.ArrayList;
import java.util.List;


public class Kuningas extends Nappula {

    public Kuningas(int x, int y, int color) {
        super(x, y, color);
        this.merkki = "K";
    }
    
    @Override
    public List<String> mahdollisetSiirrot() {
        List<String> siirrot = new ArrayList<String>();
        int x = getX();
        int y = getY();
        if (y > 0) siirrot.add(x + "," + (y-1));
        if (y < 7) siirrot.add(x + "," + (y+1));
        if (x < 7) siirrot.add((x+1) + "," + y);
        if (x > 0) siirrot.add((x-1) + "," + y);
        return siirrot;
    }
    
}
