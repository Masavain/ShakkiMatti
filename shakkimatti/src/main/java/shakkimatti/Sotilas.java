
package shakkimatti;

import java.util.*;

public class Sotilas extends Nappula {

    public Sotilas(int x, int y, int color) {
        super(x, y, color);
        this.merkki = "S";
    }

    @Override
    public List<String> mahdollisetSiirrot() {
        List<String> siirrot = new ArrayList<String>();
        siirrot.add(getX() +"," + (getY()+1));
        return siirrot;
    }
    
    
    
}
