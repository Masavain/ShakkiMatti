package shakkimatti;

import java.util.ArrayList;
import java.util.List;

public class Ratsu extends Nappula {

    public Ratsu(int x, int y, int color) {
        super(x, y, color);
        this.merkki = "R";
    }

    @Override
    public List<String> mahdollisetSiirrot() {
        List<String> siirrot = new ArrayList<String>();

        if (x + 1 < 8 && y + 2 < 8) siirrot.add((x+1)+","+(y+2));
        if (x + 2 < 8 && y + 1 < 8) siirrot.add((x+2)+","+(y+1));
        if (x - 1 >= 0 && y + 2 < 8) siirrot.add((x-1)+","+(y+2));
        if (x - 2 >= 0 && y + 1 < 8) siirrot.add((x-2)+","+(y+1));
        
        if (x - 1 >= 0 && y - 2 >= 0) siirrot.add((x-1)+","+(y-2));
        if (x - 2 >= 0 && y - 1 >= 0) siirrot.add((x-2)+","+(y-1));
        if (x + 1 < 8 && y - 2 >= 0) siirrot.add((x+1)+","+(y-2));
        if (x + 2 < 8 && y - 1 >= 0) siirrot.add((x+2)+","+(y-1));

        
        return siirrot;
    }

}
