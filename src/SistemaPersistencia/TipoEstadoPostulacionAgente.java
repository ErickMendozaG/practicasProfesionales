
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class TipoEstadoPostulacionAgente extends Agente implements TipoEstadoPostulacion{
    
    private TipoEstadoPostulacionImplementacion tipoEstadoPostulacion;

    /* Métodos de la Clase TipoEstadoPostulacionAgente */
    
    public void setTipoEstadoPostulacion(TipoEstadoPostulacionImplementacion tipoEstadoPostulacion) {
        this.tipoEstadoPostulacion = tipoEstadoPostulacion;
    }
    
    public TipoEstadoPostulacionImplementacion getTipoEstadoPostulacion() {
        return tipoEstadoPostulacion;
    }
    
    /* Métodos Implementados de la Interfaz TipoEstadoPostulacion */

    /* GET */
    
    @Override
    public int getNroTipoEstadoPostulacion(){
        return tipoEstadoPostulacion.getNroTipoEstadoPostulacion();
    }
    
    @Override
    public String getNombreTipoEstadoPostulacion(){
        return tipoEstadoPostulacion.getNombreTipoEstadoPostulacion();
    }
    
    /* SET */
    
    @Override
    public void setNroTipoEstadoPostulacion(int nroTipoEstadoPostulacion){
        tipoEstadoPostulacion.setNroTipoEstadoPostulacion(nroTipoEstadoPostulacion);
        super.setModificado(true);
    }
    
    @Override
    public void setNombreTipoEstadoPostulacion(String nombreTipoEstadoPostulacion){
        tipoEstadoPostulacion.setNombreTipoEstadoPostulacion(nombreTipoEstadoPostulacion);
        super.setModificado(true);
    }
    
}
