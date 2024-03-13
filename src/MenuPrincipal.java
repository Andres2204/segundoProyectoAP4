public class MenuPrincipal extends Menu {

    public MenuPrincipal(String title) {
        super(title);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void menu() {
        // TODO Auto-generated method stub
        while (true) {
            logica logica = new logica();
            String opt = input(
                    "Seleccione una opción:\n1. Mostrar todos los trabajadores\n2. Ingresar un Trabajador\n3. Buscar un Trabajador\n4. Promedio de trabajadores en un rango de años de experiencia determinada\n5. Porcentaje de trabajadores con una Eps determinada\n6. Nombre de Trabajadores con una pension determinada\n7. Salir");
            if (opt == null || opt.equals("7")) {
                System.exit(0);
            }
            switch (opt) {
                case "1":
                    msgScroll(logica.MostrarTrabajadores());

                    break;

                case "2":
                    String Ttrabajador;
                    boolean aux = true;
                    do {
                        Ttrabajador = input("Seleccione una opción:\n1. Panadero\n2. Vendedor\n3. Mensajero");
                        if (!isInt(Ttrabajador) || Integer.parseInt(Ttrabajador) < 1
                                || Integer.parseInt(Ttrabajador) > 3) {
                            msg("Opcion incorrecta");
                        } else
                            aux = false;
                    } while (aux);
                    String NombreTrabajador = input("Nombres del trabajador:");
                    String ApellidoTrabajador = input("Apellidos del trabajador:");
                    String CC;

                    do {
                        CC = input("Cedula del trabajador:");
                        if (!isInt(CC)) {
                            msg("Datos incorrectos");
                        } else
                            aux = false;
                    } while (aux);
                    String edad;
                    do {
                        aux = true;
                        edad = input("Ingrese la edad");
                        if (!isByte(edad) || Byte.parseByte(edad) < 18) {
                            msg("Datos incorrectos");
                        } else
                            aux = false;
                    } while (aux);
                    String exp = "";
                    if (Ttrabajador.equals("1") || Ttrabajador.equals("2")) {
                        aux = true;
                        do {
                            exp = input("Ingrese los años de experiencia");
                            if (!isByte(exp) || Byte.parseByte(exp) < 0) {
                                msg("Datos incorrectos");
                            } else
                                aux = false;
                        } while (aux);
                    }
                    String eps = "";
                    if (Ttrabajador.equals("2") || Ttrabajador.equals("3")) {
                        eps = Eps();
                    }
                    if (Ttrabajador.equals("1")) {
                        logica.IngresarTrabajador(new Panadero(
                                    new Persona(NombreTrabajador, ApellidoTrabajador, CC, Byte.parseByte(edad)),
                                    Byte.parseByte(exp)));
                    }else if(Ttrabajador.equals("2")){
                        logica.IngresarTrabajador(new Vendedor(
                                    new Persona(NombreTrabajador, ApellidoTrabajador, CC, Byte.parseByte(edad)),
                                    Byte.parseByte(exp), eps));
                    }else{
                        String arl = arl();
                            String pension = pension();
                            logica.IngresarTrabajador(new Mensajero(
                                    new Persona(NombreTrabajador, ApellidoTrabajador, CC, Byte.parseByte(edad)), eps,
                                    arl, pension));
                    }
                case "3":
                    msg(logica.BuscarTrabajador(input("Ingrese la cedula del trabjador a buscar")));

                    break;

                case "4":

                    break;
                case "5":
                    String eps2 = Eps();
                    msg(Float.toString(logica.PorcentajeEps(eps2)) + "%");
                    break;
                case "6":
                    String pension2 = pension();
                    msgScroll(logica.NombresTrabajadoresEnPension(pension2));

                    break;
                default:
                    msg("Opción inválida. Por favor, seleccione otra opción.");
            }
        }
    }

    public boolean isInt(String cadena) {
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

    public boolean isByte(String cadena) {
        boolean resultado;
        try {
            Byte.parseByte(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

    public String Eps() {
        String eps2 = "";
        boolean aux = true;
        do {
            String aux2 = input("Seleccione la Eps:\n1. Sura\n2. Savia salud\n3. Salud total");
            if (!isInt(aux2) || Integer.parseInt(aux2) < 1
                    || Integer.parseInt(aux2) > 3) {
                msg("Opcion incorrecta");
            } else {
                aux = false;
                switch (aux2) {
                    case "1":
                        eps2 = "sura";
                        break;
                    case "2":
                        eps2 = "savia salud";
                        break;
                    case "3":
                        eps2 = "salud total";
                        break;
                    default:
                        break;
                }

            }

        } while (aux);
        return eps2;
    }

    public String arl() {
        String arl = "";
        boolean aux = true;
        do {
            String aux2 = input("Seleccione la Eps:\n1. Colmena\n2. Colpatria\n3. Segurosalfa");
            if (!isInt(aux2) || Integer.parseInt(aux2) < 1
                    || Integer.parseInt(aux2) > 3) {
                msg("Opcion incorrecta");
            } else {
                aux = false;
                switch (aux2) {
                    case "1":
                        arl = "colmena";
                        break;
                    case "2":
                        arl = "colpatria";
                        break;
                    case "3":
                        arl = "segurosalfa";
                        break;
                    default:
                        break;
                }

            }

        } while (aux);
        return arl;
    }

    public String pension() {
        String pension = "";
        boolean aux = true;
        do {
            String aux2 = input(
                    "Seleccione la Pension:\n1. Porvenir\n2. Cesanitas\n3. Colpensiones");
            if (!isInt(aux2) || Integer.parseInt(aux2) < 1
                    || Integer.parseInt(aux2) > 3) {
                msg("Opcion incorrecta");
            } else {
                aux = false;
                switch (aux2) {
                    case "1":
                        pension = "porvenir";
                        break;
                    case "2":
                        pension = "cesanitas";
                        break;
                    case "3":
                        pension = "colpensiones";
                        break;
                    default:
                        break;
                }

            }

        } while (aux);
        return pension;
    }
}
