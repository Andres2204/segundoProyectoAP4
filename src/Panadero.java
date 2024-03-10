public class Panadero extends Persona {

    private byte exp;
    public Panadero(Persona p, byte exp) {
        super(p);
        this.exp = exp;
    }

    // getters and setters


    public byte getExp() {
        return exp;
    }

    public void setExp(byte exp) {
        this.exp = exp;
    }
}
