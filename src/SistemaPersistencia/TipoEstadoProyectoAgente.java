
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class TipoEstadoProyectoAgente extends Agente implements TipoEstadoProyecto{
    
    private TipoEstadoProyectoImplementacion tipoEstadoProyecto;
    
    /* Métodos de la Clase TipoEstadoProyectoAgente */

    public void setTipoEstadoProyecto(TipoEstadoProyectoImplementacion tipoEstadoProyecto) {
        this.tipoEstadoProyecto = tipoEstadoProyecto;
    }
    
    public TipoEstadoProyectoImplementacion getTipoEstadoProyecto() {
        return tipoEstadoProyecto;
    }    
    
    /* Métodos Implementados de la Interfaz TipoEstadoProyecto */
    
    /* SET */
    
    @Override
    public void setNroTipoEstadoProyecto(int nroTipoEstadoProyecto){
        tipoEstadoProyecto.setNroTipoEstadoProyecto(nroTipoEstadoProyecto);
        super.setModificado(true);
    }
    
    @Override
    public void setNombreTipoEstadoProyecto(String nombreTipoEstadoProyecto){
        tipoEstadoProyecto.setNombreTipoEstadoProyecto(nombreTipoEstadoProyecto);
        super.setModificado(true);
    }  
    
    /* GET */
    
    @Override
    public int getNroTipoEstadoProyecto(){
        return tipoEstadoProyecto.getNroTipoEstadoProyecto();
    }
    
    @Override
    public String getNombreTipoEstadoProyecto(){
        return tipoEstadoProyecto.getNombreTipoEstadoProyecto();
    }
    
}
