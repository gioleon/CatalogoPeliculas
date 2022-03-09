package datos;
import domain.Pelicula;
import java.util.*;


public interface IAAccesoDatos {
    
    boolean existe(String nombreArchivo);
    
    List<Pelicula> listar(String nombre);
    
    void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar);
    
    String buscar(String nombreArchivo, String buscar);

    void crear(String nombreArchivo);
    
    void borrar(String nombreArchivo);
    
    
    
    
    
}
