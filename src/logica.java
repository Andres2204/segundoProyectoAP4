import java.io.IOException;
import java.util.ArrayList;

public class logica {
    private ArrayList<Panadero> panaderos;
    private ArrayList<Vendedor> vendedores;
    private ArrayList<Mensajero> mensajeros;

    public logica() {
        panaderos = new ArrayList<Panadero>();
        vendedores = new ArrayList<Vendedor>();
        mensajeros = new ArrayList<Mensajero>();
        CargarDatos();
    }

    public void CargarDatos() {
        try {
            FileManager f = new FileManager("trabajadores.txt");
            String[] lineas = f.readFile().split("-");

            ArrayList<Panadero> panaderos = new ArrayList<>();
            ArrayList<Vendedor> vendedores = new ArrayList<>();
            ArrayList<Mensajero> mensajeros = new ArrayList<>();

            for (int i = 0; i < lineas.length; i++) {
                String[] trabajador = lineas[i].split(",");
                Persona p = new Persona(trabajador[1], trabajador[2], trabajador[3], Byte.parseByte(trabajador[4]));
                if (trabajador[0].equals("p")) {
                    panaderos.add(new Panadero(p, Byte.parseByte(trabajador[5])));

                } else if (trabajador[0].equals("v")) {
                    vendedores.add(new Vendedor(p, Byte.parseByte(trabajador[5]), trabajador[6]));

                } else if (trabajador[0].equals("m")) {
                    mensajeros.add(new Mensajero(p, trabajador[5], trabajador[6], trabajador[7]));

                }

            }

            this.panaderos = panaderos;
            this.vendedores = vendedores;
            this.mensajeros = mensajeros;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String MostrarTrabajadores() {
        String r = "";
        r += "-------- Trabajadores : PANADEROS --------";
        for (Panadero p : panaderos) {
            r += "\n\nnombres: " + p.getNombres() +
                    "\nApellidos: " + p.getApellidos() +
                    "\nCC: " + p.getCC() +
                    "\nEdad: " + p.getEdad() +
                    "\nExperiencia: " + p.getExp();
        }
        r += "\n\n-------- Trabajadores : VENDEDORES --------";
        for (Vendedor v : vendedores) {
            r += "\n\nnombres: " + v.getNombres() +
                    "\nApellidos: " + v.getApellidos() +
                    "\nCC: " + v.getCC() +
                    "\nEdad: " + v.getEdad() +
                    "\nExperiencia: " + v.getExp() +
                    "\nEPS: " + v.getEps();
        }
        r += "\n\n-------- Trabajadores : MENSAJEROS --------";
        for (Mensajero m : mensajeros) {
            r += "\n\nnombres: " + m.getNombres() +
                    "\nApellidos: " + m.getApellidos() +
                    "\nCC: " + m.getCC() +
                    "\nEdad: " + m.getEdad() +
                    "\nEPS: " + m.getEps() +
                    "\nARL: " + m.getArl() +
                    "\nPension: " + m.getPension();
        }
        return r;
    }

    public String BuscarTrabajador(String CC) {
        String r = "";
        for (Mensajero m : mensajeros) {
            if (m.getCC().equals(CC)) {
                r = "\nnombres: " + m.getNombres() +
                        "\nApellidos: " + m.getApellidos() +
                        "\nCC: " + m.getCC() +
                        "\nEdad: " + m.getEdad() +
                        "\nEPS: " + m.getEps() +
                        "\nARL: " + m.getArl() +
                        "\nPension: " + m.getPension();
            }
        }
        if (r.isEmpty()) {
            for (Vendedor v : vendedores) {
                if (v.getCC().equals(CC)) {
                    r = "\nnombres: " + v.getNombres() +
                            "\nApellidos: " + v.getApellidos() +
                            "\nCC: " + v.getCC() +
                            "\nEdad: " + v.getEdad() +
                            "\nExperiencia: " + v.getExp() +
                            "\nEPS: " + v.getEps();
                }

            }

        }
        if (r.isEmpty()) {
            for (Panadero p : panaderos) {
                if (p.getCC().equals(CC)) {
                    r = "\nnombres: " + p.getNombres() +
                            "\nApellidos: " + p.getApellidos() +
                            "\nCC: " + p.getCC() +
                            "\nEdad: " + p.getEdad() +
                            "\nExperiencia: " + p.getExp();
                }

            }
        }
        if (r.isEmpty()) {
            r = "No hay un trabajador con ese nombre";
        }
        return r;
    }

    public float PorcentajeEps(String eps) {
        float NtrabajadoresEnEps = 0;
        for (Mensajero m : mensajeros) {
            if (m.getEps().equals(eps)) {
                NtrabajadoresEnEps++;
            }
        }
        for (Vendedor v : vendedores) {
            if (v.getEps().equals(eps)) {
                NtrabajadoresEnEps++;
            }
        }
        return (NtrabajadoresEnEps/(mensajeros.size()+panaderos.size()+vendedores.size()))*100;
    }

    public String NombresTrabajadoresEnPension(String Pension){
        String r = "";
        for (Mensajero m : mensajeros) {
            if (m.getPension().equals(Pension)) {
                r += "\n"+m.getNombres()+" "+m.getApellidos()+"\n";
            }
        }
        return r;
    }

    public void IngresarTrabajador(Panadero panadero){
        try {
            panaderos.add(panadero);
            FileManager f = new FileManager("trabajadores.txt");
            f.adicionarLinea("\np,"+panadero.getNombres()+","+panadero.getApellidos()+","+panadero.getCC()+","+panadero.getEdad()+","+panadero.getExp());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void IngresarTrabajador(Vendedor vendedor){
        try {
            vendedores.add(vendedor);
            FileManager f = new FileManager("trabajadores.txt");
            f.adicionarLinea("\nv,"+vendedor.getNombres()+","+vendedor.getApellidos()+","+vendedor.getCC()+","+vendedor.getEdad()+","+vendedor.getExp()+","+vendedor.getEps());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void IngresarTrabajador(Mensajero mensajero){
        try {
            mensajeros.add(mensajero);
            FileManager f = new FileManager("trabajadores.txt");
            f.adicionarLinea("\nm,"+mensajero.getNombres()+","+mensajero.getApellidos()+","+mensajero.getCC()+","+mensajero.getEdad()+","+mensajero.getEps()+","+mensajero.getArl()+","+mensajero.getPension());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
