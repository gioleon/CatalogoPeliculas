package negocio;
import datos.AccesoDatos;
import domain.Pelicula;

public class CatalogoPeliculasImpl implements IACatalogoPeliculas{
    public AccesoDatos datos = new AccesoDatos();
   
    public CatalogoPeliculasImpl(){
        
    }

    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        this.datos.escribir(pelicula, nombreArchivo, true);
    }

    @Override
    public void listarPelicula(String nombreArchivo) {
        System.out.println(this.datos.listar(nombreArchivo));
    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {
        System.out.println(this.datos.buscar(nombreArchivo, buscar));
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        this.datos.crear(nombreArchivo);
    }
    
    
}
