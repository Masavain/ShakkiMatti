package shakkimatti;

import java.util.ArrayList;
import java.util.List;

public class Torni extends Nappula {

    public Torni(int x, int y, int color) {
        super(x, y, color);
        this.merkki = "T";
    }

    @Override
    public List<String> mahdollisetSiirrot() {
        List<String> siirrot = new ArrayList<String>();
        for (int i = 0; i < 8; i++) {
            if(i!=x) siirrot.add(i + "," + y);
            if (i!=y) siirrot.add(x + "," + i);
        }
        
        
        return siirrot;
    }

}
