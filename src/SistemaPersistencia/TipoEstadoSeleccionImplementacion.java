
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class TipoEstadoSeleccionImplementacion implements TipoEstadoSeleccion{
    
    private int nroTipoEstadoSeleccion;   
    private String nombreTipoEstadoSeleccion;
    
    /* Métodos de la Clase TipoEstadoSeleccionImplementacion */
    
    /* SET */
    
    @Override
    public void setNroTipoEstadoSeleccion(int nroTipoEstadoSeleccion) {
        this.nroTipoEstadoSeleccion = nroTipoEstadoSeleccion;
    }
    
    @Override
    public void setNombreTipoEstadoSeleccion(String nombreTipoEstadoSeleccion) {
        this.nombreTipoEstadoSeleccion = nombreTipoEstadoSeleccion;
    } 
    
    /* GET */
    
    @Override
    public int getNroTipoEstadoSeleccion() {
        return nroTipoEstadoSeleccion;
    }
    
    @Override
    public String getNombreTipoEstadoSeleccion() {
        return nombreTipoEstadoSeleccion;
    }  
    
}
