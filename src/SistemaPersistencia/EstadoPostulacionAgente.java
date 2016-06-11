
package SistemaPersistencia;

import java.sql.Date;
import java.sql.Time;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class EstadoPostulacionAgente extends Agente implements EstadoPostulacion{

    private EstadoPostulacionImplementacion estadopostulacion;
    
    private String OIDTipoEstadoPostulacion;
    private boolean heBuscadoTipoEstadoPostulacion;
    
    private String OIDPostulacionProyectoCargo;/*es para la relacion*/
    
    /* Métodos de la Clase EstadoPostulacionAgente */
    
    /* SET */
    
    public void setEstadopostulacion(EstadoPostulacionImplementacion estadopostulacion) {
        this.estadopostulacion = estadopostulacion;
    }

    public void setOIDTipoEstadoPostulacion(String OIDTipoEstadoPostulacion) {
        this.OIDTipoEstadoPostulacion = OIDTipoEstadoPostulacion;
    }

    public void setHeBuscadoTipoEstadoPostulacion(boolean heBuscadoTipoEstadoPostulacion) {
        this.heBuscadoTipoEstadoPostulacion = heBuscadoTipoEstadoPostulacion;
    }

    public void setOIDPostulacionProyectoCargo(String OIDPostulacionProyectoCargo) {
        this.OIDPostulacionProyectoCargo = OIDPostulacionProyectoCargo;
    }
        
    /* GET */
    
    public EstadoPostulacionImplementacion getEstadopostulacion() {
        return estadopostulacion;
    }

    public String getOIDTipoEstadoPostulacion() {
        return OIDTipoEstadoPostulacion;
    }

    public boolean isHeBuscadoTipoEstadoPostulacion() {
        return heBuscadoTipoEstadoPostulacion;
    }

    public String getOIDPostulacionProyectoCargo() {
        return OIDPostulacionProyectoCargo;
    }
        
    /* Métodos Implementados de la Interfaz EstadoPostulacion */
    
    /* SET */
    
    @Override
    public void setFechaEstadoPostulacion(Date fechaEstadoPostulacion) {
        estadopostulacion.setFechaEstadoPostulacion(fechaEstadoPostulacion);
        super.setModificado(true);
    }

    @Override
    public void setHoraEstadoPostulacion(Time horaEstadoPostulacion) {
        estadopostulacion.setHoraEstadoPostulacion(horaEstadoPostulacion);
        super.setModificado(true);
    }

    @Override
    public void setTipoEstadoPostulacion(TipoEstadoPostulacion tipoEstadoPostulacion) {
        estadopostulacion.setTipoEstadoPostulacion(tipoEstadoPostulacion);
        Agente agente = (Agente) tipoEstadoPostulacion;
        this.OIDTipoEstadoPostulacion = agente.getOID();
        super.setModificado(true);
    }

    /* GET */
    
    @Override
    public Date getFechaEstadoPostulacion() {
        return estadopostulacion.getFechaEstadoPostulacion();
    }

    @Override
    public Time getHoraEstadoPostulacion() {
        return estadopostulacion.getHoraEstadoPostulacion();
    }

    @Override
    public TipoEstadoPostulacion getTipoEstadoPostulacion() {
        
        if (heBuscadoTipoEstadoPostulacion == true){
            return estadopostulacion.getTipoEstadoPostulacion();
        }
        else{
            TipoEstadoPostulacion tipoEstPost = (TipoEstadoPostulacion) FachadaPersistenciaInterna.getInstancia().buscar("TipoEstadoPostulacion", OIDTipoEstadoPostulacion);
            estadopostulacion.setTipoEstadoPostulacion(tipoEstPost);
            this.setHeBuscadoTipoEstadoPostulacion(true);
            return tipoEstPost;
        }
        
    }
    
}
