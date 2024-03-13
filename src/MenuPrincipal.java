public class MenuPrincipal extends Menu {

    public MenuPrincipal(String title) {
        super(title);
    }

    @Override
    public void menu() {
        while (true) {
            logica logica = new logica();
            String opt = input(
                    "Seleccione una opción:\n" +
                            "1. Mostrar todos los trabajadores\n" +
                            "2. Ingresar un Trabajador\n" +
                            "3. Buscar un Trabajador\n" +
                            "4. Promedio de trabajadores en un rango de años de experiencia determinada\n" +
                            "5. Porcentaje de trabajadores con una Eps determinada\n" +
                            "6. Nombre de Trabajadores con una pension determinada\n" +
                            "0. Salir");

            if (opt == null || opt.equals("0")) System.exit(0);

            switch (opt) {
                case "1": // Mostrar trabajadores
                    msgScroll(logica.MostrarTrabajadores());
                    break;

                case "2": // Ingrear un nuevo trabajador

                    // Seleccionar tipo de Trabajador
                    String tipoTrabajador;
                    boolean aux = true;
                    do {
                        tipoTrabajador = input("Seleccione una opción:\n1. Panadero\n2. Vendedor\n3. Mensajero");
                        if (!esNumerico(tipoTrabajador) || Integer.parseInt(tipoTrabajador) < 1
                                || Integer.parseInt(tipoTrabajador) > 3) {
                            msg("Opcion incorrecta");
                        } else
                            aux = false;
                    } while (aux);

                    // Recolectar datos basicos
                    //      Nombres y apellidos
                    String NombreTrabajador;
                    String ApellidoTrabajador;
                    aux = true;
                    do {
                        NombreTrabajador = input("Nombres del trabajador:").trim();
                        ApellidoTrabajador = input("Apellidos del trabajador:").trim();
                        if (!NombreTrabajador.isEmpty() || !ApellidoTrabajador.isEmpty()) aux = false;
                    } while (aux);

                    //      Cedula
                    String CC;
                    aux = true;
                    do {
                        CC = input("Cedula del trabajador:");
                        if (esNumerico(CC) && (CC.length() >= 6 && CC.length() <= 10)) aux = false;
                        else msg("Cedula Incorrecta (6<CC<10)");

                    } while (aux);

                    //      Edad.
                    String edad;
                    aux = true;
                    do {
                        edad = input("Ingrese la edad");
                        if (!esNumerico(edad) || Byte.parseByte(edad) < 18) {
                            msg("Edad invalida (Edad > 18)");
                        } else
                            aux = false;
                    } while (aux);

                    // Obtener experiencia dependiendo del tipo de trabajador
                    String exp = "";
                    if (tipoTrabajador.equals("1") || tipoTrabajador.equals("2")) {
                        aux = true;
                        do {
                            exp = input("Ingrese los años de experiencia");
                            if (esNumerico(exp) && Byte.parseByte(exp) > 0) aux = false;
                            else msg("Experiencia invalida (exp > 0)");

                        } while (aux);
                    }

                    // Obtener eps dependiendo del tipo de trabajador
                    String eps = "";
                    if (tipoTrabajador.equals("2") || tipoTrabajador.equals("3")) {
                        eps = Eps();
                    }

                    if (tipoTrabajador.equals("1")) { // Si es panadero
                        logica.IngresarTrabajador(new Panadero(
                                new Persona(NombreTrabajador, ApellidoTrabajador, CC, Byte.parseByte(edad)),
                                Byte.parseByte(exp)));

                    } else if (tipoTrabajador.equals("2")) { // Si es vendedor
                        logica.IngresarTrabajador(new Vendedor(
                                new Persona(NombreTrabajador, ApellidoTrabajador, CC, Byte.parseByte(edad)),
                                Byte.parseByte(exp), eps));

                    } else { // Si es mensajero
                        String arl = arl();
                        String pension = pension();
                        logica.IngresarTrabajador(new Mensajero(
                                new Persona(NombreTrabajador, ApellidoTrabajador, CC, Byte.parseByte(edad)), eps,
                                arl, pension));
                    }
                    break;

                case "3": // Buscar
                    msg(logica.BuscarTrabajador(input("Ingrese la cedula del trabjador a buscar")));
                    break;

                case "4": // Promedio de trabajadores en un rango de años de experiencia determinada
                    break;

                case "5":
                    String eps2 = Eps();
                    msg(logica.PorcentajeEps(eps2) + "%");
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

    public boolean esNumerico(String cadena) {
        return cadena != null && cadena.matches("[0-9.]+");
    }

    public String Eps() { // se puede simplificar con vectores
        String[] eps = {"sura", "savia salud", "salud total"};
        while (true) {
            String opt = input("Seleccione la Eps:\n1. Sura\n2. Savia salud\n3. Salud total");
            if (!esNumerico(opt) && Integer.parseInt(opt) >= 1 && Integer.parseInt(opt) <= 3) {
                return eps[Integer.parseInt(opt) - 1];
            }
            msg("Opcion incorrecta.");
        }
    }

    public String arl() {
        String[] arl = {"colmena", "colpatria", "segurosalfa"};
        while (true) {
            String opt = input("Seleccione la Eps:\n1. Colmena\n2. Colpatria\n3. Segurosalfa");
            if (!esNumerico(opt) && Integer.parseInt(opt) >= 1 && Integer.parseInt(opt) <= 3) {
                return arl[Integer.parseInt(opt) - 1];
            }
            msg("Opcion incorrecta.");
        }
    }

    public String pension() {
        String[] pensiones = {"porvenir", "cesanitas", "colpensiones"};
        while (true) {
            String opt = input("Seleccione la Pension:\n1. Porvenir\n2. Cesanitas\n3. Colpensiones");
            if (!esNumerico(opt) && Integer.parseInt(opt) >= 1 && Integer.parseInt(opt) <= 3) {
                return pensiones[Integer.parseInt(opt) - 1];
            }
            msg("Opcion incorrecta.");
        }
    }
}



