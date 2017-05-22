
package shakkimatti;

import java.util.List;

public class Ratsu extends Nappula {

    public Ratsu(int x, int y, int color) {
        super(x, y, color);
        this.merkki = "R";
    }

    @Override
    public List<String> mahdollisetSiirrot() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
