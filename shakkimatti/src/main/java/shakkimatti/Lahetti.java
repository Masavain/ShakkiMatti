
package shakkimatti;

import java.util.List;


public class Lahetti extends Nappula {

    public Lahetti(int x, int y, int color) {
        super(x, y, color);
        this.merkki = "L";
    }

    @Override
    public List<String> mahdollisetSiirrot() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}