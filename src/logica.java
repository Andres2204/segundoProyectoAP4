import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class logica {
    private final ArrayList<Panadero> panaderos;
    private final ArrayList<Vendedor> vendedores;
    private final ArrayList<Mensajero> mensajeros;

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

            for (int i = 0; i < lineas.length; i++) {
                String[] trabajador = lineas[i].split(",");
                Persona p = new Persona(trabajador[1], trabajador[2], trabajador[3], Byte.parseByte(trabajador[4]));

                // Seleccioanar tipo
                if (trabajador[0].equals("p")) { // Panadero
                    panaderos.add(new Panadero(p, Byte.parseByte(trabajador[5])));

                } else if (trabajador[0].equals("v")) { // Vendedor
                    vendedores.add(new Vendedor(p, Byte.parseByte(trabajador[5]), trabajador[6]));

                } else if (trabajador[0].equals("m")) { // Mensajero
                    mensajeros.add(new Mensajero(p, trabajador[5], trabajador[6], trabajador[7]));

                } else System.out.println("Trabajador invalido -> " + trabajador.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String MostrarTrabajadores() {
        String r = "";
        r += "-------- Trabajadores : PANADEROS --------";
        Iterator<Panadero> pi = panaderos.iterator();
        while (pi.hasNext()) {
            Panadero p = pi.next();
            r += "\n\nnombres: " + p.getNombres() +
                    "\nApellidos: " + p.getApellidos() +
                    "\nCC: " + p.getCC() +
                    "\nEdad: " + p.getEdad() +
                    "\nExperiencia: " + p.getExp();
        }

        r += "\n\n-------- Trabajadores : VENDEDORES --------";
        Iterator<Vendedor> vi = vendedores.iterator();
        while (vi.hasNext()) {
            Vendedor v = vi.next();
            r += "\n\nnombres: " + v.getNombres() +
                    "\nApellidos: " + v.getApellidos() +
                    "\nCC: " + v.getCC() +
                    "\nEdad: " + v.getEdad() +
                    "\nExperiencia: " + v.getExp() +
                    "\nEPS: " + v.getEps();
        }

        r += "\n\n-------- Trabajadores : MENSAJEROS --------";
        Iterator<Mensajero> mi = mensajeros.iterator();
        while (mi.hasNext()) {
            Mensajero m = mi.next();
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
            r = "No hay un trabajador con ese numero de cedula.";
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
        return (NtrabajadoresEnEps / (mensajeros.size() + panaderos.size() + vendedores.size())) * 100;
    }

    public String NombresTrabajadoresEnPension(String Pension) {
        String r = "";
        for (Mensajero m : mensajeros) {
            if (m.getPension().equals(Pension)) {
                r += "\n" + m.getNombres() + " " + m.getApellidos() + "\n";
            }
        }
        return r;
    }

    public void IngresarTrabajador(Panadero panadero) {
        try {
            panaderos.add(panadero);
            FileManager f = new FileManager("trabajadores.txt");
            f.adicionarLinea("\np," + panadero.getNombres() + "," + panadero.getApellidos() + "," + panadero.getCC() + "," + panadero.getEdad() + "," + panadero.getExp());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void IngresarTrabajador(Vendedor vendedor) {
        try {
            vendedores.add(vendedor);
            FileManager f = new FileManager("trabajadores.txt");
            f.adicionarLinea("\nv," + vendedor.getNombres() + "," + vendedor.getApellidos() + "," + vendedor.getCC() + "," + vendedor.getEdad() + "," + vendedor.getExp() + "," + vendedor.getEps());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void IngresarTrabajador(Mensajero mensajero) {
        try {
            mensajeros.add(mensajero);
            FileManager f = new FileManager("trabajadores.txt");
            f.adicionarLinea("\nm," + mensajero.getNombres() + "," + mensajero.getApellidos() + "," + mensajero.getCC() + "," + mensajero.getEdad() + "," + mensajero.getEps() + "," + mensajero.getArl() + "," + mensajero.getPension());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public float PromedioExpEnRango(byte Rm,byte RM){
        float NtrabajadoresEnRango = 0;
        float Exp = 0;
        for (Panadero p : panaderos) {
            if (p.getExp() >= Rm && p.getExp() <= RM) {
                NtrabajadoresEnRango++;
                Exp += p.getExp();
            }
        }
        for (Vendedor v : vendedores) {
            if (v.getExp() >= Rm && v.getExp() <= RM) {
                NtrabajadoresEnRango++;
                Exp += v.getExp();
            }
        }
        return Exp/NtrabajadoresEnRango;
    }

}
