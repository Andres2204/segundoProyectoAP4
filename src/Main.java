import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*
        FORMATO DEL ARCHIVO DE TRABAJADORES:
            TRABAJO,Nombres,Apellidos,Cedula,edad,Años de Experiencia (depende de trabajo)
            Ejemplos:
                p,juanito alimaña, tiene maña, 34, 3 // panadero
                v,asdu asid,asd asd,23, 2 // venderdor
                m,lfkd, dfdf, 23 // mensajero <-- no tiene exp p

        */
        System.out.println("Hello world!");
        try {
            FileManager f = new FileManager("trabajadores.txt");
            String[] lineas = f.readFile().split("-");

            ArrayList<Panadero> panaderos = new ArrayList<>();
            ArrayList<Vendedor> vendedores = new ArrayList<>();
            ArrayList<Mensajero> mensajeros = new ArrayList<>();

            for (int i = 0; i < lineas.length; i++) {
                String[] trabajador = lineas[i].split(",");
                Persona p = new Persona(trabajador[1],trabajador[2], trabajador[3], Byte.parseByte(trabajador[4]));
                if (trabajador[0].equals("p")) {
                    System.out.println("Panadero");
                    panaderos.add(new Panadero(p, Byte.parseByte(trabajador[5])));

                } else if (trabajador[0].equals("v")) {
                    System.out.println("Vendedor");
                    vendedores.add(new Vendedor(p, Byte.parseByte(trabajador[5]), trabajador[6]));

                } else if (trabajador[0].equals("m")) {
                    System.out.println("Mensajero");
                    mensajeros.add(new Mensajero(p, trabajador[5], trabajador[6], trabajador[7]));

                } else System.out.println("-------- Trabajador no identificado --------");

                System.out.println(Arrays.stream(trabajador).toList() + "\n");
            }

            // mostrar panaderos
            System.out.println("-------- Trabajadores : PANADEROS --------");
            for (Panadero p: panaderos) {
                System.out.println("\nnombres: " + p.getNombres() +
                        "\nApellidos: " + p.getApellidos() +
                        "\nCC: " + p.getCC() +
                        "\nEdad: " + p.getEdad() +
                        "\nExperiencia: " + p.getExp()
                );
            }

            // mostrar vendedores
            System.out.println("-------- Trabajadores : VENDEDORES --------");
            for (Vendedor v: vendedores) {
                System.out.println("\nnombres: " + v.getNombres() +
                        "\nApellidos: " + v.getApellidos() +
                        "\nCC: " + v.getCC() +
                        "\nEdad: " + v.getEdad() +
                        "\nExperiencia: " + v.getExp() +
                        "\nEPS: " + v.getEps()
                );
            }



            // mostrar Mensajeros
            System.out.println("-------- Trabajadores : MENSAJEROS --------");
            for (Mensajero m: mensajeros) {
                System.out.println("\nnombres: " + m.getNombres() +
                        "\nApellidos: " + m.getApellidos() +
                        "\nCC: " + m.getCC() +
                        "\nEdad: " + m.getEdad() +
                        "\nEPS: " + m.getEps() +
                        "\nARL: " + m.getArl() +
                        "\nPension: "+  m.getPension()
                );
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}