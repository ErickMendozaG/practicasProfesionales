
package SistemaPersistencia;

import java.sql.SQLException;
import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class FachadaPersistencia {
    
    /* <<Singleton>> */
    
    private static FachadaPersistencia instancia= new FachadaPersistencia();
    
    private FachadaPersistencia(){}
    
    public static FachadaPersistencia getInstancia(){
        return instancia;
    }
    
    /* Metodos Públicos */
    
    public Vector buscar(String nombreEntidad, Vector<Criterio> criterios){
        
        return FachadaPersistenciaInterna.getInstancia().buscar(nombreEntidad, criterios);
        
    }
    
    public void guardar(String nombreEntidad, Object entidad){
        
        FachadaPersistenciaInterna.getInstancia().guardar(nombreEntidad, entidad);
    }
    
    public void eliminar(String nombreEntidad, Object entidad){
        
        FachadaPersistenciaInterna.getInstancia().eliminar(nombreEntidad, entidad);
        
    }
}
