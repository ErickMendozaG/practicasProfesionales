
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class TipoEstadoPostulacionImplementacion implements TipoEstadoPostulacion{
    
    private int nroTipoEstadoPostulacion;
    private String nombreTipoEstadoPostulacion;

    /*Métodos de la Clase TipoEstadoPostulacionImplementacion*/

    /* GET */
    
    @Override
    public int getNroTipoEstadoPostulacion() {
        return nroTipoEstadoPostulacion;
    }
    
    @Override
    public String getNombreTipoEstadoPostulacion() {
        return nombreTipoEstadoPostulacion;
    }
    
    /* SET */
    
    @Override
    public void setNroTipoEstadoPostulacion(int nroTipoEstadoPostulacion) {
        this.nroTipoEstadoPostulacion = nroTipoEstadoPostulacion;
    }
    
    @Override
    public void setNombreTipoEstadoPostulacion(String nombreTipoEstadoPostulacion) {
        this.nombreTipoEstadoPostulacion = nombreTipoEstadoPostulacion;
    }
    
}
