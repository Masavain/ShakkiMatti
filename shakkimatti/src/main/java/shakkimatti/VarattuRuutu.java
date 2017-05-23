
package shakkimatti;

public class VarattuRuutu extends Ruutu{

    private Nappula nappulaRuudussa;
    
    public VarattuRuutu(int x, int y) {
        super(x, y);
    }

    public Nappula getNappulaRuudussa() {
        return nappulaRuudussa;
    }

    public void setNappulaRuudussa(Nappula nappulaRuudussa) {
        this.nappulaRuudussa = nappulaRuudussa;
    }    

    @Override
    public String toString() {
        return "VarattuRuutu{" + "x=" + x + ", y=" + y + '}' 
                + ":" + nappulaRuudussa;
    }
    
    
}
