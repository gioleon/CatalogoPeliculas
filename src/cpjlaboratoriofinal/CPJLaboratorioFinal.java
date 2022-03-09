package cpjlaboratoriofinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import negocio.CatalogoPeliculasImpl;

public class CPJLaboratorioFinal {

    public static void main(String[] args) {
        CatalogoPeliculasImpl catalogoPelicula = new CatalogoPeliculasImpl();
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el nombre del archivo: ");
        String nombreArchivo = sc.nextLine();
        int opcion = 1;
        while (opcion != 0) {
            opciones();
            opcion = sc.nextInt();
            if (opcion == 1) {
                catalogoPelicula.iniciarArchivo(nombreArchivo);
            } else if (opcion == 2) {
                String nombre = sc.nextLine();
                System.out.println("Introduce el nombre de la pelicula: ");
                String nombrePelicula = sc.nextLine();
                catalogoPelicula.agregarPelicula(nombrePelicula, nombreArchivo);
            } else if (opcion == 3) {
               catalogoPelicula.listarPelicula(nombreArchivo);
            } else if (opcion == 4) {
                String nombre = sc.nextLine();

                System.out.println("Nombre de la pelicula a buscar: ");
                String nombrePelicula = sc.nextLine();
                catalogoPelicula.buscarPelicula(nombreArchivo, nombrePelicula);
            } else if (opcion == 0) {
                break;
            } else {
                System.out.println("Ingrese una opcion válida.");
            }

        }

    }

    public static void opciones() {
        System.out.println("Eliga una opción: ");
        System.out.println("1. Iniciar catalogo peliculas");
        System.out.println("2. Agregar pelocula");
        System.out.println("3. Listar peliculas");
        System.out.println("4. Buscar pelicula");
        System.out.println("0. Salir");
    }

}
