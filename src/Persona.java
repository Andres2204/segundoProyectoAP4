public class Persona {
    private String nombres;
    private String apellidos;
    private String CC;
    private byte edad;

    public Persona(String nombres, String apellidos, String CC, byte edad) {
        this.nombres = nombres;
        this.CC = CC;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public Persona(Persona p) {
        this.nombres = p.getNombres();
        this.apellidos = p.getApellidos();
        this.CC = p.getCC();
        this.edad = p.getEdad();
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCC() {
        return CC;
    }

    public void setCC(String CC) {
        this.CC = CC;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }
}
