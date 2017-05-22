
package shakkimatti;

import java.util.List;


public class Torni extends Nappula {

    public Torni(int x, int y, int color) {
        super(x, y, color);
        this.merkki = "T";
    }

    @Override
    public List<String> mahdollisetSiirrot() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
