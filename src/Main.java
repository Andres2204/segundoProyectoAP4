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

        MenuPrincipal menu = new MenuPrincipal("Panaderia");
        menu.menu();
    }
}