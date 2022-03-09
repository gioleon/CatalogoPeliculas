package excepciones;

import java.io.IOException;

public class LecturaDatosEx extends IOException{
    public LecturaDatosEx(String mensaje){
        super(mensaje);
    }
}
