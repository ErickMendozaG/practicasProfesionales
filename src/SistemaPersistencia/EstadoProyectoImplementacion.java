
package SistemaPersistencia;

import java.sql.Date;
import java.sql.Time;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class EstadoProyectoImplementacion implements EstadoProyecto{
    
    private Date fechaEstadoProyecto;
    private Time horaEstadoProyecto;
    
    private TipoEstadoProyecto tipoEstadoProyecto;

    /* Métodos de la Clase EstadoProyectoImplementacion */
    
    /* SET */
    
    @Override
    public void setFechaEstadoProyecto(Date fechaEstadoProyecto) {
        this.fechaEstadoProyecto = fechaEstadoProyecto;
    }
    
    @Override
    public void setHoraEstadoProyecto(Time horaEstadoProyecto) {
        this.horaEstadoProyecto = horaEstadoProyecto;
    }
    
    @Override
    public void setTipoEstadoProyecto(TipoEstadoProyecto tipoEstadoProyecto) {
        this.tipoEstadoProyecto = tipoEstadoProyecto;
    }

    /* GET */
    
    @Override
    public Date getFechaEstadoProyecto() {
        return fechaEstadoProyecto;
    }
    
    @Override
    public Time getHoraEstadoProyecto() {
        return horaEstadoProyecto;
    }
    
    @Override
    public TipoEstadoProyecto getTipoEstadoProyecto() {
        return tipoEstadoProyecto;
    }
    
}
