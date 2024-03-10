public class Vendedor extends Persona {
    private byte exp;
    private String eps;
    public Vendedor(Persona p, byte exp, String eps) {
        super(p);
        this.exp = exp;
        this.eps = eps;
    }

    // getters and setters

    public byte getExp() {
        return exp;
    }

    public void setExp(byte exp) {
        this.exp = exp;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }
}
