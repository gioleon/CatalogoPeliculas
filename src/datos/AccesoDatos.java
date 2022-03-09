package datos;

import domain.Pelicula;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccesoDatos implements IAAccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) {
        var archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombre) {
        var peliculas = new ArrayList<Pelicula>();
        peliculas.add(new Pelicula("No hay peliculas en el catalogo"));
        if (existe(nombre)) {
            peliculas.clear();
            File archivo = new File(nombre);
            try {
                var entrada = new BufferedReader(new FileReader(archivo));
                String lectura = entrada.readLine();
                while (lectura != null) {
                    Pelicula pelicula = new Pelicula(lectura);
                    peliculas.add(pelicula);
                    lectura = entrada.readLine();
                }
                entrada.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {

            }
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) {
        if (existe(nombreArchivo)) {
            File archivo = new File(nombreArchivo);
            try {
                PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
                salida.println(pelicula.getNombre());
                salida.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } else {
            System.out.println("No existe el archivo \"%s\"".formatted(nombreArchivo));
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) {
        String lectura = "";
        if (existe(nombreArchivo)) {
            File archivo = new File(nombreArchivo);
            try {
                var entrada = new BufferedReader(new FileReader(nombreArchivo));
                lectura = entrada.readLine();
                while (lectura != null) {
                    if (lectura.equals(buscar)) {
                        lectura = "La pelicula \"%s\" se encuentra en el catalogo".formatted(lectura);
                        break;
                    }
                    lectura = entrada.readLine();
                }
                if(lectura==null){
                    lectura = "La pelicula \"%s\" no está en el catalogo".formatted(buscar);
                }
                entrada.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return lectura;
    }

    @Override
    public void crear(String nombreArchivo) {
        if (!existe(nombreArchivo)) {
            File archivo = new File(nombreArchivo);
            try {
                PrintWriter salida = new PrintWriter(archivo);
                salida.close();
                System.out.println("Se ha creado el archivo \"%s\" y se ha iniciado el catalogo".formatted(nombreArchivo));
            } catch (FileNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo\"%s\" se ha iniciado".formatted(nombreArchivo));
        }
    }

    @Override
    public void borrar(String nombreArchivo) {
        if (existe(nombreArchivo)) {
            File archivo = new File(nombreArchivo);
            archivo.delete();
        } else {
            System.out.println("No existe el fichero \"%s\"".formatted(nombreArchivo));
        }
    }

}
