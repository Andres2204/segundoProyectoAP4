public class Mensajero extends Persona{

    private String eps;
    private String arl;
    private String pension;
    public Mensajero(Persona p, String eps, String arl, String pension) {
        super(p);
        this.eps = eps;
        this.arl = arl;
        this.pension = pension;
    }

    // getters and setters

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getArl() {
        return arl;
    }

    public void setArl(String arl) {
        this.arl = arl;
    }

    public String getPension() {
        return pension;
    }

    public void setPension(String pension) {
        this.pension = pension;
    }
}
