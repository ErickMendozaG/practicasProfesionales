
package SistemaPersistencia;

import java.sql.Date;
import java.sql.Time;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class EstadoProyectoAgente extends Agente implements EstadoProyecto{

    private EstadoProyectoImplementacion estadoProyecto;
    
    private String OIDTipoEstadoProyecto;
    private boolean heBuscadoTipoEstadoProyecto;
    
    private String OIDProyecto;
    
    /* Métodos de la Clase EstadoProyectoAgente */
    
    /* SET */
    
    public void setEstadoProyecto(EstadoProyectoImplementacion estadoProyecto) {
        this.estadoProyecto = estadoProyecto;
    }

    public void setOIDTipoEstadoProyecto(String OIDTipoEstadoProyecto) {
        this.OIDTipoEstadoProyecto = OIDTipoEstadoProyecto;
    }

    public void setHeBuscadoTipoEstadoProyecto(boolean heBuscadoTipoEstadoProyecto) {
        this.heBuscadoTipoEstadoProyecto = heBuscadoTipoEstadoProyecto;
    }

    public void setOIDProyecto(String OIDProyecto) {
        this.OIDProyecto = OIDProyecto;
    }
        
    /* GET */
    
    public EstadoProyectoImplementacion getEstadoProyecto() {
        return estadoProyecto;
    }

    public String getOIDTipoEstadoProyecto() {
        return OIDTipoEstadoProyecto;
    }

    public boolean isHeBuscadotipoEstadoProyecto() {
        return heBuscadoTipoEstadoProyecto;
    }

    public String getOIDProyecto() {
        return OIDProyecto;
    }

    /* Métodos Implementados de la Interfaz EstadoProyecto*/
    
    /* SET */
    
    @Override
    public void setFechaEstadoProyecto(Date fechaEstadoProyecto) {
        estadoProyecto.setFechaEstadoProyecto(fechaEstadoProyecto);
        super.setModificado(true);
    }

    @Override
    public void setHoraEstadoProyecto(Time horaEstadoProyecto) {
        estadoProyecto.setHoraEstadoProyecto(horaEstadoProyecto);
        super.setModificado(true);
    }

    @Override
    public void setTipoEstadoProyecto(TipoEstadoProyecto tipoEstadoProyecto) {
        estadoProyecto.setTipoEstadoProyecto(tipoEstadoProyecto);
        Agente agente = (Agente) tipoEstadoProyecto;
        this.OIDTipoEstadoProyecto = agente.getOID();
        super.setModificado(true);
    }

    /* GET */
    
    @Override
    public Date getFechaEstadoProyecto() {
        return estadoProyecto.getFechaEstadoProyecto();
    }

    @Override
    public Time getHoraEstadoProyecto() {
        return estadoProyecto.getHoraEstadoProyecto();
    }

    @Override
    public TipoEstadoProyecto getTipoEstadoProyecto() {
        
        if (heBuscadoTipoEstadoProyecto == true){
            return estadoProyecto.getTipoEstadoProyecto();
        }
        else{
            TipoEstadoProyecto tipoEstProy = (TipoEstadoProyecto) FachadaPersistenciaInterna.getInstancia().buscar("TipoEstadoProyecto", OIDTipoEstadoProyecto);
            estadoProyecto.setTipoEstadoProyecto(tipoEstProy);
            this.setHeBuscadoTipoEstadoProyecto(true);
            return tipoEstProy;
        }    
        
    }
    
}
